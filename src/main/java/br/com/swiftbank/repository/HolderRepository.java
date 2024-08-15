package br.com.swiftbank.repository;

import br.com.swiftbank.model.Holder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolderRepository extends JpaRepository<Holder, Long> {

  Holder findByCpf(String cpf);

  Page<Holder> findAllByActiveTrue(Pageable pageable);

  boolean existsByCpf(String cpf);
}
