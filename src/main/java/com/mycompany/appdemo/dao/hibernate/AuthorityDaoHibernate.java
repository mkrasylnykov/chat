/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdemo.dao.hibernate;

import com.mycompany.appdemo.dao.AuthorityDao;
import com.mycompany.appdemo.model.Authority;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mkrasilnikov
 */

@Repository("authorityDao")
public class AuthorityDaoHibernate implements AuthorityDao
{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public void addAuthority(Authority authority) {
        sessionFactory.getCurrentSession().save(authority);
    }

}
