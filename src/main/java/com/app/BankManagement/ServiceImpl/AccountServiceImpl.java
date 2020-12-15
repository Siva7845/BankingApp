package com.app.BankManagement.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.BankManagement.Dao.AccountDao;
import com.app.BankManagement.Model.Account;
import com.app.BankManagement.Service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountDao accountDao;
	@Override
	public Account addAccount(Account account) {
		
		return accountDao.addAccount(account);
	}
	@Override
	public Optional<Account> getsingleAccount(int id) {
		
		return accountDao.findById(id);
	}
	@Override
	public List<Account> getAllAccount() {
		
		return accountDao.findAll();
	}
	@Override
	public void updateCustomerStatus(int id, boolean status) {
		
	 accountDao.updateCustomerStatus(id,status);
		
	}

}
