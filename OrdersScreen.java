import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrdersScreen extends JFrame implements ActionListener
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
   private JLabel optionOneLabel;
   private JComboBox optionOneComboBox;
   private JLabel optionTwoLabel;
   private JComboBox optionTwoComboBox;
   private JPanel typeComboContainer = new JPanel();
   private JPanel modelComboContainer = new JPanel();
   private JPanel colorComboContainer = new JPanel();
   private JPanel costComboContainer = new JPanel();
   private JPanel comboContainer = new JPanel();
   private JPanel bottomButtons = new JPanel();
   private JPanel optionOneComboContainer = new JPanel();
   private JPanel optionTwoComboContainer = new JPanel();
   private JButton saveButton;
   private JButton firstButton;
   private JButton prevButton;
   private JButton nextButton;
   private JButton lastButton;
   private JButton exitButton;
   private JMenuBar menuBar = new JMenuBar();
   private JMenu fileMenu = new JMenu("File");
   private JMenu helpMenu = new JMenu("Help");
   private JMenuItem loadMenuItem = new JMenuItem("Load");
   private JMenuItem exitMenuItem = new JMenuItem("Exit");
   private JMenuItem aboutMenuItem = new JMenuItem("About");
   
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
      vehicleTypeComboBox.addActionListener(this);
      
      modelLabel = new JLabel("Model", SwingConstants.RIGHT);
      modelComboBox = new JComboBox();
      modelLabel.setLabelFor(modelComboBox);
      
      colorLabel = new JLabel("Color", SwingConstants.RIGHT);
      colorComboBox = new JComboBox();
      colorLabel.setLabelFor(colorComboBox);
      
      costLabel = new JLabel("Cost", SwingConstants.RIGHT);
      costComboBox = new JComboBox();
      costLabel.setLabelFor(costComboBox);
      
      optionOneLabel = new JLabel("", SwingConstants.RIGHT);
      optionOneComboBox = new JComboBox();
      optionOneLabel.setLabelFor(optionOneComboBox);
      
      optionTwoLabel = new JLabel("", SwingConstants.RIGHT);
      optionTwoComboBox = new JComboBox();
      optionTwoLabel.setLabelFor(optionTwoComboBox);
 
      saveButton = new JButton("SAVE");
      firstButton = new JButton("FIRST");
      prevButton = new JButton("PREV");
      nextButton = new JButton("NEXT");
      lastButton = new JButton("LAST");
      exitButton = new JButton("Exit");
      
      //menu
      this.setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      fileMenu.add(loadMenuItem);
      fileMenu.add(exitMenuItem);
      helpMenu.add(aboutMenuItem);
      
      //middle menus
      typeComboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      typeComboContainer.add(vehicleTypeLabel);
      typeComboContainer.add(vehicleTypeComboBox);
      
      modelComboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      modelComboContainer.add(modelLabel);
      modelComboContainer.add(modelComboBox);
      
      colorComboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      colorComboContainer.add(colorLabel);
      colorComboContainer.add(colorComboBox);
      
      costComboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      costComboContainer.add(costLabel);
      costComboContainer.add(costComboBox);
      
      optionOneComboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      optionOneComboContainer.add(optionOneLabel);
      optionOneComboContainer.add(optionOneComboBox);
      
      optionTwoComboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      optionTwoComboContainer.add(optionTwoLabel);
      optionTwoComboContainer.add(optionTwoComboBox);
      
      comboContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
      comboContainer.add(typeComboContainer);
      comboContainer.add(modelComboContainer);
      comboContainer.add(colorComboContainer);
      comboContainer.add(costComboContainer);
      comboContainer.add(optionOneComboContainer);
      comboContainer.add(optionTwoComboContainer);
      comboContainer.setPreferredSize(new Dimension(350,400));
      this.add(comboContainer, BorderLayout.CENTER);
      
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
   
   public void actionPerformed(ActionEvent ae) 
   {
      if (ae.getSource() == vehicleTypeComboBox)
      {
         String vehicleTypeSelection  = vehicleTypeComboBox.getSelectedItem().toString();
         switch(vehicleTypeSelection) 
         {
            case "Truck":
               optionOneLabel.setText("Truck size");
               optionOneComboBox.removeAllItems();
               optionOneComboBox.addItem("Half Ton");
               optionOneComboBox.addItem("Full Ton");
               optionTwoLabel.setText("Engine size");
               optionTwoComboBox.removeAllItems();
               optionTwoComboBox.addItem("1000cc");
               optionTwoComboBox.addItem("2000cc");
               break;
            case "Car":
               optionOneLabel.setText("Car type");
               optionOneComboBox.removeAllItems();
               optionOneComboBox.addItem("Sedan");
               optionOneComboBox.addItem("Coupe");
               optionOneComboBox.addItem("Wagon");
               optionTwoLabel.setText("Towing");
               optionTwoComboBox.removeAllItems();
               optionTwoComboBox.addItem("Towing package");
               optionTwoComboBox.addItem("No towing package");
               break;
            case "Sled":
               optionOneLabel.setText("Sled purpose");
               optionOneComboBox.removeAllItems();
               optionOneComboBox.addItem("Recreational Sledding");
               optionOneComboBox.addItem("Competitive Sledding");
               optionTwoLabel.setText("Sled type");
               optionTwoComboBox.removeAllItems();
               optionTwoComboBox.addItem("Inflatable Sled");
               optionTwoComboBox.addItem("Toboggan");
               optionTwoComboBox.addItem("Bob Sled");
               break;
            case "Boat":
               optionOneLabel.setText("Type of boat");
               optionOneComboBox.removeAllItems();
               optionOneComboBox.addItem("Pontoon");
               optionOneComboBox.addItem("PWC");
               optionOneComboBox.addItem("Sailboat");
               optionTwoLabel.setText("Construction type");
               optionTwoComboBox.removeAllItems();
               optionTwoComboBox.addItem("Wood");
               optionTwoComboBox.addItem("Fiberglass");
               optionTwoComboBox.addItem("Steel");
               break;
            case "Mercedes Benz":
               optionOneLabel.setText("Fuel type");
               optionOneComboBox.removeAllItems();
               optionOneComboBox.addItem("Unleaded Petrol");
               optionOneComboBox.addItem("Diesel");
               optionTwoLabel.setText("Type of Drive");
               optionTwoComboBox.removeAllItems();
               optionTwoComboBox.addItem("FWD");
               optionTwoComboBox.addItem("4Matic");
               break;
            default:
         }
      }
   }
   public static void main(String [] args) 
   {
      OrdersScreen test = new OrdersScreen();
   }
}