package com.m2m;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //create objects
        Categories c1 = new Categories();
        c1.setCategoryId(101);
        c1.setCategoryName("Electronics");
        
        Product p1 = new Product();
        p1.setProductId(1);
        p1.setProductName("Laptop");
        p1.setCategory(c1);
        
        Product p2 = new Product();
        p2.setProductId(2);
        p2.setProductName("Mobile");
        p2.setCategory(c1);
        
        List<Product> list = new ArrayList<Product>();
        list.add(p1);
        list.add(p2);
        
        c1.setProduct(list);
        //#######################################
        
        Categories c2 = new Categories();
        c2.setCategoryId(102);
        c2.setCategoryName("Shoes");
        
        Categories c3 = new Categories();
        c3.setCategoryId(103);
        c3.setCategoryName("Fashion");
        
        Supplier s1 = new Supplier();
        s1.setSupplierId(1001);
        s1.setSupplierName("Reebok");
        
        Supplier s2 = new Supplier();
        s2.setSupplierId(1002);
        s2.setSupplierName("Puma");
        
        Supplier s3 = new Supplier();
        s3.setSupplierId(1003);
        s3.setSupplierName("Nike");
        
        //####################################
        
        List<Categories> list1 = new ArrayList<Categories>();
        List<Supplier> list2 = new ArrayList<Supplier>();
        
        list1.add(c2);
        list1.add(c3);
        
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        
        c2.setSuppliers(list2);
        s2.setCategories(list1);
        s3.setCategories(list1);
        
        //########################################
        
        
        
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        //save
        
        s.save(c1);
        s.save(p1);
        s.save(p2);
        s.save(c2);
        s.save(c3);
        s.save(s1);
        s.save(s2);
        s.save(s3);
        
        tx.commit();
        s.close();
        factory.close();
    }
}
