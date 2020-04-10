package ntr.mybank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Bank_Id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Addr_Id")
	private Address address;
	
	@Column(name="Bank_Code", unique = true)
	private int code;
	
	@Column(name="Bank_Name", unique = true)
	private String name;
	
	@Column(name="Bank_Main")
	private Boolean isMain;
	
	@Column(name="Bank_Deleted")
	private Boolean deleted;

	public Bank() {}
	
	public Bank(Address address, int code, String name, Boolean isMain) {
		super();
		this.address = address;
		this.code = code;
		this.name = name;
		this.isMain = isMain;
		this.deleted = false;
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
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsMain() {
		return isMain;
	}

	public void setIsMain(Boolean isMain) {
		this.isMain = isMain;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", address=" + address + ", code=" + code + ", name=" + name + ", isMain=" + isMain
				+ ", deleted=" + deleted + "]";
	}

}
