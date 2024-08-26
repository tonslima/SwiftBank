package br.com.swiftbank.dto.currentaccount;

import br.com.swiftbank.dto.holder.HolderDetailedDTO;
import br.com.swiftbank.model.CurrentAccount;
import br.com.swiftbank.model.Holder;

import java.math.BigDecimal;

public record CurrentAccountDetailedDTO(

		Long id,
		String number,
		String agency,
		HolderDetailedDTO holder,
		BigDecimal balance
) {

	public CurrentAccountDetailedDTO(CurrentAccount account) {
		this(account.getId(),
				account.getNumber(),
				account.getAgency(),
				new HolderDetailedDTO(account.getHolder()),
				account.getBalance());
	}
}