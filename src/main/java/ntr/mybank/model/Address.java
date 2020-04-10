package ntr.mybank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Addr_Id")
	private int id;
	
	@Column(name="Addr_Street")
	private String street;
	
	@Column(name="Addr_City")
	private String city; 
	
	@Column(name="Addr_Country")
	private String country;
	
	@Column(name="Addr_ZipCode")
	private int zipCode;
	
	public Address() {}
	
	public Address(String street, String city, String country, int zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return id;
	}

	public void setNumber(int id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", country=" + country + ", zipCode="
				+ zipCode + "]";
	}
	
	public String toFrString() {
		return street + ", " + city + ", " + country + ", " + zipCode;		
	}
		
}