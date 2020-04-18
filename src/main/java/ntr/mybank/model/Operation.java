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

import ntr.mybank.utilities.Operation_Status;
import ntr.mybank.utilities.Operation_Type;

@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Oprt_Id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Acct_Id")
	private Account account;
	
	@Column(name = "Oprt_Amount", nullable = false)
	private int amount;
	
	@Column(name="Oprt_Type")
	private Operation_Type type;
	
	@Column(name="Oprt_Status")
	private Operation_Status status;

	@Column(name="Oprt_Detail")
	private String detail;
	
	@Column(name="Oprt_DateCreated")
	private Date dateCreated;
	
	@Column(name="Oprt_Deleted")
	private Boolean deleted;

	
	public Operation() {
		super();
	}


	public Operation(Account account, Operation_Type type, Operation_Status status, String detail, Date dateCreated) {
		super();
		this.account = account;
		this.type = type;
		this.status = status;
		this.detail = detail;
		this.dateCreated = dateCreated;
		this.deleted = false;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Operation_Type getType() {
		return type;
	}


	public void setType(Operation_Type type) {
		this.type = type;
	}


	public Operation_Status getStatus() {
		return status;
	}


	public void setStatus(Operation_Status status) {
		this.status = status;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Operation [id=" + id + ", account=" + account + ", amount=" + amount + ", type=" + type + ", status="
				+ status + ", detail=" + detail + ", dateCreated=" + dateCreated + ", deleted=" + deleted + "]";
	}
}
