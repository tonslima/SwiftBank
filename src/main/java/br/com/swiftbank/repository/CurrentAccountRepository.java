package br.com.swiftbank.repository;

import br.com.swiftbank.model.CurrentAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

	CurrentAccount findByNumberAndAgency(String number, String agency);

	Page<CurrentAccount> findAllByActiveTrue(Pageable pageable);
}
