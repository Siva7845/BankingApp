package com.app.BankManagement.Dao;

import java.util.List;
import java.util.Optional;

import com.app.BankManagement.Model.Account;

public interface AccountDao {

	Account addAccount(Account account);

	Optional<Account> findById(int id);

	List<Account> findAll();

	void updateCustomerStatus(int id, boolean status);

}
