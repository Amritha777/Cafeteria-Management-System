/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.project;

/**
 *
 * @author AMRITHA ANIL
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AMRITHA ANIL
 */
class cust_array implements Serializable
{
    ArrayList<customer> cust;
    cust_array()
    {
        cust= new ArrayList();
    }
   
}

    
 public class customer implements Serializable
 {
    
    String c_id;
    String c_name;
    String c_address;
    String c_phone;
    boolean bill_paid;
    boolean online;
    customer()
    {
        this.online=false;
    }
    customer(int a)
    {
        this.c_id="0";
        this.c_address="0";
        this.bill_paid=false;
        this.c_name="0";
        this.c_phone="0";
        this.online=false;
    }
    customer(boolean online)
    {
        this.online=online;
    }
    
    void get_customer()
    {
       Scanner scn= new Scanner(System.in); 
       System.out.println("Enter the customer details:");
       System.out.println("Name : ");
       this.c_name=scn.next();
       System.out.println("Rol no:");
       this.c_id=scn.next();
       System.out.println("Address : ");
       this.c_address=scn.next();
       System.out.println("Phone no : ");
       this.c_phone=scn.next(); 
       
    }
    void put_customer()
   {
       System.out.println("The customer details are: ");
       System.out.println("Name: "+ this.c_name);
       System.out.println("Roll no: "+ this.c_id);
       System.out.println("Address: "+ this.c_address);
       System.out.println("Phone: "+ this.c_phone);  
       
   }
    
 }
 
 
 /*
   void generate_cust_id(int c)
   {         
       Integer i=new Integer(c);
       String s=this.c_name.substring(0,2);
       this.c_id=c_name+i.toString();     
   }    
 //  public void book_table();
   
   */
