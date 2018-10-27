import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrdersScreen extends JFrame
{
   private String [] vehicleTypes = {"Car", "Boat", "Truck", "Sled", "Mercedes Benz"};
   private JLabel vehicleTypeLabel;
   private JLabel windowHeader;
   private JComboBox vehicleTypeComboBox;
   public OrdersScreen()
   {
      createFrame();
   }
   
   public void createFrame()
   {
            
      String headerText = "<html><b><font color='red' size=5>Student Management System</font><b></html>";
  		windowHeader = new JLabel(headerText);
      this.add(windowHeader);

      vehicleTypeLabel = new JLabel("Vehicle Type", SwingConstants.RIGHT);
      vehicleTypeComboBox = new JComboBox(vehicleTypes);
      this.add(vehicleTypeLabel);
      this.add(vehicleTypeComboBox);
      
      this.setTitle("Orders Screen");
      this.setSize(600,300);
      this.setVisible(true);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

      
      
   }
   public static void main(String [] args) 
   {
      OrdersScreen test = new OrdersScreen();
   }
}