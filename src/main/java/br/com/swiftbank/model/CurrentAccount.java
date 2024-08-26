package br.com.swiftbank.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "current_account")
@Entity(name = "CurrentAccount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CurrentAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "holder_id")
  private Holder holder;
  private String number;
  private String agency;
  private BigDecimal balance;
  private Boolean active;

  // create construtor
  public CurrentAccount(Holder holder, String number, String agency) {
    this.holder = holder;
    this.number = number;
    this.agency = agency;
    this.balance = new BigDecimal(0);
    this.active = true;
  }

  public CurrentAccount deposit(BigDecimal amount) throws Exception {
    if (amount.compareTo(BigDecimal.ZERO) > 0) {
      this.balance = balance.add(amount);
    } else {
      throw new Exception();
    }

    return this;
  }

  public CurrentAccount withdraw(BigDecimal amount) throws Exception {
    if (this.balance.compareTo(amount) >= 0 && amount.compareTo(BigDecimal.ZERO) > 0) {
      this.balance = balance.subtract(amount);
    } else {
      throw new Exception();
    }

    return this;
  }

  public void delete() {
    this.active = false;
  }
}

