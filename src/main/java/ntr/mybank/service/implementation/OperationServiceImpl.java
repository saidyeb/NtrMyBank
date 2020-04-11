package ntr.mybank.service.implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ntr.mybank.model.Account;
import ntr.mybank.model.Operation;
import ntr.mybank.repository.OperationRepository;
import ntr.mybank.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {
	
	Logger _logger = LogManager.getLogger(OperationServiceImpl.class);
	
	@Autowired
	private OperationRepository _operationRepository;

	@Override
	public List<Operation> getOperations(Account account) throws Exception
	{
		try
		{
			List<Operation> operations = new ArrayList<Operation>();
			
			operations = _operationRepository.findByAccount(account);
			operations.removeIf(x -> x.getDeleted());
			
			return operations;
		}
		catch(Exception exception)
		{
			String msg = "(OperationServiceImpl): une erreur s'est produite lors du chargement de la liste des operations avec pour paramètres [account:'"+account+"']";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	}

	@Override
	public List<Operation> getOperationsByDateCreated(Account account, Date dateCreated) throws Exception
	{
		try
		{
			List<Operation> operations = new ArrayList<Operation>();
			
			operations = _operationRepository.findByDateCreatedAndAccount(dateCreated, account);
			//remove deleted and sort by date creation 
			operations.stream()
				.filter(x -> x.getDeleted())
				.sorted( (x, y) -> x.getDateCreated().compareTo(y.getDateCreated()) )
				.collect(Collectors.toList());
			
			return operations;
		}
		catch(Exception exception)
		{
			String msg = "(OperationServiceImpl): une erreur s'est produite lors du chargement de la liste des operations avec pour paramètres [account:'"+account+"', '"+dateCreated+"']";
			_logger.error(msg);
			throw new Exception(msg, exception);
		}
	} 

}
