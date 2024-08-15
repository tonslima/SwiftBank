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

  public void update(AddressDTO address) {
    if (address.street() != null) {
      this.street = address.street();
    }
    if (address.number() != null) {
      this.number = address.number();
    }
    if (address.district() != null) {
      this.district = address.district();
    }
    if (address.cep() != null) {
      this.cep = address.cep();
    }
    if (address.city() != null) {
      this.city = address.city();
    }
    if (address.uf() != null) {
      this.uf = address.uf();
    }
    if (address.country() != null) {
      this.country = address.country();
    }
    if (address.complement() != null) {
      this.complement = address.complement();
    }
  }
}
