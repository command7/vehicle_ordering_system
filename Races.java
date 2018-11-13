/**
*  Purpose: Create a number contestants and conduct a race between them
*  Date: 13th November 2018
*  @author Vijay Raj Saravanan Radhakrishnan
*  @version 1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Races extends JFrame
{
   /** Stores the number of contestants participating*/
   private int numberOfContestants;
   /** Stores Contestant objects*/
   private ArrayList<Contestant> contestants = new ArrayList<Contestant>();
   /** States whether someone has already completed the race*/
   public boolean finishedFirst = false;
   /** Icon of contestants*/
   private Icon newContestant = new ImageIcon("races.jpg");
   /** X Coordinate of finish line*/
   private int finishLineX;
   /** States whether winner has been announced*/
   private boolean winnerAnnounced = false;
   /** Numbers assigned to contestants that varies for each contestant*/
   private int contestantNumber = 1;
   /** Width of contestant icon*/
   private int iconWidth = newContestant.getIconWidth();
   /** Height of contestant icon*/
   private int iconHeight = newContestant.getIconHeight();
   
/**
*  Constructor creates main JFrame, sleeps for 1 second and starts the race
*  @param _numberOfContestants Number of contestants participating
*/
   public Races(int _numberOfContestants)
   {
      this.numberOfContestants = _numberOfContestants;
      createMainFrame();
      try{
      Thread.sleep(1000);
      }
      catch(Exception e) { }
      startRace();
   }//end of Constructor
   
/**
*  Creates required number of Contestant objects, and adds them to the frame
*/
   public void createMainFrame()
   {
      this.setLayout(new GridLayout(0,1));
      for (int count=0; count < numberOfContestants; count++)
      {
         Contestant newParticipant = new Contestant(contestantNumber++);
         this.add(newParticipant);
         contestants.add(newParticipant);
      }
      
      this.setSize(20 * iconWidth,iconHeight * 2 * numberOfContestants);
      finishLineX = this.getWidth() - (iconWidth * 2);
      this.setTitle("Off to the Races- by Vijay Raj Saravanan Radhakrishnan");
      this.setVisible(true);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
   }//end of createMainFrame()
     
/**
*  Starts the race by starting all Contestant threads
*/  
   public void startRace()
   {
      for(Contestant indivContestant : contestants)
      {
         new Thread(indivContestant).start();
      }
   }//end of startRace()
   
/**
*  Synchronized method that sets finishedFirst and winner flags
*  and announces winner on the Contestant Jpanel
*  @param winnerContestant Contestant object
*/
   public synchronized void announceWinner(Contestant winnerContestant)
   {
      finishedFirst = true;
      winnerContestant.winner = true;
      winnerContestant.repaint();         
   }//end of announceWinner()
   
/**
*  Synchronized method that checks if a winner already exists
*  @return If a winner already exists
*/
   public synchronized boolean ifWinnerExists()
   {
      if(finishedFirst)
      {
         return true;
      }
      else
      {
         return false;
      }
   }//end of ifWinnerExists()

/**
*  A Contestant that can be made to animate in a JPanel to conduct a race
*  @author Vijay Raj Saravanan Radhakrishnan
*  Date: 13th November ,2018
*/
   protected class Contestant extends JPanel implements Runnable
   {
      /** X Coordinate position of Contestant */
      private int xCoordinate = 0;
      /** Number assigned to contestant */
      private int contestNum;
      /** Flag that states if Contestant is a winner */
      private boolean winner = false;
      
   /**
   *  Constructor sets the contestant number of a Contestant
   *  @param _contestNum Contestant Number
   */
      public Contestant(int _contestNum)
      {
         this.contestNum = _contestNum;
      }//end of constructor
      
   /**
   *  Moves the Contestant icon based on a random number and announces one contestant
   *  as the winner on reaching the finishing line 
   */
      public void run()
      {
         while(true)
         {
            if(ifWinnerExists())
            {
               break;
            }
            else if(xCoordinate < finishLineX && !ifWinnerExists())
            {
               xCoordinate = xCoordinate + (int)(Math.random()* 5 + 1);
               try
               {
                  Thread.sleep((int)(Math.random()* 30 + 1));
               } catch (Exception ex) {}
               repaint();
            }
            else if(xCoordinate >= finishLineX && !ifWinnerExists()){
               announceWinner(this);
               break;
            }
         
         }
      }//end of run()
      
   /**
   *  Animates the Contestant icon by re drawing it with different X Coordinates
   *  and announces winner on reaching finishing line
   */
      public void paint(Graphics g)
      {
         super.paint(g);
         newContestant.paintIcon(this, g, xCoordinate, 0);
         g.drawLine(this.getWidth() - (iconWidth * 2),0, this.getWidth() - (iconWidth*2), this.getHeight());
         if(winner)
         {
            g.drawString("Winner is: #" + this.contestNum, 20, this.getHeight()-70);
         }
      }        
   }//end of class Contestant
   
/**
*  Main program initializes Races object based on number of contestants argument
*  If no argument is supplied, number of contestants is 5
*  @param args Number of contestants participating
*/
   public static void main(String [] args)
   {
      if (args.length == 0)
      {
         Races test = new Races(5);
      }
      else
      {
         Races test = new Races(Integer.parseInt(args[0]));
      }
   }
   
}//end of Races Class