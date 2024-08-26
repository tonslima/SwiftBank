package br.com.swiftbank.model;

import br.com.swiftbank.dto.address.AddressDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {


  private String street;
  private String number;
  private String complement;
  private String district;
  private String cep;
  private String city;
  private String uf;
  private String country;


  public Address(AddressDTO dto) {
    this.street = dto.street();
    this.number = dto.number();
    this.district = dto.district();
    this.cep = dto.cep();
    this.city = dto.city();
    this.uf = dto.uf();
    this.country = dto.country();
    this.complement = dto.complement();
  }

  public void update(Address update) {
    if (update.street != null) {
      this.street = update.street;
    }
    if (update.number != null) {
      this.number = update.number;
    }
    if (update.district != null) {
      this.district = update.district;
    }
    if (update.cep != null) {
      this.cep = update.cep;
    }
    if (update.city != null) {
      this.city = update.city;
    }
    if (update.uf != null) {
      this.uf = update.uf;
    }
    if (update.country != null) {
      this.country = update.country;
    }
    if (update.complement != null) {
      this.complement = update.complement;
    }
  }
}
