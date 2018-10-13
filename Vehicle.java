/**
*Purpose:   This program is a parent class that has methods and attributes that will be used
*           by car, boat and truck class.It also provides a menu system that can be used
*           to provide various types of menu systems to the user. <br/>
*                                                            <br/>
*Caveats:   Child classes need to use super keyword to access these functions. <br/>
*           The program will keep repeating until a valid input is entered.
*Date:      September 30, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.0
*/
import java.util.*;
public abstract class Vehicle implements Vinfo
{
   /** Stores the model of the vehicle */
   private String model;
   /** Stroes the color of the vehicle */
   private String color;
   /** Stores the cost of the vehicle */
   private double cost;
   /** Scanner object to request user input */
   Scanner scan = new Scanner(System.in);
   
   public Vehicle()
   {
      generalDetailsMenu();
   }
   
/**
*  Accessor method that returns the model of the vehicle.
*/
   public String getModel()
   {
      return this.model;
   }//end of getModel() method
   
/**
*  Accessor method that returns the color of the vehicle.
*/
   public String getColor()
   {
      return this.color;
   }//end of getColor() method
   
/**
*  Accessor method that returns the cost of the vehicle.
*/
   public double getCost()
   {
      return this.cost;
   }//end of getCost() method
   
/**
*  Mutator method that is used to set/modify the model of the vehicle.
*/
   public void setModel(String _model)
   {
      this.model = _model;
   }//end of setModel() method
   
/**
*  Mutator method that is used to set/modify the color of the vehicle.
*/
   public void setColor(String _color)
   {
      this.color = _color;
   }//end of setColor() method
   
/**
*  Mutator method that is used to set/modify the cost of the vehicle.
*/
   public void setCost(double _cost)
   {
      if (_cost > 0)
      {
         this.cost = _cost;
      }      
   }//end of setCost() method
   
/**
*  Input method that is used to request general details such as model name, color,
*  and cost of the vehicle from the user.
*/
   public void generalDetailsMenu()
   {
      while(true)
      {
         System.out.print(String.format("%5s%-5s","","Model: "));
         if(!scan.hasNextLine())
         {
            System.out.println("Enter valid input.");
            continue;
         }
         else
         {
            String carModelInput = scan.nextLine();
            if (carModelInput.equals(""))
            {
               System.out.println("You cannot leave this field blank.");
               continue;
            }
            else
            {
               setModel(carModelInput);
               break;
            }
         }
      }
      while(true)
      {
         System.out.print(String.format("%5s%-5s","","Color: "));
         if(!scan.hasNextLine())
         {
            System.out.println("Enter valid input.");
            continue;
         }
         else
         {
            String carColorInput = scan.nextLine();
            if (carColorInput.equals(""))
            {
               System.out.println("You cannot leave this field blank.");
               continue;
            }
            else
            {
               setColor(carColorInput);
               break;
            }
         }
      }
      while(true)
      { 
         System.out.print(String.format("%5s%-5s","","Cost: "));
         if(!scan.hasNextLine())
         {
            System.out.println("Enter valid input.");
            continue;
         }
         else
         {
            try
            {
               setCost(Double.parseDouble(scan.nextLine()));
               break;
            }
            catch (NumberFormatException nfe)
            {
               System.out.println("Enter valid numbers.");
               continue;
            }
         }
      }   
   }//end of generalDetailsMenu() method


/**
*  This method is used to print menus and obtain input from the user
*  based on the menu choices. It takes the choice number as input 
*  and outputs index (-1)
*  @param prompt The prompt that is to be displayed to the user.
*  @param choices choices that need to be displayed to that user.
*/
   public int showMenu(String prompt, String [] choices)
   {
      System.out.println(prompt);
      for (int i = 0; i<choices.length; i++)
      {
         System.out.println((i+1) + ". " + choices[i]);
      }
      boolean controlVar = true;
      int userInput = 0;
      do
      {
         try
         {
            System.out.print(String.format("%5s%-5s","","Choice: "));
            userInput = scan.nextInt();
            scan.nextLine();
            if (userInput > 0 && userInput <=(choices.length))
            {
               controlVar = false;
            }
            else
            {
               System.out.println("Please select a choice from the given options.");
            }  
         }
         catch (InputMismatchException ime)
         {
            System.out.println("Only numeric characters are allowed.");
            scan.nextLine();
         }
         catch (Exception e)
         {
            System.out.println("Invalid Input");
            scan.nextLine();
         }
     }while(controlVar);
     return (userInput-1);
   }//end of showMenu() method.
   
/**
*  Abstract class that estimates the mileage of a vehicle.
*  Will be used by child classes.
*/
   public abstract double gasMileage();
   
/**
*  Print Statement for vehicle class
*/
   public String toString()
   {
   return String.format("%5s%-10s %s%n%5s%-10s %s%n%5s%-10s $%.2f%n%5s%-10s %s","","Model:",this.getModel(),"","Color:", this.getColor(),"", "Cost:", this.getCost(),"","MPG/GPH:", this.gasMileage());
   }

}// end class Vehicle