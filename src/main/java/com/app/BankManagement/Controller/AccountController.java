package com.app.BankManagement.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.BankManagement.Model.Account;
import com.app.BankManagement.Response.AccountResponse;
import com.app.BankManagement.Response.Constant;
import com.app.BankManagement.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addSubscription( @Valid @RequestBody Account account )
	{
		
		if(account.getCustomerType()!=null)
		{
			if(!account.getCustomerType().contentEquals("Staff") && !account.getCustomerType().contentEquals("Public"))
			{
				AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData("").setMessage("Customer type should be Staff or Public ").setStatus(false).setStatusCode(500).build();
				return ResponseEntity.ok().body(qutrixResponse);
			}
		}
		
		if(account.getAddress().getMobileNumber()!=null)
		{
			 String regex = "(0/91)?[7-9][0-9]{9}";
		    if(account.getAddress().getMobileNumber().matches(regex))
		    {
		    	
		    }
		    else
		    {
		    	AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData("").setMessage("Customer Mobile number is invalid").setStatus(false).setStatusCode(500).build();
				return ResponseEntity.ok().body(qutrixResponse);
		    }
		}
		if(account.getNominee().getMobileno()!=null)
		{
			 String regex = "(0/91)?[7-9][0-9]{9}";
		    if(account.getNominee().getMobileno().matches(regex))
		    {
		    	
		    }
		    else
		    {
		    	AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData("").setMessage("Nominee Mobile number is invalid").setStatus(false).setStatusCode(500).build();
				return ResponseEntity.ok().body(qutrixResponse);
		    }
		}
		String message="";
		Account acc=null;
		if(account.getId()==0)
		{
			 acc=accService.addAccount(account);
			 message=Constant.datastored;
		}
		else
		{
			Optional<Account> sds=accService.getsingleAccount(account.getId());
			if(sds.isPresent())
			{
				 acc=accService.addAccount(account);
				 message=Constant.update;
			}
			else
			{
				
				message=Constant.invalid;
			}
		}
		
		AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData(acc).setMessage(message).setStatus(true).setStatusCode(200).build();
		return ResponseEntity.ok().body(qutrixResponse);
		
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    	ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData(errors).setMessage(Constant.manadatoryField).setStatus(false).setStatusCode(500).build();
		return ResponseEntity.ok().body(qutrixResponse);
	    
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllAccount()
	{
		List<Account> sds=accService.getAllAccount();
		AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData(sds).setMessage(Constant.dataFetched).setStatus(true).setStatusCode(200).build();
		return ResponseEntity.ok().body(qutrixResponse);
	}
	
	@GetMapping("/getAll/{id}")
	public ResponseEntity<?> getSingleAccount(@PathVariable("id") int id)
	{
		String message="";
		Optional<Account> sds=accService.getsingleAccount(id);
		if(sds.isPresent())
		{
			message=Constant.dataFetched;
		}
		else
		{
			message=Constant.notFound;
		}
		AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData(sds).setMessage(message).setStatus(true).setStatusCode(200).build();
		return ResponseEntity.ok().body(qutrixResponse);
	}
	

	@GetMapping("/update/{id}/{status}")
	public ResponseEntity<?> update(@PathVariable boolean status, @PathVariable int id) {
		String message="";
		Account sdss=null;
		Optional<Account> sds=accService.getsingleAccount(id);
		if(sds.isPresent())
		{
			accService.updateCustomerStatus(id,status);
			message=Constant.statusChanged;
		}
		else
		{
			
		message=Constant.invalid;
		
		}
		
		AccountResponse qutrixResponse=new AccountResponse.AccountResponseResponseBuilder().setData(sds).setMessage(message).setStatus(true).setStatusCode(200).build();
		return ResponseEntity.ok().body(qutrixResponse);
	}
}
