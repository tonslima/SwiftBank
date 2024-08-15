package br.com.swiftbank.dto.address;

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
}
