package br.com.swiftbank.service;

import br.com.swiftbank.model.Holder;
import br.com.swiftbank.repository.HolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HolderService {

	private final HolderRepository repository;

	public Holder create(Holder holder) {
		repository.save(holder);

		return holder;
	}

	public Holder findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Holder detail(Long id) {
		return repository.findById(id).get();
	}

	public Holder update(Holder holder) {
		return repository.findById(holder.getId()).get();
	}

	public Page<Holder> list(Pageable pageable) {
		return repository.findAllByActiveTrue(pageable);
	}

	public void delete(Long id) {
		repository.findById(id).get().delete();
	}

	public boolean existsByCpf(String cpf) {
		return repository.existsByCpf(cpf);
	}
}
