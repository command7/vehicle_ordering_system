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
   private int use = -1;
   private int category = -1;
   private final static String[] USE = {"Recreational Sledding", "Competitive Sledding"};
   private final static String[] CATEGORY = {"Inflatable Sled", "Toboggan", "Bobsled"};
   private final String ques1 = "What is this sled used for?";
   private final String ques2 = "What kind of sled is this?";
   final static String VEHICLE_IS = "Sled";
   final static String [] SLED_ATTRIBUTE_LABELS = {"Used for", "Type of sled"};
   
   // Constructor
   public Sled(){
      //System.out.println("Entering Sled order:");
      super(VEHICLE_IS);  
      //this.makeVehicle();
      this.setUse( this.showMenu(ques1, USE) ); 
      this.setCategory( this.showMenu(ques2, CATEGORY) );
   }
   
   public Sled(String sledModel, String sledColor, double sledCost, 
   int sledUseIndex, int sledCategoryIndex)
   {
      super(sledModel, sledColor, sledCost);
      this.setUse(sledUseIndex);
      this.setCategory(sledCategoryIndex);
   }

   
   // Methods
   public static String[] getSledUseOptions()
   {
      return USE;
   }
   
   public static String[] getSledCategoryOptions()
   {
      return CATEGORY;
   }
   
   public static String[] getAttributeLabels()
   {
      return SLED_ATTRIBUTE_LABELS;
   }

   
   // Start getter/setter methods   
   public String getUse(){
      return USE[use];
   }//end getUse()
   
   public void setUse(int aUse){
      this.use = aUse;
   }//end setUse()
   
   public String getCategory(){
      return CATEGORY[category];
   }//end getCategory()
   
   public void setCategory(int aCat){
      this.category = aCat;
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