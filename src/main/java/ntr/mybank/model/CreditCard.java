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

@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Card_Id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Acct_Id")
	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private Users user;
	
	@Column(name="Card_NumberCredit")
	private int numberCredit;
	
	@Column(name="Card_CVC")
	private int CVC;
	
	@Column(name="Card_DateExpire")
	private Date DateExpire;

	@Column(name="Card_Deleted")
	private Boolean deleted;

	public CreditCard() {
		super();
	}

	public CreditCard(Account account, Users user, int numberCredit, int cVC, Date dateExpire) {
		super();
		this.account = account;
		this.user = user;
		this.numberCredit = numberCredit;
		CVC = cVC;
		DateExpire = dateExpire;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getNumberCredit() {
		return this.numberCredit;
	}

	public void setNumberCredit(int numberCredit) {
		this.numberCredit = numberCredit;
	}

	public int getCVC() {
		return CVC;
	}

	public void setCVC(int cVC) {
		CVC = cVC;
	}

	public Date getDateExpire() {
		return DateExpire;
	}

	public void setDateExpire(Date dateExpire) {
		DateExpire = dateExpire;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", account=" + account + ", user=" + user + ", NumberCredit=" + numberCredit
				+ ", CVC=" + CVC + ", DateExpire=" + DateExpire + ", deleted=" + deleted + "]";
	}
	
}
