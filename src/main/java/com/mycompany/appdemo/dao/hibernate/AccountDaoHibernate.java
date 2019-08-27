/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.dao.hibernate;

import com.mycompany.appdemo.dao.AccountDao;
import com.mycompany.appdemo.model.Account;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mkrasilnikov
 */

@Repository("accountDao")
public class AccountDaoHibernate implements AccountDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addAccount(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(Account account) {
        sessionFactory.getCurrentSession().delete(account);
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }
    
    @Override
    @Transactional
    public Account getAccount(String username) {
        List<Account> accounts = sessionFactory.getCurrentSession().createQuery("from Account a where a.username=?").setString(0,username).list();
        if (!accounts.isEmpty()) {
            return accounts.get(0);
        }
        
        return null;
    }
    
}
