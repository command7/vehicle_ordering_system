/**
*Purpose:   This program creates any number of car orders or truck orders for  the user based on their 
*           selection and prints all the orders out. <br/>
*                                                    <br/>
*Caveats:   The program will keep repeating unless a valid input is entered. <br/>
*Date:      September 23, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.1
*/

import java.util.*;
public class Orders
{
   /** Scanner object to get user input. */
   Scanner scan = new Scanner(System.in);
   /** An ArrayList that stores all orders made by the user. */
   ArrayList ordersMade = new ArrayList(); 
   
/**
*  Constructor places a series of orders based on the input from user which will specify whether a car 
*  of truck is ordered. After ordering is complete, it prints out each and every order.
*/
   public Orders()
   {
      placeOrder();
      printAllOrders();
   }//end of Order Constructor
   
/**
*  This method loops through the Arraylist and prints out each object after checking 
*  if it is a valid object.
*/
   public void printAllOrders()
   {
      for (Object vehicle: ordersMade)
      {
         if (vehicle instanceof Car)
         {
            Car orderedCar = (Car)vehicle;
            System.out.println(orderedCar); 
         }
         else if (vehicle instanceof Truck)
         {
            Truck orderedTruck = (Truck)vehicle;
            System.out.println(orderedTruck);
         }
         else if (vehicle instanceof Boat)
         {
            Boat orderedBoat = (Boat)vehicle;
            System.out.println(orderedBoat);
         }
         else if (vehicle instanceof MercedesBenz)
         {
            MercedesBenz orderedMbenz = (MercedesBenz)vehicle;
            System.out.println(orderedMbenz);
         }
         else
         {
            System.out.println("Invalid object type");
         }
      }
      System.out.println("Thank you for using Vijay Raj Saravanan's Ordering System.");
   }// end of printAllOrders() method
   
/**
*  This method asks the user if a car or truck is to be ordered. Based on the user's
*  selection, it creates the respective object.
*/
   public void placeOrder()
   {
      String userInput =  null;
      System.out.println("Vijay Raj Saravanan Radhakrishnan");
      System.out.println("Java for Programmers ISTE-200 2018-Fall \nHomework # 4\n");
      while(true)
      {
         System.out.print("Do you want to order a Truck (T/t) or Car (C/c) or Boat (B/b) or Mercedes Benz (M/m)? ");
         if(!scan.hasNextLine())
         {
            System.out.println("Please enter a valid input");
            continue;
         }
         else 
         {
            userInput = scan.nextLine();
            if (userInput.equals("C") || userInput.equals("c"))
            {
               System.out.println("Entering Car order:");
               Car newCar = new Car();
               ordersMade.add(newCar);
               while(true)
               {
                  System.out.print("Do you want to order another vehicle? ");
                  userInput = scan.nextLine();
                  if (userInput.equals("Y") || userInput.equals("y") || userInput.equals("n") || userInput.equals("N"))
                  {
                     break;    
                  }
                  else
                  {
                     System.out.println("Enter valid input.");
                     continue;
                  }
               }
               if (userInput.equals("Y") || userInput.equals("y"))
               {
                 continue;    
               }
               else
               {
                  break;
               }
            }
            else if (userInput.equals("t") || userInput.equals("T"))
            {
               System.out.println("Entering Truck order:");
               Truck newTruck = new Truck();
               ordersMade.add(newTruck);
               while(true)
               {
                  System.out.print("\nDo you want to order another vehicle? ");
                  userInput = scan.nextLine();
                  if (userInput.equals("Y") || userInput.equals("y") || userInput.equals("n") || userInput.equals("N"))
                  {
                     break;    
                  }
                  else
                  {
                     System.out.println("Enter valid input.");
                     continue;
                  }
               }
               if (userInput.equals("Y") || userInput.equals("y"))
               {
                 continue;    
               }
               else
               {
                  break;
               }
            }
            else if (userInput.equals("b") || userInput.equals("B"))
            {
               System.out.println("Entering Boat order:");
               Boat newBoat = new Boat();
               ordersMade.add(newBoat);
               while(true)
               {
                  System.out.print("\nDo you want to order another vehicle? ");
                  userInput = scan.nextLine();
                  if (userInput.equals("Y") || userInput.equals("y") || userInput.equals("n") || userInput.equals("N"))
                  {
                     break;    
                  }
                  else
                  {
                     System.out.println("Enter valid input.");
                     continue;
                  }
               }
               if (userInput.equals("Y") || userInput.equals("y"))
               {
                 continue;    
               }
               else
               {
                  break;
               }

            }
            else if (userInput.equals("M") || userInput.equals("m"))
            {
               System.out.println("Entering Mercedes Benz order:");
               MercedesBenz newMbenz = new MercedesBenz();
               ordersMade.add(newMbenz);
               while(true)
               {
                  System.out.print("Do you want to order another vehicle? ");
                  userInput = scan.nextLine();
                  if (userInput.equals("Y") || userInput.equals("y") || userInput.equals("n") || userInput.equals("N"))
                  {
                     break;    
                  }
                  else
                  {
                     System.out.println("Enter valid input.");
                     continue;
                  }
               }
               if (userInput.equals("Y") || userInput.equals("y"))
               {
                 continue;    
               }
               else
               {
                  break;
               }

            }
            else
            {
               System.out.println("Please enter a valid input");
               continue;
            }          
         }         
      } 
   }//end of getUserInput() method
   
   //Main program
   public static void main (String [] args)
   {
      Orders ordering = new Orders();
      
   }
   
}//end class Order
  
   