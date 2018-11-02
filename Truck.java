/**
*Purpose:   This program is used to create a truck order. It will ask
*           the user for the model, color, cost, truck size, engine size and
*           store it. <br/>
*                     <br/>
*Caveats:   This class uses Vehicle class to accept input.ww
*           User must select truck size and engine size from the options provided.
*                     <br/>
*Date:      October 29, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.1
*/

import java.util.*;
import java.io.*;
public class Truck extends Vehicle 
{
   /** Stores the index for size of the truck. */
   private int truckSize = -1;
   /** Stores the  index for engine size of the truck */
   private int engineSize = -1;
   /** Stores various sizes of truck as menu options for the user to select from */ 
   static final String [] ALL_TRUCK_SIZES = {"Half-ton", "Full ton"};
   /** Stores various engine sizes as menu options for the user to select from  */
   static final String [] ALL_ENGINE_SIZES = {"1000cc", "2000cc"};
   /** Contains attribute labels to be displayed in GUI */
   static final String [] TRUCK_ATTRIBUTE_LABELS = {"Truck size", "Engine size"};
   /** Describes the type of vehicle */
   final static String VEHICLE_IS = "Truck";

   
/**
*  Constructor asks the details of the truck and stores them in respective
*  variables using mutators.
*/
   public Truck()
   {
      super(VEHICLE_IS);
      truckSizeMenu();
      engineSizeMenu();
   }
   
   public Truck(String truckModel, String truckColor, double truckCost, 
   int truckSizeIndex, int engineSizeIndex)
   {
      super(truckModel, truckColor, truckCost);
      this.setTruckSize(truckSizeIndex);
      this.setEngineSize(engineSizeIndex);
   }
      
   
/**
*  Accessor method that returns truck size menu options
*/    
   public static String[] getTruckSizeOptions()
   {
      return ALL_TRUCK_SIZES;
   }//end of getTruckSizeOptions()
   
/**
*  Accessor method that returns engine size menu options
*/ 
   public static String[] getEngineSizeOptions()
   {
      return ALL_ENGINE_SIZES;
   }//end of getEngineSizeOptions
   
/**
*  Accessor method that returns attribute labels
*/ 
   public static String[] getAttributeLabels()
   {
      return TRUCK_ATTRIBUTE_LABELS;
   }//end of getAttributeLabels()
   
/**
*  Accessor method that returns the size of the truck.
*/
   public String getTruckSize()
   {
      if (truckSize == -1)
      {
         return "";
      }
      else
      {
         return ALL_TRUCK_SIZES[truckSize];
      }
   }//end of getTruckSize() method
   
/**
*  Accessor method that return the engine size of the truck.
*/
   public String getEngineSize()
   {
      if (engineSize == -1)
      {
         return "";
      }
      else
      {
         return ALL_ENGINE_SIZES[engineSize];
      }
   }//end of getEngineSize() method
      
/**
*  Mutator method that is used to set/modify the size of the truck.
*/
   public void setTruckSize(int _truckSize) 
   {
      if (_truckSize >= 0 && _truckSize < ALL_TRUCK_SIZES.length)
      {
         this.truckSize = _truckSize;
      }  
   }//end of setTruckSize() method
   
 
/**
*  Mutator method that is used to set/modify the engine size of the truck.
*/
   public void setEngineSize(int _engineSize)
   {
      if (_engineSize >= 0 && _engineSize < ALL_ENGINE_SIZES.length)
      {
         this.engineSize = _engineSize;
      }  
   }//end of setEngineSize() method
         
/**
*  Input method that is used to request the size of the truck from the user,
*  and store it in its respective variable.
*/
   public void truckSizeMenu()
   {
      setTruckSize(super.showMenu("What size truck is this? ",ALL_TRUCK_SIZES));
   }//end of truckSizeMenu() method
   
/**
*  Input method that is used to request the engine size of the truck
*  from the user and store it in its respective variable.
*/
   public void engineSizeMenu()
   {
      setEngineSize(super.showMenu("What is the engine size of the truck? ",ALL_ENGINE_SIZES));
   }//end of engineSizeMenu() method
   
/**
*  Estimates the mileage of the Truck
*/
   public double gasMileage()
   {
      return 50 - (Math.sqrt(this.getVehicleCost())/10.0);
   }
   
/**
*  Method that is used to specify the print statement of truck object.
*/
   public String toString()
   {
      return super.toString() +String.format("%n%5s%-10s %s%n%5s%-10s %s%n"
                           ,"", "Load:", this.getTruckSize(),"", "Engine:", this.getEngineSize());
   }//end of toString() method
}// end class Truck