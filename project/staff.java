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
import java.util.*;

class staff_arr implements Serializable
{
    ArrayList<chef> chef_arr;
    ArrayList<servicemen> service_arr; 
    staff_arr()
    {
        chef_arr=new ArrayList();
        service_arr=new ArrayList();
    }
}

abstract class staff implements Serializable
{
   int s_id;
   String s_name;
   long s_adhaar;
   public enum gender{Male,Female,Others}
   gender gen;
   String saddress;
   String scontact;
   String date_of_join; // change to date
   public enum exp{noobie,intermediate,expert}
   public enum job{Cleaning,Security,Serving,Cust_care}
   abstract void get_staff();
   abstract void display_staff();
}

class chef extends staff implements Serializable
{
    exp experience;
    chef()
    {
        
    }
    chef(int a)
    {
        s_id=a;
        s_name="0";
        s_adhaar=0;
        gen=gen.Male;
        saddress="0";
        scontact="0";
        date_of_join="0";
        experience=experience.noobie;
    }
    void get_staff()
    {
       Scanner scn= new Scanner(System.in); 
       System.out.println("Enter the staff details:");
       System.out.println("Name : ");
       this.s_name=scn.next();
       System.out.println("Id:");
       this.s_id=scn.nextInt();
       System.out.println("Adhaar:");
       this.s_adhaar=scn.nextInt();
       System.out.println("Address : ");
       this.saddress=scn.next();
       System.out.println("Phone no : ");
       this.scontact=scn.next(); 
       System.out.println("Gender(1->Male 2->Female 3->Others)");
        int ch;
        ch=scn.nextInt();
        switch(ch)
        {
            case 1: gen=gen.Male;break;
            case 2 : gen=gen.Female; break;
            case 3 :gen=gen.Others; break;
        }
       System.out.println("Enter the experience(1->Noobie 2->intermediate 3-> expert)");
       
        ch=scn.nextInt();
        switch(ch)
        {
            case 1: experience=experience.noobie;break;
            case 2 : experience=experience.intermediate; break;
            case 3 :experience=experience.expert; break;
        }
       System.out.println("Date of Joining : ");
       this.date_of_join=scn.next(); 
       
    }
    public void display_staff()
    {
        System.out.println("The staff details are");
        System.out.println("Staff id no: "+ this.s_id);
       
        System.out.println("Name: "+this.s_name);
       
        System.out.println("Adhaar: "+this.s_adhaar);
       
        System.out.println("Gender: "+this.gen);
     
        System.out.println("Address: "+this.saddress);
        
        System.out.println("Experience: "+this.experience);
        
        System.out.println("Date of join: "+this.date_of_join);
        
        System.out.println("Phone num: "+this.scontact);
      
    }
   
}

class servicemen extends staff implements Serializable
{
    job jobb;
    servicemen()
    {
    }
    servicemen(int a)
    {
        s_id=a;
        s_name="0";
        s_adhaar=0;
        gen=gen.Male;
        saddress="0";
        scontact="0";
        date_of_join="0";
        jobb=jobb.Cleaning;
    }
    void get_staff()
    {
       Scanner scn= new Scanner(System.in); 
       System.out.println("Enter the staff details:");
       System.out.println("Name : ");
       this.s_name=scn.next();
       System.out.println("Id:");
       this.s_id=scn.nextInt();
       System.out.println("Adhaar:");
       this.s_adhaar=scn.nextInt();
       System.out.println("Address : ");
       this.saddress=scn.next();
       System.out.println("Phone no : ");
       this.scontact=scn.next(); 
       System.out.println("Gender(1->Male 2->Female 3->Others)");
       int ch;
       ch=scn.nextInt();
       switch(ch)
        {
            case 1: gen=gen.Male;break;
            case 2 : gen=gen.Female; break;
            case 3 :gen=gen.Others; break;
        }
       System.out.println("Enter the job(1->Cleaning 2->Serving 3->Security 4->Customer care)");
       ch=scn.nextInt();
       switch(ch)
        {
            case 1: jobb=jobb.Cleaning;break;
            case 2 : jobb=jobb.Serving; break;
            case 3 :jobb=jobb.Security; break;
            case 4: jobb=jobb.Cust_care; break;
        }
       System.out.println("Date of Joining : ");
       this.date_of_join=scn.next(); 
     
    }
    public void display_staff()
    {
         System.out.println("Staff id no: "+ this.s_id);
       
        System.out.println("Name: "+this.s_name);
       
        System.out.println("Adhaar: "+this.s_adhaar);
       
        System.out.println("Gender: "+this.gen);
     
        System.out.println("Address: "+this.saddress);
        
        System.out.println("Job: "+this.jobb);
        
        System.out.println("Date of join: "+this.date_of_join);
        
        System.out.println("Phone num: "+this.scontact);
    }
   
}

