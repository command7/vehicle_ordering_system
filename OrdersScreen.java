import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrdersScreen extends JFrame
{
   private String [] vehicleTypes = {"Car", "Boat", "Truck", "Sled", "Mercedes Benz"};
   
   private JLabel vehicleTypeLabel;
   private JLabel windowHeader;
   private JComboBox vehicleTypeComboBox;
   private JLabel modelLabel;
   private JComboBox modelComboBox;
   private JPanel comboBoxes = new JPanel();
   public OrdersScreen()
   {
      createFrame();
   }
   
   public void createFrame()
   {
      this.setLayout(new BorderLayout());
            
      String headerText = "<html><b><font color='red' size=5>Student Management System</font><b></html>";
  		windowHeader = new JLabel(headerText, SwingConstants.CENTER);
      this.add(windowHeader, BorderLayout.NORTH);

      vehicleTypeLabel = new JLabel("Vehicle Type", SwingConstants.RIGHT);
      vehicleTypeComboBox = new JComboBox(vehicleTypes);
      this.add(vehicleTypeLabel);
      this.add(vehicleTypeComboBox);
      
      modelLabel = new JLabel("Vehicle Type", SwingConstants.RIGHT);
      modelComboBox = new JComboBox(vehicleTypes);
      this.add(modelLabel);
      this.add(modelComboBox);
      
      comboBoxes.setLayout(new FlowLayout(FlowLayout.CENTER));
      comboBoxes.add(vehicleTypeComboBox);
      comboBoxes.add(modelComboBox);
      this.add(comboBoxes,BorderLayout.EAST);
      
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