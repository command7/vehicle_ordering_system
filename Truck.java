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
*  Constructor obtains model, color, cost, type of truck, type of construction
*  and saves them to the object.
*  @param truckModel Model of the truck
*  @param truckColor Color of the truck
*  @param truckCost Cost of the truck
*  @param truckSizeIndex Index of size of truck
*  @param engineSizeIndex Index of engine size
*/
   public Truck(String truckModel, String truckColor, double truckCost, 
   int truckSizeIndex, int engineSizeIndex)
   {
      super(truckModel, truckColor, truckCost, VEHICLE_IS);
      this.setTruckSize(truckSizeIndex);
      this.setEngineSize(engineSizeIndex);
   }
      
   
/**
*  Accessor method that returns truck size menu options
*  @return Array of all truck sizes
*/    
   public static String[] getTruckSizeOptions()
   {
      return ALL_TRUCK_SIZES;
   }//end of getTruckSizeOptions()
   
/**
*  Accessor method that returns engine size menu options
*  @return Array of all engine sizes
*/ 
   public static String[] getEngineSizeOptions()
   {
      return ALL_ENGINE_SIZES;
   }//end of getEngineSizeOptions
   
/**
*  Accessor method that returns attribute labels
*  @return Array of attribute labels for menu display
*/ 
   public static String[] getAttributeLabels()
   {
      return TRUCK_ATTRIBUTE_LABELS;
   }//end of getAttributeLabels()
   
/**
*  Accessor method that returns the size of the truck.
*  @return Size of truck
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
*  @return Engize size of truck
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
*  @param _truckSize Index of truck size
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
*  @param _engineSize Index of engine size
*/
   public void setEngineSize(int _engineSize)
   {
      if (_engineSize >= 0 && _engineSize < ALL_ENGINE_SIZES.length)
      {
         this.engineSize = _engineSize;
      }  
   }//end of setEngineSize() method
   
/**
*  Estimates the mileage of the Truck
*  @return Mileage of truck based on cost
*/
   public double gasMileage()
   {
      return 50 - (Math.sqrt(this.getVehicleCost())/10.0);
   }
   
/**
*  Method that is used to specify the print statement of truck object.
*  @return Printing Statement
*/
   public String toString()
   {
      return super.toString() +String.format("%n%5s%-10s %s%n%5s%-10s %s%n"
                           ,"", "Load:", this.getTruckSize(),"", "Engine:", this.getEngineSize());
   }//end of toString() method
}// end class Truck