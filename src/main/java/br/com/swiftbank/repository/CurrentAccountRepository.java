package br.com.swiftbank.repository;

import br.com.swiftbank.model.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
    List<CurrentAccount> findByHolderCpf(String cpf);
}
