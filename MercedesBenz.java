/**
*Purpose:   This program is used to create a MercedesBenz order. It will ask
*           the user for the model, color, cost, fuel type and type of drive
*           and store it. <br/>
*                         <br/>
*Caveats:   This class uses Vehicle class to accept certain input.
*           User must select make of car and type of drive from the options provided.
*                     <br/>
*Date:      October 11, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.1
*/

public class MercedesBenz extends Vehicle
{
   /** Stores the index of the type of make  */
   private int typeOfFuel = -1;
   /** Stores the index of the type of drive */
   private int typeOfDrive = -1;
   /** Contains all options of makes */
   private static final String [] FUEL_TYPES = {"Unleaded Petrol", "Diesel"};
   /** Contains all driving types available */
   private static final String [] ALL_DRIVES = {"FWD", "4Matic"};
   
/**
*  Constructor asks the details of the Benz and stores them in respective
*  variables using mutators. 
*/
   public MercedesBenz ()
   {
      super();
      typeOfFuelMenu();
      typeOfDriveMenu();   
   }//end of constructor
   
/**
*  Accessor method that returns the make
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
* Accessor method that sets/modifes the type of make  
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
*/
/* gasMileage Constants for this class 
      final static double benzPetrolMpg = 20.8;
      final static double benzDieselMpg = 22.0;
      final static double benzAwdMileageReduction = 2.0; 
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
*  Input method used to request the type of make from the user
*  and store it in respective variables.
*/
   public void typeOfFuelMenu()
   {
      setTypeOfFuel(super.showMenu("What type of fuel is used?", FUEL_TYPES));
   }//end of typeOfFuelMenu() method
   
/**
*  Input method used to request the type of drive from the user
*  and store it in respective variables.
*/
   public void typeOfDriveMenu()
   {
      setTypeOfDrive(super.showMenu("What type of Drive is this?", ALL_DRIVES));
   }//end of typeOfDriveMenu() method
   
/**
*  Print statement for MercedesBenz class
*/
   public String toString()
   {
      return "Mercedes Benz:\n" + super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Fuel Type:", this.getTypeOfFuel(),"", "Drive:", this.getTypeOfDrive());
   }//end of toString() method
   
}//end class MercedesBenz