package br.com.swiftbank.service;

import br.com.swiftbank.model.CurrentAccount;
import br.com.swiftbank.model.Holder;
import br.com.swiftbank.repository.CurrentAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrentAccountService {

  private final CurrentAccountRepository repository;
  private final HolderService holderService;


  public CurrentAccount create(CurrentAccount account) {
    var holder = holderService.findByCpf(account.getHolder().getCpf());

    if (holder != null) {
      System.out.println("existe");
      account.setHolder(holder);
      repository.save(account);
    } else {
      System.out.println("nao existe");
      repository.save(account);
    }

    return account;
  }

  public CurrentAccount showBalance(Long id) {
    return repository.findById(id).get();
  }

  public CurrentAccount deposit(Long id, BigDecimal amount) throws Exception {
    var account = repository.findById(id).get();

    return account.deposit(amount);
  }

  public CurrentAccount withdraw(Long id, BigDecimal amount) throws Exception {
    var account = repository.findById(id).get();

    return account.withdraw(amount);
  }

  public CurrentAccount transfer(Long id, BigDecimal amount, String number, String agency) throws Exception {
    var oAccount = repository.findById(id).get();
    oAccount.withdraw(amount);

    var dAccount = repository.findByNumberAndAgency(number, agency);
    dAccount.deposit(amount);

    return oAccount;
  }

	public Page<CurrentAccount> list(Pageable pageable) {
    return repository.findAllByActiveTrue(pageable);
	}

  public CurrentAccount update(Long id , Holder update) {
     CurrentAccount account = repository.findById(id).get();
     account.getHolder().update(update);

     return account;
  }

  public CurrentAccount detail(Long id) {
    return repository.findById(id).get();
  }

  public void delete(Long id) {
    repository.findById(id).get().delete();
  }
}
