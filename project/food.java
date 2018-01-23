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
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class food implements  Serializable
{
    ArrayList<eatable> foodlist;
    food()
    {
        foodlist= new ArrayList();
    }
   
}

class eatable implements Serializable
{
    int dish_id;
    String dish_name;
    String cuisine;
    float price;
    String desc;
    public enum eatable_type{Starter, Main_course, Dessert, Beverage}
    boolean veg;
    eatable_type e;
    eatable(int a)
    {
        this.dish_id=a;
        this.price=0; 
        this.dish_name="0";
        this.cuisine="0";
        this.desc="0";
        this.e=e.Beverage;
        this.veg=false;
        
    }
    eatable()
    {
        
    }  
    void get_food()
   {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the details");
        System.out.print("Dish id no: ");
        this.dish_id=scn.nextInt();
        System.out.println("Enter the course(1->starters 2->main course 3-> desserts 4->beverages)");
        int ch;
        ch=scn.nextInt();
        switch(ch)
        {
            case 1: e=e.Starter;break;
            case 2 : e=e.Main_course; break;
            case 3 :e=e.Dessert; break;
            case 4 : e=e.Beverage; break;
        }
        System.out.print("Dish name: ");
        this.dish_name=scn.next();
        System.out.print("Price: ");
        this.price=scn.nextFloat();
        System.out.print("Cuisine: ");
        this.cuisine=scn.next();
        System.out.print("Description: ");
        this.desc=scn.next();
        
    }
    void display_food()
    {
        System.out.println("The dish details are");
        System.out.println("Dish id no: "+this.dish_id);
     
        System.out.println("Course: "+e);
       
        System.out.println("Dish name: "+this.dish_name);
   
        System.out.println("Price: "+this.price);
     
        System.out.println("Cuisine: "+this.cuisine);
   
        System.out.println("Description: "+this.desc);
      
    }
  
}