package com.app.BankManagement.Service;
import java.util.List;
import java.util.Optional;


import com.app.BankManagement.Model.Account;

public interface AccountService {

	Account addAccount(Account account);

	Optional<Account> getsingleAccount(int id);

	List<Account> getAllAccount();

	void updateCustomerStatus(int id, boolean status);

}
