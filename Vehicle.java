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
import java.io.*;
public abstract class Vehicle implements Vinfo, Serializable
{
   /** Stores the model of the vehicle */
   private String vehicleModel;
   /** Stroes the color of the vehicle */
   private String vehicleColor;
   /** Stores the cost of the vehicle */
   private double vehicleCost;
   /** Scanner object to request user input */
   transient Scanner scan = new Scanner(System.in);
   private String vehIs;
   
   public Vehicle(String typeOfVehicle)
   {
      generalDetailsMenu(typeOfVehicle);
   }
   
   public Vehicle(String vehicleModel, String vehicleColor, double vehicleCost)
   {
      this.setVehicleModel(vehicleModel);
      this.setVehicleColor(vehicleColor);
      this.setVehicleCost(vehicleCost);
   }
   
/**
*  Accessor method that returns the model of the vehicle.
*/
   public String getVehicleModel()
   {
      return this.vehicleModel;
   }//end of getVehicleModel() method
   
/**
*  Accessor method that returns the color of the vehicle.
*/
   public String getVehicleColor()
   {
      return this.vehicleColor;
   }//end of getVehicleColor() method
   
/**
*  Accessor method that returns the cost of the vehicle.
*/
   public double getVehicleCost()
   {
      return this.vehicleCost;
   }//end of getVehicleCost() method
   
   public String getVehIs()
   {
      return this.vehIs;
   }
/**
*  Mutator method that is used to set/modify the model of the vehicle.
*/
   public void setVehicleModel(String _vehicleModel)
   {
      this.vehicleModel = _vehicleModel;
   }//end of setVehicleModel() method
   
/**
*  Mutator method that is used to set/modify the color of the vehicle.
*/
   public void setVehicleColor(String _vehicleColor)
   {
      this.vehicleColor = _vehicleColor;
   }//end of setVehicleColor() method
   
/**
*  Mutator method that is used to set/modify the cost of the vehicle.
*/
   public void setVehicleCost(double _vehicleCost)
   {
      if (_vehicleCost > 0)
      {
         this.vehicleCost = _vehicleCost;
      }      
   }//end of setVehicleCost() method
   
   public void setVehIs(String _vehIs)
   {
      this.vehIs = _vehIs;
   }
/**
*  Input method that is used to request general details such as model name, color,
*  and cost of the vehicle from the user.
*/
   public void generalDetailsMenu(String typeOfVehicle)
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
            String vehicleModelInput = scan.nextLine();
            if (vehicleModelInput.equals(""))
            {
               System.out.println("You cannot leave this field blank.");
               continue;
            }
            else
            {
               setVehicleModel(vehicleModelInput);
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
            String vehicleColorInput = scan.nextLine();
            if (vehicleColorInput.equals(""))
            {
               System.out.println("You cannot leave this field blank.");
               continue;
            }
            else
            {
               setVehicleColor(vehicleColorInput);
               break;
            }
         }
      }
      while(true)
      { 
            try
            {
               System.out.print(String.format("%5s%-5s","","Cost: "));
               setVehicleCost(Double.parseDouble(scan.nextLine()));
               break;
            }
            catch (NumberFormatException nfe)
            {
               System.out.println("Invalid dollar amount. Do not use $ or , for the cost. Try again.");
               continue;
            }
            catch (Exception e)
            {
               System.out.println("Invalid Input");
               continue;
            }
      }
      this.setVehIs(typeOfVehicle);   
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
      // for (int i = 0; i<choices.length; i++)
//       {
//          System.out.println((i+1) + ". " + choices[i]);
//       }
      boolean controlVar = true;
      int userInput = 0;
      do
      {
         try
         {
            for (int i = 0; i<choices.length; i++)
            {
               System.out.println((i+1) + ". " + choices[i]);
            }
            System.out.print(String.format("%5s%-5s","","Choice: "));
            userInput = scan.nextInt();
            scan.nextLine();
            if (userInput > 0 && userInput <= (choices.length))
            {
               controlVar = false;
            }
            else
            {
               System.out.println("Please enter a number from 1 through " + choices.length);
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
      return String.format("%s%n%5s%-10s %s%n%5s%-10s %s%n%5s%-10s $%.2f%n%5s%-10s %.1f",this.getVehIs(),
"",
      "Model:",this.getVehicleModel(),"","Color:", this.getVehicleColor(),"", "Cost:", 
      this.getVehicleCost(),"","MPG/GPH:", this.gasMileage());
   }

}// end class Vehicle