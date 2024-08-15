package br.com.swiftbank.service;

import br.com.swiftbank.dto.currentaccount.CurrentAccountDetailedDTO;
import br.com.swiftbank.model.CurrentAccount;
import br.com.swiftbank.repository.CurrentAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentAccountService {

  private final CurrentAccountRepository repository;
  private final HolderService holderService;

  public CurrentAccountDetailedDTO create(CurrentAccount account) {
    if (holderService.existsByCpf(account.getHolder().getCpf())) {
      System.out.println("existe");
      repository.save(account);
    } else {
      System.out.println("nao existe");
      holderService.create(account.getHolder());
      create(account);
    }

    return new CurrentAccountDetailedDTO(account);
  }
}
