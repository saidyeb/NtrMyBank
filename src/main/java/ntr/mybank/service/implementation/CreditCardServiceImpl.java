package ntr.mybank.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntr.mybank.bo.BoCreditCard;
import ntr.mybank.model.Account;
import ntr.mybank.model.CreditCard;
import ntr.mybank.repository.CreditCardRepository;
import ntr.mybank.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	Logger _logger = LogManager.getLogger(CreditCardServiceImpl.class);
	
	private CreditCardRepository creditCardRepository;  
	
	@Autowired 
	public CreditCardServiceImpl(CreditCardRepository creditCardRepository)
	{
		this.creditCardRepository = creditCardRepository;
	}
	
	@Override
	public CreditCard getCreditCardByAccount(Account account) throws Exception 
	{
		try
		{
			CreditCard creditCard = null;
			
			if(account != null)
				creditCardRepository.findByAccount(account);
			
			return creditCard;
		}
		catch(Exception exception)
		{
			String msg = "(CreditCardServiceImpl): une erreur s'est produite lors de la récuperation du credit card avec pour paramètres [account:'"+account+"']";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}
	
	@Override
	public CreditCard getCreditCardByNumberCredit(int number) throws Exception 
	{
		try
		{
			CreditCard creditCard = creditCardRepository.findByNumberCredit(number);
			return creditCard;
		}
		catch(Exception exception)
		{
			String msg = "(CreditCardServiceImpl): une erreur s'est produite lors de la récuperation du credit card avec pour paramètres [numberCredit:'"+number+"']";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}

	@Override
	public boolean isCardValid(BoCreditCard boCreditCard) throws Exception 
	{
		try
		{
			boolean isValid = false;
			
			if(creditCardRepository.existsByNumberCreditAndCVC(boCreditCard.getNumberCredit(), boCreditCard.getCvc()))
			{
				CreditCard CreditCardOriginal = creditCardRepository.findByNumberCredit(boCreditCard.getNumberCredit());
				
				if( CreditCardOriginal.getDateExpire() == boCreditCard.getDateExpire() )
				{
					isValid = true;
				}
			}
				
			return isValid;
		}
		catch(Exception exception)
		{
			String msg = "(CreditCardServiceImpl): une erreur s'est produite lors de la validation du credit card avec pour paramètres '"+boCreditCard+"'";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}

}
