package com.app.BankManagement.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.BankManagement.Dao.AccountDao;
import com.app.BankManagement.Model.Account;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account addAccount(Account account) {
		
		if(account.getId()==0)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(account);
			account.setAccNo("accno-0"+(String.valueOf(account.getId())));
			sessionFactory.getCurrentSession().saveOrUpdate(account);
		}
		else
		{
			sessionFactory.getCurrentSession().saveOrUpdate(account);
		}
	//	sessionFactory.getCurrentSession().saveOrUpdate(account);
		return account;
	}
	
	
	@Override
	public Optional<Account> findById(int id) {
		
		return Optional.ofNullable(sessionFactory.getCurrentSession().byId(Account.class).load(id));
	}


	@Override
	public List<Account> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery("SELECT a FROM Account a", Account.class).getResultList();
	}


	@Override
	public void updateCustomerStatus(int id, boolean status) {
		sessionFactory.getCurrentSession().createQuery("UPDATE Account a SET a.status=:status where a.id=:id")
		.setParameter("status", status)
		.setParameter("id", id)
		.executeUpdate();
		}
}
