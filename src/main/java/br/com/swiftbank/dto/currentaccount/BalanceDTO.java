package br.com.swiftbank.dto.currentaccount;

import br.com.swiftbank.model.CurrentAccount;

import java.math.BigDecimal;

public record BalanceDTO(

        Long id,
        String name,
        String number,
        String agency,
        BigDecimal balance
) {

    public BalanceDTO(CurrentAccount account) {
        this(account.getId(),
                account.getHolder().getName(),
                account.getNumber(),
                account.getAgency(),
                account.getBalance());
    }
}
