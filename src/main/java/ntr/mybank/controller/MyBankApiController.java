package ntr.mybank.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import ntr.mybank.bo.BoCreditCard;
import ntr.mybank.model.Account;
import ntr.mybank.model.Operation;
import ntr.mybank.service.AccountService;
import ntr.mybank.service.OperationService;

@Path("/mybankapicontroller")
public class MyBankApiController {
	
	@Autowired 
	private OperationService operationService;
	
	@Autowired 
	private AccountService accountService;
	
	@GET
	@Path("/getoperations")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Operation> getOperations(@QueryParam("accountId") int accountId) throws Exception
	{
		return this.operationService.getOperations(accountId);
	}
	
	@GET
	@Path("/getaccount")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Account getAccount(@QueryParam("id") int id) throws Exception
	{
		return this.accountService.getAccountById(id);
	}
	
	@POST
	@Path("/savecredit")
	@Produces(MediaType.APPLICATION_XML_VALUE)
	@Consumes(MediaType.APPLICATION_XML_VALUE)
	public Operation credit(BoCreditCard boCreditCard, @QueryParam("amount") int amount) throws Exception
	{
		return this.accountService.credit(boCreditCard, amount);
	}
	
	@POST
	@Path("/savedebit")
	@Produces(MediaType.APPLICATION_XML_VALUE)
	@Consumes(MediaType.APPLICATION_XML_VALUE)
	public Operation debit(BoCreditCard boCreditCard, @QueryParam("amount") int amount) throws Exception
	{
		return this.accountService.debit(boCreditCard, amount);
	}
		
}
