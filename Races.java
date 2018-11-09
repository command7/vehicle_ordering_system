
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Races extends JFrame
{
   private int numberOfContestants;
   private ArrayList<Contestant> contestants = new ArrayList<Contestant>();
   public boolean finishedFirst = false;
   private Icon newContestant = new ImageIcon("races.jpg");
   private int finishLineX;
   private boolean winnerAnnounced = false;
   private int contestantNumber = 1;
   public Races(int _numberOfContestants)
   {
      this.numberOfContestants = _numberOfContestants;
      createMainFrame();
      try{
      Thread.sleep(2000);
      }
      catch(Exception e) { }
      startRace();
   }
   
   public void createMainFrame()
   {
      this.setLayout(new GridLayout(0,1));
      for (int count=0; count < numberOfContestants; count++)
      {
         Contestant newContestant = new Contestant(contestantNumber++);
         this.add(newContestant);
         contestants.add(newContestant);
      }
      
      this.setSize(20 * newContestant.getIconWidth(),newContestant.getIconHeight() * 2 * numberOfContestants);
      finishLineX = this.getWidth() - (newContestant.getIconWidth() * 2);
      this.setTitle("Off to the Races- by Vijay Raj Saravanan Radhakrishnan");
      this.setVisible(true);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
   }
     
   public void startRace()
   {
      for(Contestant indivContestant : contestants)
      {
         new Thread(indivContestant).start();
      }
   }
   
   public synchronized void announceWinner(Contestant winner)
   {
      finishedFirst = true;
            
   }
   
   
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
   }

   
   protected class Contestant extends JPanel implements Runnable
   {
      private int xCoordinate = 0;
      private int contestNum;
      
      public Contestant(int _contestNum)
      {
         this.contestNum = _contestNum;
         System.out.println(this.contestNum);
      }
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
               xCoordinate = xCoordinate + 3;
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
      }
      
      public void paint(Graphics g)
      {
         super.paint(g);
         newContestant.paintIcon(this, g, xCoordinate, 0);
         g.drawLine(this.getWidth() - (newContestant.getIconWidth() * 2),0, this.getWidth() - (newContestant.getIconWidth()*2), this.getHeight());
      }
      
          
   }
   
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
}