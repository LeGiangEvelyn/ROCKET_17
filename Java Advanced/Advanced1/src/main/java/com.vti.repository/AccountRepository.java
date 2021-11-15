package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {
    private HibernateUtils hibernateUtils;

    public AccountRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {
        Session session = null;

        try {
            //get session
            session = hibernateUtils.openSession();

            //create hql
            Query<Account> query = session.createQuery("FROM Account");

            return  query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Account getAccountByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get Account by id
            Account account = session.get(Account.class, id);

            return account;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Account getAccountByName(String firstname) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            org.hibernate.query.Query<Account> query = session.createQuery("FROM Account WHERE FirstName = :nameParameter");

            // set parameter
            query.setParameter("nameParameter", firstname);

            // get result
            Account account = query.uniqueResult();

            return account;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAccount(Account account) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(account);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAccount(short id, String newEmail, String newUsername, String newFirstName, String newLastName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get Account
            Account account = (Account) session.load(Account.class, id);

            // update
            account.setEmail(newEmail);
            account.setUsername(newUsername);
            account.setFirstName(newFirstName);
            account.setLastName(newLastName);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAccount(Account account) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // update
            session.update(account);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAccount(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get Account
            Account account = (Account) session.load(Account.class, id);

            // delete
            session.delete(account);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAccountExistsByID(short id) {

        // get Account
        Account account = getAccountByID(id);

        // return result
        if (account == null) {
            return false;
        }

        return true;
    }

    public boolean isAccountExistsByName(String name) {
        Account account = getAccountByName(name);

        if (account == null) {
            return false;
        }
        return true;
    }
}
