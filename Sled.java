/* Purpose: This class holds all of the attributes specific to the Sled class and is
*           a child (subclass) of Vehicle. This class also has a toString() method that is used to format
*           information to be printed to the user by combining Vehicle's toString() method and the variables
*           unique to the Sled class.
*
* Caveats:  N/A
*
* Date:     October 10th, 2018
* @author   Brooke Daniels
* @version  1.0
*/

import java.io.*;
public class Sled extends Vehicle
{
   // Attributes
   private String use;
   private String category;
   private final static String[] USE = {"Recreational Sledding", "Competitive Sledding"};
   private final static String[] CATEGORY = {"Inflatable Sled", "Toboggan", "Bobsled"};
   private final String ques1 = "What is this sled used for?";
   private final String ques2 = "What kind of sled is this?";
   final static String VEHICLE_IS = "Sled";
   
   // Constructor
   public Sled(){
      //System.out.println("Entering Sled order:");
      super(VEHICLE_IS);  
      //this.makeVehicle();
      this.setUse( USE[this.showMenu(ques1, USE)] ); 
      this.setCategory( CATEGORY[this.showMenu(ques2, CATEGORY)] );
   }
   
   // Methods
   
   // Start getter/setter methods   
   public String getUse(){
      return use;
   }//end getUse()
   
   public void setUse(String aUse){
      if(aUse instanceof String){
         this.use = aUse;
      }
   }//end setUse()
   
   public String getCategory(){
      return category;
   }//end getCategory()
   
   public void setCategory(String aCat){
      if(aCat instanceof String){
         this.category = aCat;
      }
   }//end setCategory()
   // End getter/setter methods
   
   /**
      Method that overrides the abstract gasMileage method found in Vinfo/Vehicle. 
      There are no constants variables to be added to Vinfo because these kinds of sleds
      are human or animal powered.
   */
   public double gasMileage(){
      double finalMPG = 0.0;
      return finalMPG;
   }// End gasMileage()
   
   /**
      Method that accesses all of the attributes of the Sled and Vehicle classes and formats them into 
      a string that will be returned for printing
   */
   public String toString(){
      String output = super.toString() + "\n   Use:      " + this.getUse() + "\n   Category: " + this.getCategory();
      return output;
   } //end toString()
}// Ends Sled Class