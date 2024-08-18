package br.com.swiftbank.controller;

import br.com.swiftbank.dto.holder.*;
import br.com.swiftbank.model.Holder;
import br.com.swiftbank.service.HolderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/holder")
public class HolderController {

  private final HolderService holderService;


  @PostMapping
  @Transactional
  public ResponseEntity<HolderDetailedDTO> create(@RequestBody @Valid HolderCreateDTO dto, UriComponentsBuilder uriBuilder ) {
    var holder = HolderCreateDTO.toEntity(dto);
    holderService.create(holder);

    var uri = uriBuilder.path("/holder/{id}").buildAndExpand(holder.getId()).toUri();

    return ResponseEntity.created(uri).body(new HolderDetailedDTO(holder));
  }

  @GetMapping("/{id}")
  public ResponseEntity<HolderDetailedDTO> detail(@PathVariable Long id) {
    var holder = holderService.detail(id);

    return ResponseEntity.ok(holder);
  }

  @PutMapping
  @Transactional
  public ResponseEntity<HolderDetailedDTO> update(@RequestBody @Valid HolderUpdateDTO dto) {
    var holder = holderService.update(dto);

    return ResponseEntity.ok(holder);
  }

  @GetMapping
  public ResponseEntity<Page<HolderListDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
    var holders = holderService.list(pageable);

    return ResponseEntity.ok(holders);
  }

  @DeleteMapping
  @Transactional
  public ResponseEntity<Void> delete(@RequestBody @Valid HolderDeleteDTO dto) {
    holderService.delete(dto.cpf());

    return ResponseEntity.noContent().build();
  }

}
