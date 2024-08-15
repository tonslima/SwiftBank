package br.com.swiftbank.dto.holder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record HolderDeleteDTO(

  @NotBlank
  @Pattern(regexp = "\\d{11}")
  String cpf
) {
}
