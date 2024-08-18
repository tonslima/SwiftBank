package br.com.swiftbank.dto.address;

import br.com.swiftbank.model.Address;
import jakarta.validation.constraints.NotBlank;

public record AddressDTO(

  @NotBlank
  String street,

  @NotBlank
  String number,

  String complement,

  @NotBlank
  String district,

  @NotBlank
  String cep,

  @NotBlank
  String city,

  @NotBlank
  String uf,

  @NotBlank
  String country

) {

  public static Address toEntity(AddressDTO dto) {
    return new Address(dto.street,dto.number, dto.complement, dto.district, dto.cep, dto.city, dto.uf, dto.country);
  }

}
