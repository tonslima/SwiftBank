package br.com.swiftbank.controller;

import br.com.swiftbank.dto.currentaccount.ValueDTO;
import br.com.swiftbank.dto.currentaccount.BalanceDTO;
import br.com.swiftbank.dto.currentaccount.CurrentAccountCreateDTO;
import br.com.swiftbank.dto.currentaccount.CurrentAccountDetailedDTO;
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
        var balance = currentAccountService.showBalance(id);

        return ResponseEntity.ok(balance);
    }

    @PostMapping("/{id}/deposit")
    @Transactional
    public ResponseEntity<CurrentAccountDetailedDTO> deposit(@RequestBody @Valid ValueDTO amount, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder) {
      var account = currentAccountService.deposit(id, amount.value());

      return ResponseEntity.ok(new CurrentAccountDetailedDTO(account));
    }
}
