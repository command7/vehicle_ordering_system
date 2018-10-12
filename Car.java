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
public class Car extends Vehicle
{
   /** Stores the index for type of the car. */
   private int carType = -1;
   /** Stores the index for whether towing package is included or not. */
   private int towingPackage = -1;
   /** An array containing types of cars for the user to select one*/
   final static String [] typesOfCars = {"Sedan", "Coupe", "Wagon"};
   /** An array containing possible answers for the user to select */
   final static String [] towingCapability = {"Towing Package", "No towing package"};

/**
*  Constructor uses methods to asks user for the model, color, cost, car type, towing package existence
*  and stores in in private variables.
*/
   public Car()
   {
      super();
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
         return typesOfCars[carType];
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
         return towingCapability[towingPackage];
      }
   }//end of getTowingPackage() method
   
/**
*  Mutator method that is used to set/modify the type of the car.
*/
   public void setCarType(int _carType)
   {
      if (_carType >=0 && _carType < typesOfCars.length)
      {
         this.carType = _carType;
      }
   }//end of setCarType() method
   
/**
*  Mutator method that is used to set/modify the towing package status of the car.
*/
   public void setTowingPackage(int _towingPackage)
   {
      if (_towingPackage >= 0 && _towingPackage < towingCapability.length)
      {
         this.towingPackage = _towingPackage;
      }
     
   }//end of setTowingPackage() method
         
/**
*  Input method that requests user for the type of car and stores 
*  in respective variable.
*/
   public void typeOfCarMenu()
   {
      int typeOfCarIndex = super.showMenu("What type of Car is this?", typesOfCars);
      setCarType(typeOfCarIndex);
   }//end of typeOfCarMenu() method
   
/**
* Input method that request the user for towing package status
* and stores it in respective variable.
*/   
   public void towingPackageMenu()
   {
      int towingPackageIndex = super.showMenu("Does this car have a towing package? ",towingCapability);
      setTowingPackage(towingPackageIndex);
   }//end of towingPackageMenu() method
   
/**
*  Estimates the mileage of the Car
*/
   public double gasMileage()
   {
      double mileage = 0;
      if (this.getCarType().equals("Sedan"))
      {
         mileage = sedanMpg;
      }
      else if (this.getCarType().equals("Coupe"))
      {
         mileage = coupeMpg;
      }
      else 
      {
         mileage = wagonMpg;
      }
      if (this.getTowingPackage().equals("Towing Package"))
      {
         mileage -= towingMpg;
      }
      return mileage;
   }

/**
*  Method that specifies the printing statement of Car object
*/   
   public String toString()
   {
      return "Car\n" + super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Type:", this.getCarType(),"", "Towing:", this.getTowingPackage());
   }//end of toString() method

}//end class Car