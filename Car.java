/**
*Purpose:   This program is used to create a car order. It asks the user for the model, color ,cost,
*           type of car and whether towing package is included and stores it. <br/>
*                                                            <br/>
*Caveats:   It uses Vehicle class to accept inputs. <br/>
*Date:      October 29, 2018
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
   /** An array containing types of cars for the user to select one*/
   static final String [] TYPES_OF_CARS = {"Sedan", "Coupe", "Wagon"};
   /** An array containing possible towing capabilities for car */
   static final String [] TOWING_CAPABILITY = {"Towing Package", "No towing package"};
   /** Attribute labels to display in GUI */
   static final String [] CAR_ATTRIBUTE_LABELS = {"Type of car", "Towing package"};
   /** Describes the type of vehicle */
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
*  Constructor obtains model, color, cost, type of car, towing package presence
*  and saves them to the object.
*  @param carModel Model of the car
*  @param carColor Color of the car
*  @param carCost Cost of the car
*  @param carTypeIndex Index of type of car
*  @param towingPackageIndex Index of towing package presence
*/

   public Car(String carModel, String carColor, double carCost, 
   int carTypeIndex, int towingPackageIndex)
   {
      super(carModel, carColor, carCost);
      this.setCarType(carTypeIndex);
      this.setTowingPackage(towingPackageIndex);
   }//end of constructor

  
/**
*  Accessor method that returns the type of car.
*  @return Type of car
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
*  @return Presence or absence of towing package
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
*  @param _carType Index of type of car to be set
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
*  @param _towingPackage Index of towing package presence
*/
   public void setTowingPackage(int _towingPackage)
   {
      if (_towingPackage >= 0 && _towingPackage < TOWING_CAPABILITY.length)
      {
         this.towingPackage = _towingPackage;
      }
     
   }//end of setTowingPackage() method
   
/**
*  Accessor method that returns the care type menu options
*  @return Array of all types of cars
*/          
   public static String[] getCarTypeOptions()
   {
      return TYPES_OF_CARS;
   }//end of getCarTypeOptions()
   
/**
*  Accessor method that returns the car towing package menu options
*  @return Array of all towing package options
*/ 
   public static String[] getTowingOptions()
   {
      return TOWING_CAPABILITY;
   }//end of getTowingOptions()
   
/**
*  Accessor method that returns the car attribute labels
*  @return Array of attribute labels for menu display
*/    
   public static String[] getAttributeLabels()
   {
      return CAR_ATTRIBUTE_LABELS;
   }//end of getAttributeLabels()

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
*  @return The mileage of the car based on its type
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
*  @return Printing statement of this object
*/   
   public String toString()
   {
      return super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Type:", this.getCarType(),"", "Towing:", this.getTowingPackage());
   }//end of toString() method

}//end class Car