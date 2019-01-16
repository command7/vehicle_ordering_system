/**
*Purpose:   This program is used to create a boat order. It will receive
*           the model, color, cost, boat type, construction type and
*           store it. <br/>
*                     <br/>
*Caveats:   It is a child of Vehicle Class.
*           User must select boat type and construction type from the options provided.
*                     <br/>
*Date:      November  3, 2018
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
   /** A String array containing options for types of boat menu*/
   static final String [] TYPES_OF_BOATS = {"Pontoon", "PWC", "Sailboat"};
   /** A String array containing options for construction types of boat menu */
   static final String [] TYPES_OF_BOAT_CONSTRUCTION = {"Wood", "Fiberglass", "Steel"};
   /** Attribute labels to display with menu in GUI */
   static final String [] BOAT_ATTRIBUTE_LABELS = {"Type of boat", "Construction"};
   /** Describes the type of vehicle */
   final static String VEHICLE_IS = "Boat";   
   
/**
*  Constructor obtains model, color, cost, type of boat, type of construction
*  and saves them to the object.
*  @param boatModel Model of the boat
*  @param boatColor Color of the boat
*  @param boatCost Cost of the boat
*  @param boatTypeIndex Index of type of boat
*  @param boatConstructionIndex Index of boat construction
*/
   public Boat(String boatModel, String boatColor, double boatCost, 
   int boatTypeIndex, int boatConstructionIndex)
   {
      super(boatModel, boatColor, boatCost, VEHICLE_IS);
      this.setBoatType(boatTypeIndex);
      this.setBoatConstruction(boatConstructionIndex);
   }

   
/**
*  Accessor method that returns the boat type menu options
*  @return Array of types of boats
*/   
   public static String[] getBoatTypeOptions()
   {
      return TYPES_OF_BOATS;
   }//end of getBoatTypeOptions()
   
/**
*  Accessor method that returns the boat construction menu options
*  @return Array of type of boat construction 
*/ 
   public static String[] getBoatConstructionOptions()
   {
      return TYPES_OF_BOAT_CONSTRUCTION;
   }//end of getBoatConstructionOptions()
   
/**
*  Accessor method that returns the boat menu labels
*  @return Array of attribute lables for meny display
*/    
   public static String[] getAttributeLabels()
   {
      return BOAT_ATTRIBUTE_LABELS;
   }//end of getAttributeLabels()

/**
*  Accessor method that returns the type of the boat.
*  @return Type of the boat
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
*  @return Type of construction of the boat
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
*  @param _boatType index of boat type to be set
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
*  @param _boatConstruction Index of construction type
*/
   public void setBoatConstruction(int _boatConstruction)
   {
      if(_boatConstruction >= 0 && _boatConstruction < TYPES_OF_BOAT_CONSTRUCTION.length)
      {
         this.boatConstruction = _boatConstruction;
      }
   }//end of setBoatConstruction() method
   
   
/**
*  Estimates the mileage of the boat
*  @return Mileage of the boat based on its type
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
*  @return Printing statement for the boat
*/
   public String toString()
   {
      return super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n","", "Type:",
      this.getBoatType(),"", "Made of:", this.getBoatConstruction());
   }//end of toString() method
   
}// end class Boat