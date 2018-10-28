/**
*Purpose:   This program is used to create a boat order. It will ask
*           the user for the model, color, cost, boat type, construction type and
*           store it. <br/>
*                     <br/>
*Caveats:   It uses Vehicle class to accept user input.
*           User must select boat type and construction type from the options provided.
*                     <br/>
*Date:      September 30, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.0
*/

import java.io.*;
public class Boat extends Vehicle 
{
   /** Saves the index of type of boat */
   private int boatType = -1;
   /** Saves the index of construction type of the boat */
   private int boatConstruction = -1;
   final static String VEHICLE_IS = "Boat";
   
/**
*  Constructor asks the details of the boat and stores them in respective
*  variables using mutators.
*/
   public Boat()
   { 
      super(VEHICLE_IS);
      typeOfBoatMenu();
      boatConstructionMenu();
   }//end of constructor
   
   
   public static String[] getBoatTypeOptions()
   {
      return TYPES_OF_BOATS;
   }
   
   public static String[] getBoatConstructionOptions()
   {
      return TYPES_OF_BOAT_CONSTRUCTION;
   }
   
   public static String[] getAttributeLabels()
   {
      return BOAT_ATTRIBUTE_LABELS;
   }

/**
*  Accessor method that returns the type of the boat.
*/
   public String getBoatType()
   {
      if(boatType == -1)
      {
         return "";
      }
      else
      {
         return TYPES_OF_BOATS[boatType];
      }
   }// end of getBoatType() method
   
/**
*  Accessor method that returns the construction type of the boat.
*/
   public String getBoatConstruction()
   {
      if(boatConstruction == -1)
      {
         return "";
      }
      else
      {
         return TYPES_OF_BOAT_CONSTRUCTION[boatConstruction];
      }
   }//end of getBoatConstruction() method
   
/**
*  Mutator method that is used to set/modify the type of the boat.
*/
   public void setBoatType(int _boatType)
   {
      if(_boatType >=0 && _boatType < TYPES_OF_BOATS.length)
      {
         this.boatType = _boatType;
      }
   }//end of setBoatType() method
   
/**
*  Mutator method that is used to set/modify the construction type of the boat.
*/
   public void setBoatConstruction(int _boatConstruction)
   {
      if(_boatConstruction >= 0 && _boatConstruction < TYPES_OF_BOAT_CONSTRUCTION.length)
      {
         this.boatConstruction = _boatConstruction;
      }
   }//end of setBoatConstruction() method
   
/**
*  Input method that is used to request the type of the boat from the user,
*  and store it in its respective variable.
*/
   public void typeOfBoatMenu()
   {
      setBoatType(super.showMenu("What type of boat is this? ", TYPES_OF_BOATS));
   }//end of typeOfBoatMenu() method
   
/**
*  Input method that is used to request the construction type of the boat from the user,
*  and store it in its respective variable.
*/
   public void boatConstructionMenu()
   {
      setBoatConstruction(super.showMenu("What is the boat's construction? ", TYPES_OF_BOAT_CONSTRUCTION));
   }//end of boatConstructionMenu() method
   
/**
*  Estimates the mileage of the boat
*/
   public double gasMileage()
   {
      if (this.getBoatType().equals("Pontoon"))
      {
         return PONTOON_MPG;
      }
      else if (this.getBoatType().equals("PWC"))
      {
         return PWC_MPG;
      }
      else
      {
         return SAIL_BOAT_MPG;
      }
   }
   
/**
*  Method that specifies the printing statement of boat object
*/
   public String toString()
   {
      return super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n","", "Type:",
      this.getBoatType(),"", "Made of:", this.getBoatConstruction());
   }//end of toString() method
   
}// end class Boat