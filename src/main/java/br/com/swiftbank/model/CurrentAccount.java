package br.com.swiftbank.model;

import br.com.swiftbank.dto.currentaccount.CurrentAccountCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "current_account")
@Entity(name = "CurrentAccount")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CurrentAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "holder_id")
  private Holder holder;
  private String number;
  private String agency;
  private BigDecimal balance;
  private Boolean active;

  public CurrentAccount(CurrentAccountCreateDTO dto) {
    this.holder = new Holder(dto.holder());
    this.number = dto.number();
    this.agency = dto.agency();
    this.balance = BigDecimal.ZERO;
    this.active = true;
  }
}
