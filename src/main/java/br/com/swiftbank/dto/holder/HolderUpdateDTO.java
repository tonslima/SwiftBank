package br.com.swiftbank.dto.holder;

import br.com.swiftbank.dto.address.AddressDTO;
import br.com.swiftbank.model.Holder;
import jakarta.validation.constraints.Email;

public record HolderUpdateDTO(

  Long id,

  String name,

  @Email
  String email,

  String phone,

  AddressDTO address
) {

  public static Holder toEntity(HolderUpdateDTO dto) {
    return new Holder(dto.name,dto.email, dto.phone(), AddressDTO.toEntity(dto.address));
  }
}
