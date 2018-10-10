/**
*Purpose:   This program is used to create a truck order. It will ask
*           the user for the model, color, cost, truck size, engine size and
*           store it. <br/>
*                     <br/>
*Caveats:   This class uses Vehicle class to accept input.ww
*           User must select truck size and engine size from the options provided.
*                     <br/>
*Date:      September 23, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.1
*/

import java.util.*;
public class Truck extends Vehicle
{
   /** Stores the index for size of the truck. */
   private int truckSize = -1;
   /** Stores the  index for engine size of the truck */
   private int engineSize = -1;
   /** Stores various sizes of truck as menu options for the user to select from */ 
   final String [] allTruckSizes = {"Half-ton", "Full ton"};
   /** Stores various engine sizes as menu options for the user to select from  */
   final String [] allEngineSizes = {"1000cc", "2000cc"};
   
/**
*  Constructor asks the details of the truck and stores them in respective
*  variables using mutators.
*/
   public Truck()
   {
      super.generalDetailsMenu();
      truckSizeMenu();
      engineSizeMenu();
   }
   
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
         return allTruckSizes[truckSize];
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
         return allEngineSizes[engineSize];
      }
   }//end of getEngineSize() method
      
/**
*  Mutator method that is used to set/modify the size of the truck.
*/
   public void setTruckSize(int _truckSize) 
   {
      if (_truckSize >= 0 && _truckSize < allTruckSizes.length)
      {
         this.truckSize = _truckSize;
      }  
   }//end of setTruckSize() method
   
 
/**
*  Mutator method that is used to set/modify the engine size of the truck.
*/
   public void setEngineSize(int _engineSize)
   {
      if (_engineSize >= 0 && _engineSize < allEngineSizes.length)
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
      int truckSizeIndex = super.showMenu("What size truck is this? ",allTruckSizes);
      setTruckSize(truckSizeIndex);
   }//end of truckSizeMenu() method
   
/**
*  Input method that is used to request the engine size of the truck
*  from the user and store it in its respective variable.
*/
   public void engineSizeMenu()
   {
      int engineSizeIndex = super.showMenu("What is the engine size of the truck? ",allEngineSizes);
      setEngineSize(engineSizeIndex);
   }//end of engineSizeMenu() method
   
/**
*  Method that is used to specify the print statement of truck object.
*/
   public String toString()
   {
      return "Truck:\n" + super.toString() +String.format("%n%5s%-10s %s%n%5s%-10s %s%n"
                           ,"", "Load:", this.getTruckSize(),"", "Engine:", this.getEngineSize());
   }//end of toString() method
}// end class Truck