/**
*Purpose:   This program is used to create a car order. It asks the user for the model, color ,cost,
*           type of car and whether towing package is included and stores it. <br/>
*                                                            <br/>
*Caveats:   It uses Vehicle class to accept inputs. <br/>
*Date:      September 23, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.1
*/

import java.util.*;
import java.io.*;
public class Car extends Vehicle 
{
   /** Stores the index for type of the car. */
   private int carType = -1;
   /** Stores the index for whether towing package is included or not. */
   private int towingPackage = -1;
   final static String VEHICLE_IS = "Car";

/**
*  Constructor uses methods to asks user for the model, color, cost, car type, towing package existence
*  and stores in in private variables.
*/
   public Car()
   {
      super(VEHICLE_IS);
      typeOfCarMenu();
      towingPackageMenu();   
   }//end of Car constructor
  
/**
*  Accessor method that returns the type of car.
*/
   public String getCarType()
   {
      if (carType == -1)
      {
         return "";
      }
      else
      {
         return TYPES_OF_CARS[carType];
      }
   }//end of getCarType() method
   
/**
*  Accessor method that returns whether towing package exists or not.
*/
   public String getTowingPackage()
   {
      if (towingPackage == -1)
      {
         return "";
      }
      else
      {
         return TOWING_CAPABILITY[towingPackage];
      }
   }//end of getTowingPackage() method
   
/**
*  Mutator method that is used to set/modify the type of the car.
*/
   public void setCarType(int _carType)
   {
      if (_carType >=0 && _carType < TYPES_OF_CARS.length)
      {
         this.carType = _carType;
      }
   }//end of setCarType() method
   
/**
*  Mutator method that is used to set/modify the towing package status of the car.
*/
   public void setTowingPackage(int _towingPackage)
   {
      if (_towingPackage >= 0 && _towingPackage < TOWING_CAPABILITY.length)
      {
         this.towingPackage = _towingPackage;
      }
     
   }//end of setTowingPackage() method
         
   public static String[] getCarTypeOptions()
   {
      return TYPES_OF_CARS;
   }
   
   public static String[] getTowingOptions()
   {
      return TOWING_CAPABILITY;
   }
   
   public static String[] getAttributeLabels()
   {
      return CAR_ATTRIBUTE_LABELS;
   }

/**
*  Input method that requests user for the type of car and stores 
*  in respective variable.
*/
   public void typeOfCarMenu()
   {
      setCarType(super.showMenu("What type of Car is this?", TYPES_OF_CARS));
   }//end of typeOfCarMenu() method
   
/**
* Input method that request the user for towing package status
* and stores it in respective variable.
*/   
   public void towingPackageMenu()
   {
      setTowingPackage(super.showMenu("Does this car have a towing package? ",TOWING_CAPABILITY));
   }//end of towingPackageMenu() method
   
/**
*  Estimates the mileage of the Car
*/
   public double gasMileage()
   {
      double mileage = 0;
      if (this.getCarType().equals("Sedan"))
      {
         mileage = SEDAN_MPG;
      }
      else if (this.getCarType().equals("Coupe"))
      {
         mileage = COUPE_MPG;
      }
      else 
      {
         mileage = WAGON_MPG;
      }
      if (this.getTowingPackage().equals("Towing Package"))
      {
         mileage -= TOWING_MPG_REDUCTION;
      }
      return mileage;
   }

/**
*  Method that specifies the printing statement of Car object
*/   
   public String toString()
   {
      return super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Type:", this.getCarType(),"", "Towing:", this.getTowingPackage());
   }//end of toString() method

}//end class Car