/**
*Purpose:   This program is used to create a MercedesBenz order. It will receive
*           the model, color, cost, fuel type and type of drive
*           and store it. <br/>
*                         <br/>
*Caveats:   It is a child class of Vehicle Class.
*           User must select make of car and type of drive from the options provided.
*                     <br/>
*Date:      November 3, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.1
*/

import java.io.*;
public class MercedesBenz extends Vehicle
{
   /** Stores the index of the type of make  */
   private int typeOfFuel = -1;
   /** Stores the index of the type of drive */
   private int typeOfDrive = -1;
   /** Describes type of vehicle */
   final static String VEHICLE_IS = "Mercedes Benz";
   /** Contains all options of makes for Mercedes Benz */
   final static String [] FUEL_TYPES = {"Unleaded Petrol", "Diesel"};
   /** Contains all driving types available for Mercedes Benz */
   final static String [] ALL_DRIVES = {"FWD", "4Matic"};
   /** Describes attribute labels to be displayed in GUI */
   final static String [] MBENZ_ATTRIBUTE_LABELS = {"Type of fuel", "Type of drive"};
   
/**
*  Constructor obtains model, color, cost,  fuel type, drive type
*  and saves them to the object.
*  @param benzModel Model of the benz
*  @param benzColor Color of the benz
*  @param benzCost Cost of the benz
*  @param fuelTypeIndex Index of fuel type
*  @param driveTypeIndex Index of type of drive
*/
   public MercedesBenz(String benzModel, String benzColor, double benzCost, 
   int fuelTypeIndex, int driveTypeIndex)
   {
      super(benzModel, benzColor, benzCost, VEHICLE_IS);
      this.setTypeOfFuel(fuelTypeIndex);
      this.setTypeOfDrive(driveTypeIndex);
   }//end of constructor
   
/**
*  Accessor method that returns the make
*  @return Type of fuel
*/
   public String getTypeOfFuel()
   {
      if (this.typeOfFuel == -1)
      {
         return "";
      }
      else
      {
         return FUEL_TYPES[this.typeOfFuel];
      }
   }//end of getTypeOfMake() method
   
/**
*  Accessor method that returns the driving type
*  @return Type of drive
*/
   public String getTypeOfDrive()
   {
      if (this.typeOfDrive == -1)
      {
         return "";
      }
      else
      {
         return ALL_DRIVES[this.typeOfDrive];
      }
   }//end of getTypeOfDrive() method
   
/**
*  Accessor method that sets/modifes the type of make  
*  @param _typeOfFuel Index of type of fuel
*/
   public void setTypeOfFuel(int _typeOfFuel)
   {
      if (_typeOfFuel >= 0 && _typeOfFuel < FUEL_TYPES.length)
      {
         this.typeOfFuel = _typeOfFuel;
      }
   }//end of setTypeOfFuel() method
   
/**
*  Accessor method that sets/modifies the type of drive
*  @param _typeOfDrive Index of type of drive
*/
   public void setTypeOfDrive(int _typeOfDrive)
   {
      if (_typeOfDrive >= 0 && _typeOfDrive < ALL_DRIVES.length)
      {
         this.typeOfDrive = _typeOfDrive;
      }
   }//end of setTypeOfDrive() method
   
/** 
*  This method estimates the mileage based on the type of make and type of drive
*  @return Mileage of benz based on type of fuel
*/
   public double gasMileage()
   {
      double mileage = 0;
      if (this.getTypeOfFuel().equals("Unleaded Petrol"))
      {
         mileage = BENZ_PETROL_MPG;
      }
      else 
      {
         mileage = BENZ_DIESEL_MPG;
      }
      if (this.getTypeOfDrive().equals("4Matic"))
      {
         mileage -=  BENZ_AWD_MILEAGE_REDUCTION;
      }
      return mileage;
   }//end of gasMileage() method
   
/**
*  Accessor method that returns the fuel type menu options
*  @return Array of all fuel types
*/    
   public static String[] getFuelTypeOptions()
   {
      return FUEL_TYPES;
   }//end of getFuelTypeOptions()
   
/**
*  Accessor method that returns the drive type menu options
*  @return Array of all drive types
*/    
   public static String[] getDriveTypeOptions()
   {
      return ALL_DRIVES;
   }//end of getDriveTypeOptions()
   
/**
*  Accessor method that returns the attribute labels
*  @return Array of attribute labels of menu display
*/    
   public static String[] getAttributeLabels()
   {
      return MBENZ_ATTRIBUTE_LABELS;
   }//end of getAttributeLabels()

/**
*  Print statement for MercedesBenz class
*  @return Printing Statement
*/
   public String toString()
   {
      return super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Fuel Type:", this.getTypeOfFuel(),"", "Drive:", this.getTypeOfDrive());
   }//end of toString() method
   
}//end class MercedesBenz