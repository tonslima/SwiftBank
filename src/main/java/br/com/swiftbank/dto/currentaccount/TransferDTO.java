package br.com.swiftbank.dto.currentaccount;

import java.math.BigDecimal;

public record TransferDTO(
        String number,
        String agency,
        BigDecimal value
) {
}
