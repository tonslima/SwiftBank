package br.com.swiftbank.service;

import br.com.swiftbank.model.CurrentAccount;
import br.com.swiftbank.model.Holder;
import br.com.swiftbank.repository.CurrentAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CurrentAccountServiceTest {

  @Mock
  private CurrentAccountRepository repository;

  @Mock
  private HolderService holderService;

  @InjectMocks
  private CurrentAccountService currentAccountService;

  @Test
  @DisplayName("when account exists should withdraw")
  public void teste1() throws Exception {
    when(repository.findById(any())).thenReturn(
        Optional.of(
            new CurrentAccount(
                1L,
                new Holder(),
                "1",
                "1",
                BigDecimal.TEN,
                true
            )
        )
    );

    currentAccountService.withdraw(1L, BigDecimal.TEN);

    verify(repository, times(1)).findById(any());
  }

  @Test
  @DisplayName("when account does not exist should throw an exception")
  public void teste2() {
    when(repository.findById(any())).thenReturn(Optional.empty());

    assertThrows(NoSuchElementException.class, () -> currentAccountService.withdraw(1L, BigDecimal.TEN));

    verify(repository, times(1)).findById(any());
  }
}