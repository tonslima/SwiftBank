package br.com.swiftbank.dto.currentaccount;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ValueDTO(

        @NotNull
        BigDecimal value
){
}
