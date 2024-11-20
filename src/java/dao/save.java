/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;


import model.user;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Steve
 */
public class save {
    public String saveUser(user User){
        Session s = null;
        
        Transaction tr = null;
        
        
        s = HibernateUtil.getSessionFactory().openSession();
        
        
        tr = s.beginTransaction();
        
        s.save(User);
        
        
        tr.commit();
        s.close();
        return "SUCCESS";
    }
    
    
       // Method to get all users
public List<user> getAllUsers() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<user> users = null;
    try {
        String hql = "FROM user"; // HQL query
        Query query = (Query) session.createQuery(hql); // Create query
          users = query.list();// Cast the result to a list of users
    } finally {
        session.close();
    }
    return users;
}



}
