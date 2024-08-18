package br.com.swiftbank.controller;

import br.com.swiftbank.dto.currentaccount.CurrentAccountCreateDTO;
import br.com.swiftbank.dto.currentaccount.CurrentAccountDetailedDTO;
import br.com.swiftbank.model.CurrentAccount;
import br.com.swiftbank.service.CurrentAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/current+account")
public class CurrentAccountController {

  private final CurrentAccountService currentAccountService;

  @PostMapping
  @Transactional
  public ResponseEntity<CurrentAccountDetailedDTO> create(@RequestBody @Valid CurrentAccountCreateDTO dto , UriComponentsBuilder uriBuilder) {
    var account = CurrentAccountCreateDTO.toEntity(dto);
    currentAccountService.create(account);

    var uri = uriBuilder.path("/current+account/{id}").buildAndExpand(account.getId()).toUri();

    return ResponseEntity.created(uri).body(new CurrentAccountDetailedDTO(account));
  }
}
