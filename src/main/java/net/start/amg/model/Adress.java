package net.start.amg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="address")
public class Adress {
	@Transient
	private String adress;
	
	@Id
	@GeneratedValue
	private Long addressId;
		
	@Column(name="ADDR_CITY")
	@NotEmpty(message = "City should not be empty")
	private String city;
	
	@Column(name="ADDR_STREET")
	@NotEmpty(message = "Street should not be empty")
	private String street;
	
	@Column(name="ADDR_HOUSE")
	@NotEmpty(message = "House should not be empty")
//	@Pattern(regexp="[0-9]", message="Should be only numbers")
	private String house;
	
	@Column(name="ADDR_FLAT")
	@NotEmpty(message = "Flat should not be empty")
//	@Pattern(regexp="[0-9]", message="Should be only numbers")
	private String flat;
	
	public Adress(String city, String street, String house, String flat) {
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;
	}
	
	public Adress(Adress newAdress) {
		this.city = newAdress.city;
		this.street = newAdress.street;
		this.house = newAdress.house;
		this.flat = newAdress.flat;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}
	
	

	public void setHouse(String house) {
		this.house = house;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public void setAdress(Adress adr) {
		this.city = adr.city;
		this.street = adr.street;
		this.house = adr.house;
		this.flat = adr.flat;
	}

	public Adress(String adress) {
		this.adress = adress;
	}
	
		
	public Adress() {
	}

	public String getAdress() {
		return adress;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	
	
}
