/**
*Purpose:   This program is a parent class that has methods and attributes that will be used
*           by car, boat,truck, Sled and MercedesBenz classes.<br/>
*                                                            <br/>
*Caveats:   Child classes need to use super keyword to access these functions. <br/>
*           
*Date:      November 3, 2018
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
   
/**
*  Constructor takes in the model, color and cost of the vehicle and stores it
*  @param vehicleModel Model of vehicle
*  @param vehicleColor Color of vehicle
*  @param vehicleCost Cost of vehicle
*/   
   public Vehicle(String vehicleModel, String vehicleColor, double vehicleCost, String _vehIs)
   {
      this.setVehicleModel(vehicleModel);
      this.setVehicleColor(vehicleColor);
      this.setVehicleCost(vehicleCost);
      this.setVehIs(_vehIs);
   }
   
/**
*  Accessor method that returns the model of the vehicle.
*  @return Model of the vehicle
*/
   public String getVehicleModel()
   {
      return this.vehicleModel;
   }//end of getVehicleModel() method
   
/**
*  Accessor method that returns the color of the vehicle.
*  @return Color of the vehicle
*/
   public String getVehicleColor()
   {
      return this.vehicleColor;
   }//end of getVehicleColor() method
   
/**
*  Accessor method that returns the cost of the vehicle.
*  @return Cost of the vehicle
*/
   public double getVehicleCost()
   {
      return this.vehicleCost;
   }//end of getVehicleCost() method
   
/**
*  Returns what vehicle it is
*  @return What vehicle
*/
   public String getVehIs()
   {
      return this.vehIs;
   }
/**
*  Mutator method that is used to set/modify the model of the vehicle.
*  @param _vehicleModel Model of vehicle
*/
   public void setVehicleModel(String _vehicleModel)
   {
      this.vehicleModel = _vehicleModel;
   }//end of setVehicleModel() method
   
/**
*  Mutator method that is used to set/modify the color of the vehicle.
*  @param _vehicleColor Color of vehicle
*/
   public void setVehicleColor(String _vehicleColor)
   {
      this.vehicleColor = _vehicleColor;
   }//end of setVehicleColor() method
   
/**
*  Mutator method that is used to set/modify the cost of the vehicle.
*  @param _vehicleCost Cost of vehicle
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
*  Abstract class that estimates the mileage of a vehicle.
*  Will be used by child classes.
*/
   public abstract double gasMileage();
   
/**
*  Print Statement for vehicle class
*  @return Printing Statement
*/
   public String toString()
   {
      return String.format("%s%n%5s%-10s %s%n%5s%-10s %s%n%5s%-10s $%.2f%n%5s%-10s %.1f",this.getVehIs(),
"",
      "Model:",this.getVehicleModel(),"","Color:", this.getVehicleColor(),"", "Cost:", 
      this.getVehicleCost(),"","MPG/GPH:", this.gasMileage());
   }

}// end class Vehicle