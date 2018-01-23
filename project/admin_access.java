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
import java.util.*;
import java.io.*;
import static javafx.application.Platform.exit;

public class admin_access {
    //
    
  /*
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner scn= new Scanner(System.in);
        admin a= new admin();
        boolean b;
        b=a.passwordchecker();
        if(b==true)
        {    
            a.display_mainmenu();
            int chh;
            chh=scn.nextInt();
            switch(chh)
            {
                case 1 : a.add_order(); break;
                case 2 : a.add_member(); break;
                case 3 : a.generate_bill();break;
                case 4 : a.manage_staff(); break;
                case 5 : a.manage_menu(); break;
                default: System.out.println("You entered invalid choice");
            }
        }
        else
        {
            System.out.println("You have been denied access  to the system");
            exit();
            
        }
       
                    
   } */
    public static void main(String[] args) throws IOException, FileNotFoundException, NotSerializableException, NullPointerException, ClassNotFoundException
    {
        System.out.println ("start");
        Scanner scn=new Scanner(System.in);
        admin cafe= new admin(); 
        eatable e;
        food ff= new food();
       FileInputStream fin;
       FileOutputStream fout; //
            ObjectOutputStream ofout; //
              ObjectInputStream ofin;
//     fin=new FileInputStream("food.txt");
           
               fout=new FileOutputStream("food.txt");
               ofout= new ObjectOutputStream(fout);
               e=new eatable(0);
                ff.foodlist.add(e);
                ofout.writeObject(ff);
                ofout.close();
                fout.close();
           cafe.manage_food();
        System.out.println("back to main");
    }
    
}
