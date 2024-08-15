package br.com.swiftbank.dto.holder;

import br.com.swiftbank.dto.address.AddressDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record HolderUpdateDTO(

  @NotNull
  Long id,

  String name,

  @Email
  String email,

  @Pattern(regexp = "\\d{5,20}")
  String phone,
  AddressDTO address
) {
}
