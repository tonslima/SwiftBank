package br.com.swiftbank.service;

import br.com.swiftbank.dto.holder.HolderDetailedDTO;
import br.com.swiftbank.dto.holder.HolderListDTO;
import br.com.swiftbank.dto.holder.HolderUpdateDTO;
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

  public HolderDetailedDTO create(Holder holder) {
    repository.save(holder);

    return new HolderDetailedDTO(holder);
  }

  public Holder findById(Long id) {
    return repository.getReferenceById(id);
  }

  public Holder findByCpf(String cpf) {
    return repository.findByCpf(cpf);
  }

  public HolderDetailedDTO detail(Long id) {
    var holder = findById(id);

    return new HolderDetailedDTO(holder);
  }

  public HolderDetailedDTO update(HolderUpdateDTO dto) {
    var holder = findById(dto.id());
    holder.update(dto);

    return new HolderDetailedDTO(holder);
  }

  public Page<HolderListDTO> list(Pageable pageable) {
    var holders = repository.findAllByActiveTrue(pageable)
      .map(HolderListDTO::new);

    return holders;
  }

  public void delete(String cpf) {
    findByCpf(cpf).delete();
  }

  public boolean existsByCpf(String cpf) {
    var result = repository.existsByCpf(cpf);

    return result;
  }
}
