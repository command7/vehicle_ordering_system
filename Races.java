
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
   private int iconWidth = newContestant.getIconWidth();
   private int iconHeight = newContestant.getIconHeight();
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
   }
     
   public void startRace()
   {
      for(Contestant indivContestant : contestants)
      {
         new Thread(indivContestant).start();
      }
   }
   
   public synchronized void announceWinner(Contestant winnerContestant)
   {
      finishedFirst = true;
      winnerContestant.winner = true;
      winnerContestant.repaint();
            
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
      private boolean winner = false;
      
      public Contestant(int _contestNum)
      {
         this.contestNum = _contestNum;
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
         g.drawLine(this.getWidth() - (iconWidth * 2),0, this.getWidth() - (iconWidth*2), this.getHeight());
         if(winner)
         {
            g.drawString("Winner is: #" + this.contestNum, 20, this.getHeight()-70);
         }
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