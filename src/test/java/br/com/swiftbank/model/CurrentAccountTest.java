package br.com.swiftbank.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {

  @Test
  @DisplayName("when account has not enough amount to withdraw should throw an exception")
  public void teste1() {
    var currentAccount = new CurrentAccount(new Holder(), "1", "1");

    assertThrows(Exception.class, () -> currentAccount.withdraw(BigDecimal.TEN));
    assertEquals(BigDecimal.ZERO, currentAccount.getBalance());
  }

  @Test
  @DisplayName("when account has enough amount to withdraw should withdraw")
  public void teste2() throws Exception {
    var currentAccount = new CurrentAccount(1L, new Holder(), "1", "1", BigDecimal.TEN, true);

    currentAccount.withdraw(BigDecimal.TEN);
    assertEquals(BigDecimal.ZERO, currentAccount.getBalance());
  }

  @Test
  @DisplayName("when try to withdraw zero should throw an exception")
  public void teste3() {
    var currentAccount = new CurrentAccount(new Holder(), "1", "1");

    assertThrows(Exception.class, () -> currentAccount.withdraw(BigDecimal.ZERO));
    assertEquals(BigDecimal.ZERO, currentAccount.getBalance());
  }
}