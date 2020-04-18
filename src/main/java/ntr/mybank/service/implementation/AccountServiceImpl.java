package ntr.mybank.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntr.mybank.model.Account;
import ntr.mybank.model.CreditCard;
import ntr.mybank.model.Operation;
import ntr.mybank.repository.AccountRepository;
import ntr.mybank.service.AccountService;
import ntr.mybank.service.CreditCardService;
import ntr.mybank.service.OperationService;
import ntr.mybank.utilities.Operation_Type;

@Service
public class AccountServiceImpl implements AccountService {

	Logger _logger = LogManager.getLogger(AccountServiceImpl.class);

	private OperationService operationService;
	private CreditCardService creditCardService;
	private AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, CreditCardService creditCardService, OperationService operationService)
	{
		this.accountRepository = accountRepository; 
		this.creditCardService = creditCardService; 
		this.operationService = operationService;
	}
	
	@Override
	public Operation debit(CreditCard creditCard, int amount) throws Exception 
	{
		try
		{
			Operation operation = null;
			CreditCard creditCardOrigin = creditCardService.getCreditCardByNumberCredit(creditCard.getNumberCredit());
			Account account = creditCardOrigin.getAccount();
			
			if(creditCardOrigin != null && creditCardService.isCardValid(creditCard))
			{
				operation = this.debit(account, amount);
			}
			//Carte non-valide
			else
			{
				_logger.trace("Opération annulée avec pour motif carte non valide.");
				throw new Exception();
			}
				
			return operation;
		}
		catch(Exception exception)
		{
			String msg = "(AccountServiceImpl): une erreur s'est produite lors du débit avec pour paramètres '"+creditCard+"', 'amount:"+amount+"'";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}
	
	@Override
	public Operation debit(Account account, int amount) throws Exception 
	{
		try
		{
			Operation operation = null;
			
			if(account != null && amount > 0)
			{	
				//solde insuffisant 
				if(account.getAmount() < amount) {
					_logger.trace("Opération annulée avec pour motif solde insuffisant.");
					throw new Exception();
				}
				
				//Update account
				account.setAmount( account.getAmount() - amount);
				account = this.save(account);
				operation = this.operationService.save(account, amount, Operation_Type.Debit);
			}
			
			return operation;
		}
		catch(Exception exception)
		{
			String msg = "(AccountServiceImpl): une erreur s'est produite lors du débit avec pour paramètres '"+account+"', '"+amount+"']";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}

	@Override
	public Operation credit(CreditCard creditCard, int amount) throws Exception {
		try
		{
			Operation operation = null;
			CreditCard creditCardOrigin = creditCardService.getCreditCardByNumberCredit(creditCard.getNumberCredit());
			Account account = creditCardOrigin.getAccount();
			
			if(creditCardOrigin != null && creditCardService.isCardValid(creditCardOrigin))
			{
				operation = this.credit(account, amount);
			}
			//Carte non-valide
			else
			{
				_logger.trace("Opération annulée avec pour motif carte non valide.");
				throw new Exception();
			}
				
			return operation;
		}
		catch(Exception exception)
		{
			String msg = "(AccountServiceImpl): une erreur s'est produite lors du crédit du compte avec pour paramètres '"+creditCard+"', 'amount:"+amount+"'";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}
	
	@Override
	public Operation credit(Account account, int amount) throws Exception 
	{
		try
		{
			Operation operation = null;
		
			if(account != null && amount > 0)
			{					
				//Update account
				account.setAmount( account.getAmount() + amount);
				account = this.save(account);
				operation = this.operationService.save(account, amount, Operation_Type.Credit);
			}
			
			return operation;
		}
		catch(Exception exception)
		{
			String msg = "(AccountServiceImpl): une erreur s'est produite lors du crédit avec pour paramètres '"+account+"', 'amount:"+amount+"'";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}

	@Override
	public Account save(Account account) throws Exception
	{
		try
		{
			return accountRepository.save(account);
		}
		catch(Exception exception)
		{
			String msg = "(AccountServiceImpl): une erreur s'est produite lors de l'enregistrement avec pour paramètres '"+account+"'";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}

}
