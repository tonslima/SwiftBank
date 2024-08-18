package br.com.swiftbank.dto.holder;

import br.com.swiftbank.dto.address.AddressDTO;
import br.com.swiftbank.model.Holder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record HolderCreateDTO(

  @NotBlank
  String name,

  @NotBlank
  @Email
  String email,

  @NotBlank
  String phone,

  @NotBlank
  @Pattern(regexp = "\\d{11}")
  String cpf,

  @NotNull
  @Valid
  AddressDTO address

) {

  public static Holder toEntity(HolderCreateDTO dto) {
    return new Holder(dto.name, dto.email(), dto.phone(), dto.cpf(), AddressDTO.toEntity(dto.address));
  }
}