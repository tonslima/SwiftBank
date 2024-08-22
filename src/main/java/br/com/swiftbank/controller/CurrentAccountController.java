package br.com.swiftbank.controller;

import br.com.swiftbank.dto.currentaccount.*;
import br.com.swiftbank.service.CurrentAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/current-account")
public class CurrentAccountController {

    private final CurrentAccountService currentAccountService;

    @PostMapping
    @Transactional
    public ResponseEntity<CurrentAccountDetailedDTO> create(@RequestBody @Valid CurrentAccountCreateDTO dto, UriComponentsBuilder uriBuilder) {
        var account = CurrentAccountCreateDTO.toEntity(dto);
        currentAccountService.create(account);

        var uri = uriBuilder.path("/current-account/{id}").buildAndExpand(account.getId()).toUri();

        return ResponseEntity.created(uri).body(new CurrentAccountDetailedDTO(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BalanceDTO> showBalance(@PathVariable Long id) {
        var account = currentAccountService.showBalance(id);

        return ResponseEntity.ok(new BalanceDTO(account));
    }

    @PostMapping("/{id}/deposit")
    @Transactional
    public ResponseEntity<CurrentAccountDetailedDTO> deposit(@RequestBody @Valid ValueDTO amount, @PathVariable Long id) throws Exception {
      var account = currentAccountService.deposit(id, amount.value());

      return ResponseEntity.ok(new CurrentAccountDetailedDTO(account));
    }

    @PostMapping("{id}/withdraw")
    @Transactional
    public ResponseEntity<CurrentAccountDetailedDTO> withdraw(@RequestBody @Valid ValueDTO amount, @PathVariable Long id) throws Exception {
        var account = currentAccountService.withdraw(id,amount.value());

        return ResponseEntity.ok(new CurrentAccountDetailedDTO(account));
    }

    @PostMapping("{id}/transfer")
    @Transactional
    public ResponseEntity<CurrentAccountDetailedDTO> transfer(@PathVariable Long id, @RequestBody TransferDTO dto) throws Exception {

        var account = currentAccountService.transfer(id, dto.value(), dto.number(), dto.agency());

        return ResponseEntity.ok(new CurrentAccountDetailedDTO(account));
    }

}
