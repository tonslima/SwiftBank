package br.com.swiftbank.dto.holder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record HolderDeleteDTO(

		@NotNull
		Long id,

		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf
) {
}
