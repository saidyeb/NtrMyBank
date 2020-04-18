package ntr.mybank.bo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BoCreditCard {

	private int numberCredit; 
	private int cvc; 
	private Date dateExpire;
	
	
	public BoCreditCard() {
		super();
	}
	
	public BoCreditCard(int numberCredit, int cvc, Date dateExpire) {
		super();
		this.numberCredit = numberCredit;
		this.cvc = cvc;
		this.dateExpire = dateExpire;
	}

	public int getNumberCredit() {
		return numberCredit;
	}

	public void setNumberCredit(int numberCredit) {
		this.numberCredit = numberCredit;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public Date getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}

	@Override
	public String toString() {
		return "BoCreditCard [numberCredit=" + numberCredit + ", cvc=" + cvc + ", dateExpire=" + dateExpire + "]";
	} 
	
	
}
