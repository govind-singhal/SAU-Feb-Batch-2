package com.m2o;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Ques q1 = new Ques();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java ?");
        
        Ans answer = new Ans();
        answer.setAnswerid(343);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(q1);
        
        Ans answer1 = new Ans();
        answer1.setAnswerid(33);
        answer1.setAnswer("With the help of Java we can create Softwares");
        answer1.setQuestion(q1);
        
        Ans answer2 = new Ans();
        answer2.setAnswerid(363);
        answer2.setAnswer("Java has different type of Frameworks");
        answer2.setQuestion(q1);
        
        List<Ans> list = new ArrayList<Ans>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);
        
        q1.setAnswers(list);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        s.save(q1);
        s.save(answer);
        s.save(answer1);
        s.save(answer2);
        
        tx.commit();
        s.close();
        factory.close();
        
        
    }
}
