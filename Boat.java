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

public class Boat extends Vehicle
{
   /** Saves the index of type of boat */
   private int boatType = -1;
   /** Saves the index of construction type of the boat */
   private int boatConstruction = -1;
   /** A String array containing options for types of boat menu*/
   final String [] typesOfBoat = {"Pontoon", "PWC", "Sailboat"};
   /** A String array containing options for construction types of boat menu */
   final String [] typesOfBoatConstruction = {"Wood", "Fiberglass", "Steel"};
   
/**
*  Constructor asks the details of the boat and stores them in respective
*  variables using mutators.
*/
   public Boat()
   { 
      super.generalDetailsMenu();
      typeOfBoatMenu();
      boatConstructionMenu();
   }//end of constructor
   
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
         return typesOfBoat[boatType];
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
         return typesOfBoatConstruction[boatConstruction];
      }
   }//end of getBoatConstruction() method
   
/**
*  Mutator method that is used to set/modify the type of the boat.
*/
   public void setBoatType(int _boatType)
   {
      if(_boatType >=0 && _boatType < typesOfBoat.length)
      {
         this.boatType = _boatType;
      }
   }//end of setBoatType() method
   
/**
*  Mutator method that is used to set/modify the construction type of the boat.
*/
   public void setBoatConstruction(int _boatConstruction)
   {
      if(_boatConstruction >= 0 && _boatConstruction < typesOfBoatConstruction.length)
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
      int typeOfBoatIndex = super.showMenu("What type of boat is this? ", typesOfBoat);
      setBoatType(typeOfBoatIndex);
      
   }//end of typeOfBoatMenu() method
   
/**
*  Input method that is used to request the construction type of the boat from the user,
*  and store it in its respective variable.
*/
   public void boatConstructionMenu()
   {
      int boatConstructionMenuIndex = super.showMenu("What is the boat's construction? ", typesOfBoatConstruction);
      setBoatConstruction(boatConstructionMenuIndex);
   }//end of boatConstructionMenu() method
   
/**
*  Estimates the mileage of the boat
*/
   public double gasMileage()
   {
      if (this.getBoatType().equals("Pontoon"))
      {
         return pontoonMpg;
      }
      else if (this.getBoatType().equals("PWC"))
      {
         return pwcMpg;
      }
      else
      {
         return sailBoatMpg;
      }
   }
   
/**
*  Method that specifies the printing statement of boat object
*/
   public String toString()
   {
      return "Boat:\n" + super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n","", "Type:",
      this.getBoatType(),"", "Made of:", this.getBoatConstruction());
   }//end of toString() method
   
}// end class Boat