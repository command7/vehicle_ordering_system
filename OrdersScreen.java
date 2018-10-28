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
   private JTextField modelTextField;
   private JPanel modelPanel;
   private JLabel colorLabel;
   private JTextField colorTextField;
   private JLabel costLabel;
   private JTextField costTextField;
   private JLabel optionOneLabel;
   private JComboBox optionOneComboBox;
   private JLabel optionTwoLabel;
   private JComboBox optionTwoComboBox;
   private JPanel comboContainer = new JPanel();
   private JPanel bottomButtons = new JPanel();
   private JButton saveButton;
   private JButton firstButton;
   private JButton prevButton;
   private JButton nextButton;
   private JButton lastButton;
   private JButton exitButton;
   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenu helpMenu;
   private JMenuItem loadMenuItem;
   private JMenuItem exitMenuItem;
   private JMenuItem aboutMenuItem;
   
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
      vehicleTypeComboBox.insertItemAt("", 0);
      vehicleTypeComboBox.setSelectedIndex(0);
      vehicleTypeComboBox.setPreferredSize(new Dimension(250,20));
      
      modelLabel = new JLabel("Model", SwingConstants.RIGHT);
      modelTextField = new JTextField();
      modelLabel.setLabelFor(modelTextField);
      //modelTextField.setMaximumSize(new Dimension(250,10));
      
      colorLabel = new JLabel("Color", SwingConstants.RIGHT);
      colorTextField = new JTextField();
      colorLabel.setLabelFor(colorTextField);
     // colorTextField.setPreferredSize(new Dimension(250,20));
      
      costLabel = new JLabel("Cost", SwingConstants.RIGHT);
      costTextField = new JTextField();
      costLabel.setLabelFor(costTextField);
      //costTextField.setPreferredSize(new Dimension(250,20));
      
      optionOneLabel = new JLabel("", SwingConstants.RIGHT);
      optionOneComboBox = new JComboBox();
      optionOneLabel.setLabelFor(optionOneComboBox);
      optionOneComboBox.setPreferredSize(new Dimension(250,20));
      
      optionTwoLabel = new JLabel("", SwingConstants.RIGHT);
      optionTwoComboBox = new JComboBox();
      optionTwoLabel.setLabelFor(optionTwoComboBox);
      optionTwoComboBox.setPreferredSize(new Dimension(250,20));
 
      saveButton = new JButton("SAVE");
      firstButton = new JButton("FIRST");
      prevButton = new JButton("PREV");
      nextButton = new JButton("NEXT");
      lastButton = new JButton("LAST");
      exitButton = new JButton("Exit");
      exitButton.addActionListener(this);
      
      menuBar = new JMenuBar();
      fileMenu = new JMenu("File");
      helpMenu = new JMenu("Help");
      loadMenuItem = new JMenuItem("Load");
      exitMenuItem = new JMenuItem("Exit");
      aboutMenuItem = new JMenuItem("About");
      exitMenuItem.addActionListener(this);
      
      //menu
      this.setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      fileMenu.add(loadMenuItem);
      fileMenu.add(exitMenuItem);
      helpMenu.add(aboutMenuItem);
      
      //middle menus
      comboContainer.setLayout(new GridLayout(0,2));
      comboContainer.add(vehicleTypeLabel);
      comboContainer.add(vehicleTypeComboBox);
      comboContainer.add(modelLabel);
      comboContainer.add(modelTextField);
      comboContainer.add(colorLabel);
      comboContainer.add(colorTextField);
      comboContainer.add(costLabel);
      comboContainer.add(costTextField);
      comboContainer.add(optionOneLabel);
      comboContainer.add(optionOneComboBox);
      comboContainer.add(optionTwoLabel);
      comboContainer.add(optionTwoComboBox);
      //comboContainer.setPreferredSize(new Dimension(350,400));
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
      this.setSize(500,400);
      this.setVisible(true);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
   }
   
   public void actionPerformed(ActionEvent ae) 
   {
      String [] optionOneOptions;
      String [] optionTwoOptions;
      String [] attributeLabels;
      if (ae.getSource() == vehicleTypeComboBox)
      {
         String vehicleTypeSelection  = vehicleTypeComboBox.getSelectedItem().toString();
         switch(vehicleTypeSelection) 
         {
            case "Truck":
               optionOneOptions = Truck.getTruckSizeOptions();
               optionTwoOptions = Truck.getEngineSizeOptions();
               attributeLabels = Truck.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String truckSize : optionOneOptions) 
               {
                  optionOneComboBox.addItem(truckSize);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String engineSize : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(engineSize);
               }
               break;
            case "Car":
               optionOneOptions = Car.getCarTypeOptions();
               optionTwoOptions = Car.getTowingOptions();
               attributeLabels = Car.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String carType : optionOneOptions) 
               {
                  optionOneComboBox.addItem(carType);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String towing : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(towing);
               }
               break;
            case "Sled":
               optionOneOptions = Sled.getSledUseOptions();
               optionTwoOptions = Sled.getSledCategoryOptions();
               attributeLabels = Sled.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String sledUse : optionOneOptions) 
               {
                  optionOneComboBox.addItem(sledUse);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String sledCategory : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(sledCategory);
               }
               break;
            case "Boat":
               optionOneOptions = Boat.getBoatTypeOptions();
               optionTwoOptions = Boat.getBoatConstructionOptions();
               attributeLabels = Boat.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String boatType : optionOneOptions) 
               {
                  optionOneComboBox.addItem(boatType);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String boatConstruction : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(boatConstruction);
               }
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
               break;
         }
      }
      if (ae.getSource() == exitButton)
      {
         System.exit(0);
      }
      if (ae.getSource() == exitMenuItem)
      {
         System.exit(1);
      }
   }
   public static void main(String [] args) 
   {
      OrdersScreen test = new OrdersScreen();
      String a = Boat.TYPES_OF_BOATS[0];
      System.out.println(a);
   }
}