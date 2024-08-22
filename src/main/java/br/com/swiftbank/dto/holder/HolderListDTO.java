package br.com.swiftbank.dto.holder;

import br.com.swiftbank.model.Address;
import br.com.swiftbank.model.Holder;

public record HolderListDTO(

		Long id,
		String name,
		String email,
		String phone,
		String cpf,
		Address address
) {

	public HolderListDTO(Holder holder) {
		this(holder.getId(),
				holder.getName(),
				holder.getEmail(),
				holder.getPhone(),
				holder.getCpf(),
				holder.getAddress());
	}
}
