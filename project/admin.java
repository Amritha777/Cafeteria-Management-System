/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.project;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AMRITHA ANIL
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class admin 
{
    Scanner scn=new Scanner(System.in);
    final String syspass;
    admin()
    {
        syspass="abcd";
    }
   
     public boolean passwordchecker() throws FileNotFoundException, IOException,NotSerializableException , NullPointerException
    {
        Scanner scn= new Scanner(System.in);
        System.out.println("Confirm Your Authorisation");
        System.out.println("Enter the password");
        try{
        String upass=new String();
        upass=scn.next();
         if(syspass.equals(upass)==true)
            return true;
            else return false;
        }
        catch(NullPointerException e)
        {
            System.out.println(e);
        }
        return false;
        
    }
    
     
    public void add_customer() throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        
        cust_array cst=new cust_array();
       
            FileInputStream fin;
            FileOutputStream fout;
             ObjectInputStream ofin;
             ObjectOutputStream ofout;
            try{ 
             fin = new FileInputStream("customer.txt");
             if(fin.read()==-1)
             {
                 customer invalid= new customer(0);
                 cst.cust.add(invalid);
                  fout=new FileOutputStream("customer.txt");
                  ofout=new ObjectOutputStream(fout);
                  ofout.writeObject(cst);
                  ofout.close();
                  fout.close();
                  fin.close();
             }
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
            
            
            
            try 
            {
                customer c=new customer();
                c.get_customer();
               fin = new FileInputStream("customer.txt");
                ofin = new ObjectInputStream(fin);
               cst=(cust_array) ofin.readObject();
               cst.cust.add(c);
               ofin.close();
               fin.close();
               fout=new FileOutputStream("customer.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cst);
               ofout.close();
               fout.close();
               
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }          
    }
    
    public void add_customer(boolean online) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        
        cust_array cst=new cust_array();
       
            FileInputStream fin;
            FileOutputStream fout;
             ObjectInputStream ofin;
             ObjectOutputStream ofout;
            try{ 
             fin = new FileInputStream("customer.txt");
             if(fin.read()==-1)
             {
                 customer invalid= new customer(0);
                 cst.cust.add(invalid);
                  fout=new FileOutputStream("customer.txt");
                  ofout=new ObjectOutputStream(fout);
                  ofout.writeObject(cst);
                  ofout.close();
                  fout.close();
                  fin.close();
             }
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
            
            
            
            try 
            {
                customer c=new customer(online);
                c.get_customer();
               fin = new FileInputStream("delivery.txt");
                ofin = new ObjectInputStream(fin);
               cst=(cust_array) ofin.readObject();
               cst.cust.add(c);
               ofin.close();
               fin.close();
               fout=new FileOutputStream("delivery.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cst);
               ofout.close();
               fout.close();
               
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }          
    }
 
    public void delete_customer() throws IOException, ClassNotFoundException
    {
        System.out.println("Enter the customer id which you want to delete");
        String did; did=scn.next();
        customer c=new customer();
         FileInputStream fin;
        FileOutputStream fout;
        try
        {
            cust_array cc=new cust_array();
            fin = new FileInputStream("customer.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            cc=(cust_array) ofin.readObject();
            for(int i=1;i<cc.cust.size();i++)
            {
                if(cc.cust.get(i).c_id.equals(did)==true)
                {
                    cc.cust.remove(i);
                    break;
                }
                else
                {
                    System.out.println("This item is not found");
                    return ;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("customer.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cc);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
     public void delete_customer(boolean online) throws IOException, ClassNotFoundException
    {
        System.out.println("Enter the customer id which you want to delete");
        String did; did=scn.next();
        customer c=new customer(online);
         FileInputStream fin;
        FileOutputStream fout;
        try
        {
            cust_array cc=new cust_array();
            fin = new FileInputStream("delivery.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            cc=(cust_array) ofin.readObject();
            for(int i=1;i<cc.cust.size();i++)
            {
                if(cc.cust.get(i).c_id.equals(did)==true)
                {
                    cc.cust.remove(i);
                    break;
                }
                else
                {
                    System.out.println("This item is not found");
                    return ;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("delivery.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cc);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
      public void display_custlist() throws IOException, ClassNotFoundException
    {
        customer c=new customer();
         FileInputStream fin;
        FileOutputStream fout;
        try
        {
            cust_array cc=new cust_array();
            fin = new FileInputStream("customer.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            cc=(cust_array) ofin.readObject();
            for(int i=1;i<cc.cust.size();i++)
            {
                cc.cust.get(i).put_customer();
                System.out.println(" ");
            }
            ofin.close();
            fin.close();
            
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
      
       public void display_custlist(boolean online) throws IOException, ClassNotFoundException
    {
        customer c=new customer();
         FileInputStream fin;
        FileOutputStream fout;
        try
        {
            cust_array cc=new cust_array();
            fin = new FileInputStream("delivery.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            cc=(cust_array) ofin.readObject();
            for(int i=1;i<cc.cust.size();i++)
            {
                cc.cust.get(i).put_customer();
                System.out.println(" ");
            }
            ofin.close();
            fin.close();
            
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
    
    public void modify_customer() throws IOException, ClassNotFoundException
    {
        System.out.println("Enter the customer id which you want to modify");
        String did;
        did=scn.next();
        customer c=new customer();
         FileInputStream fin;
        FileOutputStream fout;
        try
        {
            cust_array cc=new cust_array();
            fin = new FileInputStream("customer.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            cc=(cust_array) ofin.readObject();
            for(int i=1;i<cc.cust.size();i++)
            {
                if(cc.cust.get(i).c_id.equals(did)==true)
                {
                    cc.cust.remove(i);
                    c.get_customer();
                    cc.cust.add(c);
                    break;
                }
                else
                {
                    System.out.println("This item is not found");
                    return ;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("customer.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cc);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
    
      public void modify_customer(boolean online) throws IOException, ClassNotFoundException
    {
        System.out.println("Enter the customer id which you want to modify");
        String did;
        did=scn.next();
        customer c=new customer(online);
         FileInputStream fin;
        FileOutputStream fout;
        try
        {
            cust_array cc=new cust_array();
            fin = new FileInputStream("delivery.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            cc=(cust_array) ofin.readObject();
            for(int i=1;i<cc.cust.size();i++)
            {
                if(cc.cust.get(i).c_id.equals(did)==true)
                {
                    cc.cust.remove(i);
                    c.get_customer();
                    cc.cust.add(c);
                    break;
                }
                else
                {
                    System.out.println("This item is not found");
                    return;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("customer.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cc);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
  
    
     public void manage_customer() throws IOException, ClassNotFoundException
    {
        System.out.println("select the mode of customer 1-> offline 2-> online");
        int a; boolean b;
        a=scn.nextInt();
        if(a==2) b=true;
        else b=false;
        System.out.println("Select an operation to be performed");
        int ch;
        System.out.println("1-> Add Customer");
        System.out.println("2-> Delete Customer");
        System.out.println("3-> Modify Customer");
        System.out.println("4-> Display Customer list");
        System.out.println("Enter your choice");
        ch=scn.nextInt();
        switch(ch)
        {
            case 1 : { if(b==false)add_customer(); else add_customer(b); break;}
            case 2 : { if(b==false) delete_customer(); else delete_customer(b); break;}
            case 3 : { if(b==false) modify_customer(); else modify_customer(b); break; }
            case 4 : { if(b==false) display_custlist(); else display_custlist(b); break;}
            default : System.out.println("Wrong choice entered!"); break;
            }
            
    }
    public void add_staff() throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
         FileInputStream ffin=null;
            FileOutputStream ffout=null;
            ObjectInputStream oofin=null;
            ObjectOutputStream oofout=null;
            chef c;
            servicemen s;
            staff_arr st= new staff_arr();
            try
            {
                ffin= new FileInputStream("staff.txt");
                if(ffin.read()==-1)
                {
                    c= new chef(0);
                  s=new servicemen(0);
               st.chef_arr.add(c);
                  st.service_arr.add(s);
                    ffout=new FileOutputStream("staff.txt");
                    oofout=new ObjectOutputStream(ffout);
                    oofout.writeObject(st);  
                    ffout.close();
                    oofout.close();
                }
               ffin.close();
            }
               catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            
            }  
         c=new chef();
                    s= new servicemen();
        String str=new String();
        str="staff.txt";
        int ans;
        ans=1;
        while(ans==1){
        System.out.println ("DO you want to add a chef or a serviceman? 1-> chef 2-> service man");
        int x;
        x=scn.nextInt();
         try 
            {
              
               ffin = new FileInputStream(str);
               oofin = new ObjectInputStream(ffin);
               st=(staff_arr) oofin.readObject();
               oofin.close();
               ffin.close();
               if(x==1)
               {
                   c.get_staff();
                   try{
                       
                   st.chef_arr.add(c);
                   }
                   catch(Exception e)
                    {
                        System.out.print(e);

                    }
               }    
               else if(x==2)
               {
                   s.get_staff();
                   try{
                   st.service_arr.add(s);
                     } 
                  catch(Exception e)
                 {
                     System.out.print(e);

                 }
               }
               ffout=new FileOutputStream("staff.txt");
               oofout= new ObjectOutputStream(ffout);
               oofout.writeObject(st);
               oofout.close();
               ffout.close();
               
            } 
            catch (FileNotFoundException ex)
            {
                if(x!=2&&x!=1) {System.out.println("invalid choice! Addition failed"); }
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            
            }  
            System.out.println("Do you want to enter more? 1-> yes 0->no");
            ans=scn.nextInt();
            
        }
    }
    
    public void display_stafflist() throws IOException, ClassNotFoundException
    {   
        FileInputStream ffin=null;
        ObjectInputStream oofin=null;
        staff_arr st=null;
                
        try 
            {
               
               ffin = new FileInputStream("staff.txt");
               oofin = new ObjectInputStream(ffin);
               st=(staff_arr) oofin.readObject();
               for(int i=1;i<st.chef_arr.size();i++)
               { st.chef_arr.get(i).display_staff(); System.out.println(""); }
                for(int i=1;i<st.service_arr.size();i++)
                { st.service_arr.get(i).display_staff(); System.out.println(""); }
               oofin.close();
               ffin.close();
            } 
             catch (FileNotFoundException ex)
            {
               Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }

    // amritha   
    public void delete_staff() throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        staff_arr st= new staff_arr();
        chef c= new chef();
        servicemen s=new servicemen();
        System.out.println ("DO you want to delete a chef or a serviceman? 1-> chef 2-> service man");
        int x;
        x=scn.nextInt();
        System.out.println("Enter the staff id of that person");
        int did;
        did=scn.nextInt();
             
            FileInputStream fin=null;
            FileOutputStream fout=null;
            ObjectInputStream ofin=null;
            ObjectOutputStream ofout=null;
            try 
            {
               
               fin = new FileInputStream("staff.txt");
               ofin = new ObjectInputStream(fin);
               st=(staff_arr) ofin.readObject();
               ofin.close();
               fin.close();
               if(x==1)
               {
                   for(int i=1;i<st.chef_arr.size();i++)
                   {
                        if(st.chef_arr.get(i).s_id==did)   
                       {
                           st.chef_arr.remove(i);
                             break;
                       } 
                        else
                {
                    System.out.println("Thos item is not found");
                    return;
                }
                   }
               }    
               else if(x==2)
               {
                   for(int i=1;i<st.service_arr.size();i++){
                        if(st.service_arr.get(i).s_id==did)   
                       {
                           st.service_arr.remove(i);
                             break;
                       }    
                        else
                {
                    System.out.println("Thos item is not found");
                    return;
                }
                   }    
               }
               fout=new FileOutputStream("staff.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(st);
               ofout.close();
               fout.close();
               
            } 
            catch(FileNotFoundException ex)
            {
                if(x!=2&&x!=3) {System.out.println("invalid choice! Addition failed"); }
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }  
    
    // amritha
    public void modify_staff() throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        staff_arr st= new staff_arr();
        chef c= new chef();
        servicemen s=new servicemen();
        System.out.println ("DO you want to modify a chef or a serviceman? 1-> chef 2-> service man");
        int x;
        x=scn.nextInt();
        System.out.println("Enter the staff id of that person");
        int did;
        did=scn.nextInt();
             
            FileInputStream fin=null;
            FileOutputStream fout=null;
            ObjectInputStream ofin=null;
            ObjectOutputStream ofout=null;
            try 
            {
               
               fin = new FileInputStream("staff.txt");
               ofin = new ObjectInputStream(fin);
               st=(staff_arr) ofin.readObject();
               ofin.close();
               fin.close();
               if(x==1)
               {
                   for(int i=0;i<st.chef_arr.size();i++)
                   {
                        if(st.chef_arr.get(i).s_id==did)   
                       {
                           st.chef_arr.remove(i);
                           c.get_staff();
                           st.chef_arr.add(c);
                             break;
                       } 
                        else
                {
                    System.out.println("Thos item is not found");
                    return;
                }
                   }
               }    
               else if(x==2)
               {
                   for(int i=0;i<st.service_arr.size();i++){
                        if(st.service_arr.get(i).s_id==did)   
                       {
                           st.service_arr.remove(i);
                           s.get_staff();
                           st.service_arr.add(s);
                             break;
                       }    
                        else
                {
                    System.out.println("Thos item is not found");
                    return;
                }
                   }    
               }
               fout=new FileOutputStream("staff.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(st);
               ofout.close();
               fout.close();
               
            } 
            catch(FileNotFoundException ex)
            {
                if(x!=2&&x!=3) {System.out.println("invalid choice! Addition failed"); }
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }  
    
     public void manage_staff() throws IOException, FileNotFoundException, NotSerializableException, NullPointerException, ClassNotFoundException 
    {
        // clrscr
        
        System.out.println("Select an operation to be performed");
        int ch;
        System.out.println("1-> Add staff");
        System.out.println("2-> Delete staff");
        System.out.println("3-> Modify staff");
        System.out.println("4-> Display Stafflist");
        System.out.println("Enter your choice");
        ch=scn.nextInt();
        switch(ch)
        {
            case 1 : { add_staff(); break;}
            case 2 : { delete_staff();break;}
            case 3 : { modify_staff(); break; }
            case 4 : { display_stafflist(); break; }
            default : System.out.println("Wrong choice entered!"); break;
            }
            
        }
     
     
      public void add_food() throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        eatable e;
       FileInputStream fin;
       FileOutputStream fout; //
            ObjectOutputStream ofout; //
              ObjectInputStream ofin;
       food ff=new food();
       
        e=new eatable();
            int x;
            x=1;
            
            try 
            {
                while(x==1) {
               e.get_food();
               fin = new FileInputStream("food.txt");
             
               ofin = new ObjectInputStream(fin);
               ff=(food) ofin.readObject();
               ff.foodlist.add(e);
               ofin.close();
               fin.close();
               fout=new FileOutputStream("food.txt");
               
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(ff);
               ofout.close();
               fout.close();
               System.out.println("Doyou want to enter more? 1->yes 0->no");
               x=scn.nextInt();
                }
               
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    } 
    public void delete_food(int did) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        eatable e=new eatable();
        FileInputStream fin;
        FileOutputStream fout;
        try
        {
            food ff=new food();
            fin = new FileInputStream("food.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            ff=(food) ofin.readObject();
            for(int i=1;i<ff.foodlist.size();i++)
            {
                if(ff.foodlist.get(i).dish_id==did)
                {
                    ff.foodlist.remove(i);
                    break;
                }
                else
                {
                    System.out.println("Thos item is not found");
                    return;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("food.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(ff);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
   public void modify_food(int did) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException, ClassNotFoundException
    {
        eatable e=new eatable();
        FileInputStream fin;
        FileOutputStream fout;
        try
        {
            food ff=new food();
            fin = new FileInputStream("food.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            ff=(food) ofin.readObject();
            for(int i=1;i<ff.foodlist.size();i++)
            {
                if(ff.foodlist.get(i).dish_id==did)
                {
                    ff.foodlist.remove(i);
                    System.out.println("Enter the new details of the dish item");
                    e.get_food();
                    ff.foodlist.add(e);
                    break;
                }
                else
                {
                    System.out.println("Thos item is not found");
                    return;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("food.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(ff);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
   
   public void display_foodlist() throws FileNotFoundException, IOException, ClassNotFoundException
   {
       eatable e=new eatable();
   
        FileInputStream fin;
             ObjectInputStream ofin;
        try            
        {
            food ff=new food();
            fin = new FileInputStream("food.txt");
            
            ofin = new ObjectInputStream(fin);
            ff=(food) ofin.readObject();
            for(int i=1;i<ff.foodlist.size();i++)
            {
                  ff.foodlist.get(i).display_food();
                  System.out.println("\n");
            }
       
        }
         catch (FileNotFoundException ex)
            {
               Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
   }
   
   public void manage_food() throws IOException, ClassNotFoundException
    {
         // clrscr
        System.out.println("Select an operation to be performed");
        int ch;
        System.out.println("1-> Add Food");
        System.out.println("2-> Delete Food");
        System.out.println("3-> Modify Food");
        System.out.println("4-> Display Foodlist");
        System.out.println("Enter your choice");
        ch=scn.nextInt();
        switch(ch)
        {
            case 1 : { add_food(); break;}
            case 2 : { System.out.println("Enter the dish id which you want to delete");
                        int d; d=scn.nextInt();
                        delete_food(d);break;}
            case 3 : { System.out.println("Enter the dish id which you want to modify");
                        int d; d= scn.nextInt();
                        modify_food(d); break; }
            case 4 : { display_foodlist();break;}
            default : System.out.println("Wrong choice entered!"); break;
            }
            
    }
   
    public void generate_bill(String id) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException
    {
        float total=0;
        food f=new food();
        eatable invalid=new eatable (0);
        FileInputStream fin=null;
        FileOutputStream fout=null;
        ObjectInputStream ofin=null;
        ObjectOutputStream ofout=null;
        
        fout=new FileOutputStream(id);
        o
        try{
            
            
            
            fout
            fin = new FileInputStream(id);
            
            ofin = new ObjectInputStream(fin);
            f=(food) ofin.readObject();
            for(int i=0;i<f.foodlist.size();i++)
            {
               System.out.println("   "+f.foodlist.get(i).dish_id + "    "+f.foodlist.get(i).dish_name+"    "+f.foodlist.get(i).price);
               total+=f.foodlist.get(i).price;
            }
            System.out.println("Your total bill amount is "+total);
            ofin.close();
            fin.close();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            ofin.close();
            fin.close();
        }
        System.out.println("Did he pay? y/n");
        Scanner scn=new Scanner(System.in);
        char ans;
        ans=scn.next().charAt(0);
        if(ans=='y'){
        try{
            cust_array cus=new cust_array();
            fin = new FileInputStream("Customer.txt");
            ofin = new ObjectInputStream(fin);
            cus=(cust_array) ofin.readObject();
            for(int i=0;i<cus.cust.size();i++){
                if(cus.cust.get(i).c_id==id)
                    cus.cust.remove(i);
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("customer.txt");
            ofout= new ObjectOutputStream(fout);
            ofout.writeObject(cus);
            ofout.close();
            fout.close();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            ofin.close();
            fin.close();
            ofout.close();
            fout.close();
        } 
        }
    }
   
   
/*
   //tobe
    public void display_mainmenu()
    {
        System.out.println("WELCOME TO NSIT CAFETRIA");
        System.out.println("\nThe options are: ");
        System.out.println("\t1. Add order");
        System.out.println("\t2. Add member");
        System.out.println("\t3. generte bill");
        System.out.println("\t4. manage staff");
        System.out.println("\t5. manage canteen menu");
        System.out.println("\nEnter Your Choice: ");
    }
    
   //done
    public boolean check_member(String id) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException
    {
        
            FileInputStream fin = null;
            ObjectInputStream ofin = null;
            boolean milaKya=false;
            try 
            {
               cust_array f=new cust_array();
               fin = new FileInputStream("customer.txt");
              
               ofin = new ObjectInputStream(fin);
               f=(cust_array) ofin.readObject();
               for(int i=0;i<f.cust.size();i++){
                    if(f.cust[i].c_id==id)
                        milaKya=true;
               }
               ofin.close();
               fin.close();
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        return milaKya;
    }
   
   //done
    public void add_order(String id) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException
    {
        if (check_member(id)==false){
                add_member();
                display_menu();
                place_order(id);
            }
        else {
                display_menu(); 
                place_order(id);
        }
    }
    

    // done
    public void place_order(String id) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException
    {   
        Scanner scn=new Scanner(System.in);
        int ch=1;
        String ss;
        food order=new food();
        FileInputStream fin=null;
        ObjectOutputStream ofout=null;
        ObjectInputStream ofin=null;
        cust_array d;
        FileOutputStream fout=new FileOutputStream(id);
        try{
            do
            {
                System.out.println("Enter the food id");
                ss=scn.next();
                food f=new food();
                fin = new FileInputStream("food.txt");
                ofin = new ObjectInputStream(fin);
                f=(food) ofin.readObject();
                for(int i=0;i<f.foodlist.size();i++){
                   if(f.foodlist[i].dish_id==ss){
                       order.foodlist.add(f.foodlist[i]);
                       break;
                   }
                }
                System.out.println("Do you want to order more?(Y=1/N=0)");
                ch=scn.nextInt();
            }while(ch==1);
             
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        try 
            {
               
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(order);
               ofout.close();
               fout.close();
               
            } 
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofout.close();
                fout.close();
            }
    }
    
   //done
    public void place_order(String id,boolean deliver) throws FileNotFoundException, IOException,NotSerializableException , NullPointerException
    {
        Scanner scn=new Scanner(System.in);
        int ch=1;
        String ss;
        food order=new food();
        FileInputStream fin=null;
        ObjectOutputStream ofout=null;
        ObjectInputStream ofin=null;
        cust_array d = null;
        FileOutputStream fout=null;
        try{
            do
            {
                System.out.println("Enter the food id");
                ss=scn.next();
                food f=new food();
                fin = new FileInputStream("food.txt");
                ofin = new ObjectInputStream(fin);
                f=(food) ofin.readObject();
                for(int i=0;i<f.foodlist.size();i++){
                   if(f.foodlist[i].dish_id==ss){
                       order.foodlist.add(f.foodlist[i]);
                       break;
                   }
                }
                System.out.println("Do you want to order more?(Y=1/N=0)");
                ch=scn.nextInt();
            }while(ch==1);
             
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        try 
            {
                fout= new FileOutputStream(id);
               
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(order);
               ofout.close();
               fout.close();
               
            } 
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofout.close();
                fout.close();
            }
        try{
            fin=new FileInputStream("customer.txt");
            cust_array cc= new cust_array();
            
            ofin = new ObjectInputStream(fin);        //wht if it is the first time we are adding?
            cc=(cust_array) ofin.readObject();
            customer b=new customer();
            for(int k=0;k<cc.cust.size();k++)
            {
                if(cc.cust.get(k).c_id==id)
                {
                   d.cust.add(cc.cust.get(k))   ;
                }
            }
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        try{
            fout=new FileOutputStream("delivery");
            ofout= new ObjectOutputStream(fout);
            ofout.writeObject(d);
                                                                    
                                                                   
        }
         catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofout.close();
                fout.close();
            }
    }
    
           */
    }    
        
