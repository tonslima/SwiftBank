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
    var holder = holderService.findByCpf(account.getHolder().getCpf());

    if (holder != null) {
      System.out.println("existe");
      account.setHolder(holder);
      repository.save(account);
    } else {
      System.out.println("nao existe");
      repository.save(account);
    }

    return new CurrentAccountDetailedDTO(account);
  }
}
