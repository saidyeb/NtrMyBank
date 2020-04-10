package ntr.mybank.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import ntr.mybank.utilities.Account_Status;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Acct_Id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private Users user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Bank_Id")
	private Bank bank;
	
	@Column(name="Acct_NumberAccount", unique = true)
	private String numberAccount;
	
	@Column(name="Acct_Amount")
	private double amount;
	
	@Column(name="Acct_Created")
	private Date dateCreated;
	
	@Column(name="Acct_Status")
	private Account_Status status;
	
	@Column(name="Acct_Deleted")
	private Boolean deleted;

	public Account() {
		super();
	}

	public Account(Users user, Bank bank, String numberAccount, double amount, Date dateCreated, Account_Status status) {
		super();
		this.user = user;
		this.bank = bank;
		this.numberAccount = numberAccount;
		this.amount = amount;
		this.dateCreated = dateCreated;
		this.status = status;
		this.deleted = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Account_Status getStatus() {
		return status;
	}

	public void setStatus(Account_Status status) {
		this.status = status;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", bank=" + bank + ", numberAccount=" + numberAccount
				+ ", amount=" + amount + ", dateCreated=" + dateCreated + ", status=" + status + ", deleted=" + deleted
				+ "]";
	}
}
