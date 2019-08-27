/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.dao;

import com.mycompany.appdemo.model.Account;


/**
 *
 * @author mkrasilnikov
 */

public interface AccountDao{

    public void addAccount(Account account);
    public void deleteAccount(Account account);
    public void updateAccount(Account account);

    public Account getAccount(String username);
}
