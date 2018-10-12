/**
*Purpose:   This program is used to create a MercedesBenz order. It will ask
*           the user for the model, color, cost, make of car and type of drive
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
   private int typeOfMake = -1;
   /** Stores the index of the type of drive */
   private int typeOfDrive = -1;
   /** Contains all options of makes */
   private static final String [] allMakes = {"Coupe", "Sedan", "SUV", "Cabriolet"};
   /** Contains all driving types available */
   private static final String [] allDrives = {"FWD", "4Matic"};
   
/**
*  Constructor asks the details of the Benz and stores them in respective
*  variables using mutators. 
*/
   public MercedesBenz ()
   {
      super();
      typeOfMakeMenu();
      typeOfDriveMenu();   
   }//end of constructor
   
/**
*  Accessor method that returns the make
*/
   public String getTypeOfMake()
   {
      if (this.typeOfMake == -1)
      {
         return "";
      }
      else
      {
         return allMakes[this.typeOfMake];
      }
   }//end of getTypeOfMake() method
   
/**
*  Accessor method that returns the driving type
*/
   public String getTypeOfDrive()
   {
      if (this. typeOfDrive == -1)
      {
         return "";
      }
      else
      {
         return allDrives[this.typeOfDrive];
      }
   }//end of getTypeOfDrive() method
   
/**
* Accessor method that sets/modifes the type of make  
*/
   public void setTypeOfMake(int _typeOfMake)
   {
      if (_typeOfMake >= 0 && _typeOfMake < allMakes.length)
      {
         this.typeOfMake = _typeOfMake;
      }
   }//end of setTypeOfMake() method
   
/**
*  Accessor method that sets/modifies the type of drive
*/
   public void setTypeOfDrive(int _typeOfDrive)
   {
      if (_typeOfDrive >= 0 && _typeOfDrive < allDrives.length)
      {
         this.typeOfDrive = _typeOfDrive;
      }
   }//end of setTypeOfDrive() method
   
/** 
*  This method estimates the mileage based on the type of make and type of drive
*/
/* gasMileage Constants for this class 
      final static double benzSedanMpg = 19.0;
      final static double benzSuvMpg = 18.0;
      final static double benzCabrioletMpg = 20.0;
      final static double benzAwdMileageReduction = 2.0; 
*/
   public double gasMileage()
   {
      double mileage = 0;
      if (this.getTypeOfMake().equals("Coupe"))
      {
         mileage = benzCoupeMpg;
      }
      else if (this.getTypeOfMake().equals("Sedan"))
      {
         mileage = benzSedanMpg;
      }
      else if (this.getTypeOfMake().equals("SUV"))
      {
         mileage = benzSuvMpg;
      }
      else
      {
         mileage = benzCabrioletMpg;
      }
      if (this.getTypeOfDrive().equals("4Matic"))
      {
         mileage -= benzAwdMileageReduction;
      }
      return mileage;
   }//end of gasMileage() method
   
/**
*  Input method used to request the type of make from the user
*  and store it in respective variables.
*/
   public void typeOfMakeMenu()
   {
      setTypeOfMake(super.showMenu("What type of Car is this?", allMakes));
   }//end of typeOfMakeMenu() method
   
/**
*  Input method used to request the type of drive from the user
*  and store it in respective variables.
*/
   public void typeOfDriveMenu()
   {
      setTypeOfDrive(super.showMenu("What type of Drive is this?", allDrives));
   }//end of typeOfDriveMenu() method
   
/**
*  Print statement for MercedesBenz class
*/
   public String toString()
   {
      return "Mercedes Benz:\n" + super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Car Type:", this.getTypeOfMake(),"", "Drive Type:", this.getTypeOfDrive());
   }//end of toString() method
   
}//end class MercedesBenz