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

	public Holder(String name, String email, String phone, String cpf, Address address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.address = address;
		this.active = true;
	}

	public Holder(String name, String email, String phone, Address address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public void update(HolderUpdateDTO dto) {
		if (dto.name() != null) {
			this.name = dto.name();
		}
		if (dto.email() != null) {
			this.email = dto.email();
		}
		if (dto.phone() != null) {
			this.phone = dto.phone();
		}
		if (dto.address() != null) {
			this.address.update(dto.address());
		}
	}

	public void delete() {
		this.active = false;
	}
}
