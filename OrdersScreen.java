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
   private JLabel colorLabel;
   private JComboBox colorComboBox;
   private JLabel costLabel;
   private JComboBox costComboBox;
   private JPanel comboBoxOne = new JPanel();
   private JPanel comboBoxTwo = new JPanel();
   private JPanel comboContainer = new JPanel();
   private JPanel bottomButtons = new JPanel();
   private JButton saveButton;
   private JButton firstButton;
   private JButton prevButton;
   private JButton nextButton;
   private JButton lastButton;
   private JButton exitButton;
   
   public OrdersScreen()
   {
      createFrame();
   }
   
   public void createFrame()
   {
      this.setLayout(new BorderLayout());
            
      String headerText = "<html><b><font color='red' size=5>Vijay Raj Saravanan's Ordering System</font><b></html>";
  		windowHeader = new JLabel(headerText, SwingConstants.CENTER);
      this.add(windowHeader, BorderLayout.NORTH);

      vehicleTypeLabel = new JLabel("Vehicle Type", SwingConstants.RIGHT);
      vehicleTypeComboBox = new JComboBox(vehicleTypes);

      
      modelLabel = new JLabel("Model", SwingConstants.RIGHT);
      modelComboBox = new JComboBox(vehicleTypes);
      modelLabel.setLabelFor(modelComboBox);

      
      colorLabel = new JLabel("Color", SwingConstants.RIGHT);
      colorComboBox = new JComboBox(vehicleTypes);
      colorLabel.setLabelFor(colorComboBox);
      
      costLabel = new JLabel("Cost", SwingConstants.RIGHT);
      costComboBox = new JComboBox(vehicleTypes);
      costLabel.setLabelFor(costComboBox);
 
      saveButton = new JButton("SAVE");
      firstButton = new JButton("FIRST");
      prevButton = new JButton("PREV");
      nextButton = new JButton("NEXT");
      lastButton = new JButton("LAST");
      exitButton = new JButton("Exit");
      
      //middle menus
      comboBoxOne.setLayout(new FlowLayout(FlowLayout.LEFT));
      comboBoxOne.add(vehicleTypeLabel);
      comboBoxOne.add(vehicleTypeComboBox);
      
      comboBoxTwo.setLayout(new FlowLayout(FlowLayout.LEFT));
      comboBoxTwo.add(modelLabel);
      comboBoxTwo.add(modelComboBox);
      // comboBoxes.add(colorLabel);
//       comboBoxes.add(colorComboBox);
//       comboBoxes.add(costLabel);
//       comboBoxes.add(costComboBox);
      
      comboContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
      comboContainer.add(comboBoxOne);
      comboContainer.add(comboBoxTwo);
      comboContainer.setPreferredSize(new Dimension(280,400));
      this.add(comboContainer, BorderLayout.EAST);
      
      //bottom Jpanel
      bottomButtons.setLayout(new FlowLayout());
      bottomButtons.add(saveButton);
      bottomButtons.add(firstButton);
      bottomButtons.add(prevButton);
      bottomButtons.add(nextButton);
      bottomButtons.add(lastButton);
      bottomButtons.add(exitButton);
      this.add(bottomButtons, BorderLayout.SOUTH);
      
      
      
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