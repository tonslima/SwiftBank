package br.com.swiftbank.dto.currentaccount;

import br.com.swiftbank.dto.holder.HolderCreateDTO;
import br.com.swiftbank.model.CurrentAccount;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CurrentAccountCreateDTO(

  @NotNull
  @Valid
  HolderCreateDTO holder,

  @NotBlank
  String number,

  @NotBlank
  @Pattern(regexp = "\\d{5}")
  String agency
) {

  public static CurrentAccount toEntity(CurrentAccountCreateDTO dto) {
    return new CurrentAccount(HolderCreateDTO.toEntity(dto.holder), dto.number, dto.agency);
  }
}
