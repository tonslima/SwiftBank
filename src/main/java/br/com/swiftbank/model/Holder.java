package br.com.swiftbank.model;

import br.com.swiftbank.dto.holder.HolderUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "holder")
@Entity(name = "Holder")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Holder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String cpf;

	@Embedded
	private Address address;
	private Boolean active;

	// construtor para create
	public Holder(String name, String email, String phone, String cpf, Address address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.address = address;
		this.active = true;
	}

	// construtor para update
	public Holder(String name, String email, String phone, Address address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public Holder update(Holder update) {
		if (update.name != null) {
			this.name = update.name;
		}
		if (update.email != null) {
			this.email = update.email;
		}
		if (update.phone != null) {
			this.phone = update.phone;
		}
		if (update.address != null) {
			this.address.update(update.address);
		}

		return this;
	}

	public void delete() {
		this.active = false;
	}
}
