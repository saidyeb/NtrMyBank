package ntr.mybank.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Addr_Id")
	private Address address;
	
	@Column(name="User_Code", unique = true)
	private int code;
	
	@Column(name="User_Password")
	private String password;

	@Column(name="User_FirstName")
	private String firstName;
	
	@Column(name="User_LasttName")
	private String lastName;
	
	@Column(name="User_DateBirth")
	private Date dateBirth;
	
	@Column(name="User_EmailAddress")
	private String emailAddress;
	
	@Column(name="User_PhoneNumber", unique = true)
	private int phoneNumber;
	
	
	public Users() {}


	public Users(Address address, int code, String password, String firstName, String lastName,
			Date dateBirth, String emailAddress, int phoneNumber) {
		super();
		this.address = address;
		this.code = code;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getCode() {
		return this.code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDateBirth() {
		return dateBirth;
	}


	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", address=" + address + ", code=" + code + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", dateBirth=" + dateBirth
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + "]";
	} 
	
}
