/**
*Purpose:   This program creates a Graphical User Interface for vehicle ordering
*           system. <br/>
*                   <br/>
*Caveats:   It needs the attribute labels and menu options of others classes
*           in order to display them in combo boxes and labels.
*           Only menu options, exit button and file->exit menu implemented.
*                   <br/>
*Date:      October 29, 2018
*@author    Vijay Raj Saravanan Radhakrishnan
*@version   1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class OrdersScreen extends JFrame implements ActionListener
{
   /** An array storing options of vehicles to display in vehicle type combo box */
   private String [] vehicleTypes = {"Car", "Boat", "Truck", "Sled", "Mercedes Benz"};
   /** Contains the vehicle type label*/
   private JLabel vehicleTypeLabel;
   /** Contains the heading of the window to be displayed */
   private JLabel windowHeader;
   /** Combo box that displays different vehicle options to be ordered */
   private JComboBox vehicleTypeComboBox;
   /** Contains text to be displayed aside model text field */
   private JLabel modelLabel;
   /** Text field that allows users to enter the model of the vehicle */
   private JTextField modelTextField;
   /** Label to be displayed aside color text field */
   private JLabel colorLabel;
   /** Text field for the user to enter the color of the vehicle.*/
   private JTextField colorTextField;
   /** Label to be displayed aside cost text field */
   private JLabel costLabel;
   /** Text field that allows users to enter the cost of the vehicle*/
   private JTextField costTextField;
   /** Displays label of an additional menu based on the type of vehicle */
   private JLabel optionOneLabel;
   /** Combo box containing options of the additional menu based on the type of vehicle */
   private JComboBox optionOneComboBox;
   /** Displays label of an additional menu based on the type of vehicle */
   private JLabel optionTwoLabel;
   /** Combo box containing options of the additional menu based on the type of vehicle */
   private JComboBox optionTwoComboBox;
   /** JPanel containing all menu labels, text fields and combo boxes */
   private JPanel comboContainer = new JPanel();
   /** JPanel containing all buttons of the GUI */
   private JPanel bottomButtons = new JPanel();
   /** Button that allows the user to save order*/
   private JButton saveButton;
   /** First Button */
   private JButton firstButton;
   /** Previous Button*/
   private JButton prevButton;
   /** Next Button */
   private JButton nextButton;
   /** Last Button */
   private JButton lastButton;
   /** Exit Button */
   private JButton exitButton;
   /** Contains the entire Menu bar */
   private JMenuBar menuBar;
   /** File Menu present in the Menu bar */
   private JMenu fileMenu;
   /** Help Menu present in the Menu bar */
   private JMenu helpMenu;
   /** Menu item present under file menu */
   private JMenuItem loadMenuItem;
   /** Menu item present under file menu */
   private JMenuItem exitMenuItem;
   /** About Menu present in the Menu bar */
   private JMenuItem aboutMenuItem;
   ArrayList ordersMade = new ArrayList();
   int currentOrder = 0;
   
 /**
 * Constructor creates the Graphical User Interface and implements action events for menu options and exit button
 */
   public OrdersScreen()
   {
      createFrame();
   }
   
   public void loadOrders() 
   {
      try
      {
         File file = new File("VehicleOrders.dat");
         if (file.exists())
         {
            ObjectInputStream objReader = new ObjectInputStream(new BufferedInputStream(new FileInputStream("VehicleOrders.dat")));
            ordersMade = (ArrayList)objReader.readObject();
            objReader.close();
         }
         else
         {
            System.out.println("File not found");
         }
      }
      catch (IOException ioe) 
      {
         ioe.printStackTrace();
      }
      catch (Exception e)
      {
         System.out.println("UKNOWN");
      }   
   }
   
   public void saveOrders()
   {
      try
      {
         ObjectOutputStream objWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("VehicleOrders.dat")));
         objWriter.writeObject(ordersMade);
         objWriter.flush();
         objWriter.close();
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
      catch (Exception e)
      {
         System.out.print("Unknown Error");
      }
   }
   
   public void registerOrder()
   {
      String vehicleTypeSelection  = vehicleTypeComboBox.getSelectedItem().toString();
      String model = modelTextField.getText();
      String color = colorTextField.getText();
      double cost = Double.parseDouble(costTextField.getText());
      int optionOneIndex = optionOneComboBox.getSelectedIndex();
      int optionTwoIndex = optionTwoComboBox.getSelectedIndex();
      switch (vehicleTypeSelection)
      {
         case "Truck":
            Truck newTruck = new Truck(model, color, cost, optionOneIndex, optionTwoIndex);
            ordersMade.add(newTruck);
            break;
         case "Car":
            Car newCar = new Car(model, color, cost, optionOneIndex, optionTwoIndex);
            ordersMade.add(newCar);
            break;
         case "Boat":
            Boat newBoat = new Boat(model, color, cost, optionOneIndex, optionTwoIndex);
            ordersMade.add(newBoat);
            break;
         case "Mercedes Benz":
            MercedesBenz newMBenz = new MercedesBenz(model, color, cost, optionOneIndex, optionTwoIndex);
            ordersMade.add(newMBenz);
            break;
         case "Sled":
            Sled newSled = new Sled(model, color, cost, optionOneIndex, optionTwoIndex);
            ordersMade.add(newSled);
            break;
         default:
      }
   } 
   
   public void displayOrder(int orderIndex)
   {
      Object vehicle = ordersMade.get(orderIndex);
      if (vehicle instanceof Car)
      {
         Car orderedCar = (Car)vehicle;
         vehicleTypeComboBox.setSelectedItem("Car");
         modelTextField.setText(orderedCar.getVehicleModel());
         colorTextField.setText(orderedCar.getVehicleColor());
         costTextField.setText(Double.toString(orderedCar.getVehicleCost()));
         optionOneComboBox.setSelectedItem(orderedCar.getCarType());
         optionTwoComboBox.setSelectedItem(orderedCar.getTowingPackage());
      }
      else if (vehicle instanceof Truck)
      {
         Truck orderedTruck = (Truck)vehicle;
         vehicleTypeComboBox.setSelectedItem("Truck");
         loadAttributes();
         modelTextField.setText(orderedTruck.getVehicleModel());
         colorTextField.setText(orderedTruck.getVehicleColor());
         costTextField.setText(Double.toString(orderedTruck.getVehicleCost()));
         optionOneComboBox.setSelectedItem(orderedTruck.getTruckSize());
         optionTwoComboBox.setSelectedItem(orderedTruck.getEngineSize());
      }
      else if (vehicle instanceof Boat)
      {
         Boat orderedBoat = (Boat)vehicle;
         vehicleTypeComboBox.setSelectedItem("Boat");
         loadAttributes();
         modelTextField.setText(orderedBoat.getVehicleModel());
         colorTextField.setText(orderedBoat.getVehicleColor());
         costTextField.setText(Double.toString(orderedBoat.getVehicleCost()));
         optionOneComboBox.setSelectedItem(orderedBoat.getBoatType());
         optionTwoComboBox.setSelectedItem(orderedBoat.getBoatConstruction());
      }
      else if (vehicle instanceof MercedesBenz)
      {
         MercedesBenz orderedMbenz = (MercedesBenz)vehicle;
         vehicleTypeComboBox.setSelectedItem("Mercedes Benz");
         loadAttributes();
         modelTextField.setText(orderedMbenz.getVehicleModel());
         colorTextField.setText(orderedMbenz.getVehicleColor());
         costTextField.setText(Double.toString(orderedMbenz.getVehicleCost()));
         optionOneComboBox.setSelectedItem(orderedMbenz.getTypeOfFuel());
         optionTwoComboBox.setSelectedItem(orderedMbenz.getTypeOfDrive());
      }
      else if (vehicle instanceof Sled)
      {
         Sled orderedSled = (Sled)vehicle;
         vehicleTypeComboBox.setSelectedItem("Sled");
         loadAttributes();
         modelTextField.setText(orderedSled.getVehicleModel());
         colorTextField.setText(orderedSled.getVehicleColor());
         costTextField.setText(Double.toString(orderedSled.getVehicleCost()));
         optionOneComboBox.setSelectedItem(orderedSled.getUse());
         optionTwoComboBox.setSelectedItem(orderedSled.getCategory());
      }
      else
      {
         System.out.println("Invalid object type");
      }
   }


 /**
 * Method that creates menus, text fields, combo boxes, buttons and adds them to the layout appropriately
 */
   public void createFrame()
   {  
      //Setting Border Layout for the frame
      this.setLayout(new BorderLayout());
            
      String headerText = "<html><b><font color='blue' size=6>Vijay Raj Saravanan's Ordering System</font><b></html>";
  		windowHeader = new JLabel(headerText, SwingConstants.CENTER);
      this.add(windowHeader, BorderLayout.NORTH);
      
      //Creating label and combo box to display vehicle options.
      vehicleTypeLabel = new JLabel("Vehicle Type", SwingConstants.RIGHT);
      vehicleTypeComboBox = new JComboBox(vehicleTypes);
      vehicleTypeComboBox.insertItemAt("", 0);
      vehicleTypeComboBox.setSelectedIndex(0);
      vehicleTypeComboBox.setPreferredSize(new Dimension(250,20));
      
      //Creating text fields and labels for model, color and cost
      modelLabel = new JLabel("Model", SwingConstants.RIGHT);
      modelTextField = new JTextField();
      modelLabel.setLabelFor(modelTextField);
      
      colorLabel = new JLabel("Color", SwingConstants.RIGHT);
      colorTextField = new JTextField();
      colorLabel.setLabelFor(colorTextField);
      
      costLabel = new JLabel("Cost", SwingConstants.RIGHT);
      costTextField = new JTextField();
      costLabel.setLabelFor(costTextField);
      
      optionOneLabel = new JLabel("", SwingConstants.RIGHT);
      optionOneComboBox = new JComboBox();
      optionOneLabel.setLabelFor(optionOneComboBox);
      optionOneComboBox.setPreferredSize(new Dimension(250,20));
      
      optionTwoLabel = new JLabel("", SwingConstants.RIGHT);
      optionTwoComboBox = new JComboBox();
      optionTwoLabel.setLabelFor(optionTwoComboBox);
      optionTwoComboBox.setPreferredSize(new Dimension(250,20));
      
      //Creating buttons
      saveButton = new JButton("SAVE");
      firstButton = new JButton("FIRST");
      prevButton = new JButton("PREV");
      nextButton = new JButton("NEXT");
      lastButton = new JButton("LAST");
      exitButton = new JButton("Exit");
      
      //Creating menu bar items
      menuBar = new JMenuBar();
      fileMenu = new JMenu("File");
      helpMenu = new JMenu("Help");
      loadMenuItem = new JMenuItem("Load");
      exitMenuItem = new JMenuItem("Exit");
      aboutMenuItem = new JMenuItem("About");    
      
      //Adding menu bar to layout
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
      
      //Adding action listeners
      vehicleTypeComboBox.addActionListener(this);
      exitMenuItem.addActionListener(this); 
      exitButton.addActionListener(this);
      loadMenuItem.addActionListener(this);
      firstButton.addActionListener(this);
      saveButton.addActionListener(this);
         
      this.setTitle("Orders Screen");
      this.setSize(500,300);
      this.setVisible(true);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
   }
   
   public void loadAttributes()
   {
         String [] optionOneOptions;
         String [] optionTwoOptions;
         String [] attributeLabels;
         String vehicleTypeSelection  = vehicleTypeComboBox.getSelectedItem().toString();
         switch(vehicleTypeSelection) 
         {
            case "Truck":
               optionOneOptions = Truck.getTruckSizeOptions();
               optionTwoOptions = Truck.getEngineSizeOptions();
               attributeLabels = Truck.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String option : optionOneOptions) 
               {
                  optionOneComboBox.addItem(option);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String option : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(option);
               }
               break;
            case "Car":
               optionOneOptions = Car.getCarTypeOptions();
               optionTwoOptions = Car.getTowingOptions();
               attributeLabels = Car.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String option : optionOneOptions) 
               {
                  optionOneComboBox.addItem(option);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String option : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(option);
               }

               break;
            case "Sled":
               optionOneOptions = Sled.getSledUseOptions();
               optionTwoOptions = Sled.getSledCategoryOptions();
               attributeLabels = Sled.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String option : optionOneOptions) 
               {
                  optionOneComboBox.addItem(option);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String option : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(option);
               }
               break;
            case "Boat":
               optionOneOptions = Boat.getBoatTypeOptions();
               optionTwoOptions = Boat.getBoatConstructionOptions();
               attributeLabels = Boat.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String option : optionOneOptions) 
               {
                  optionOneComboBox.addItem(option);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String option : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(option);
               }
               break;
            case "Mercedes Benz":
               optionOneOptions = MercedesBenz.getFuelTypeOptions();
               optionTwoOptions = MercedesBenz.getDriveTypeOptions();
               attributeLabels = MercedesBenz.getAttributeLabels();
               optionOneLabel.setText(attributeLabels[0]);
               optionOneComboBox.removeAllItems();
               for (String option : optionOneOptions) 
               {
                  optionOneComboBox.addItem(option);
               }
               optionTwoLabel.setText(attributeLabels[1]);
               optionTwoComboBox.removeAllItems();
               for (String option : optionTwoOptions)
               {
                  optionTwoComboBox.addItem(option);
               }

               break;
            default:
               break;
         }
      }


   
/**
*  Method that handles events such as setting additional menu options based on the 
*  type of component that causes it.
*  @param ae ActionEvent the triggers the event
*/
   public void actionPerformed(ActionEvent ae) 
   {
      if (ae.getSource() == vehicleTypeComboBox)
      {
         loadAttributes();
      }
      if (ae.getSource() == exitButton)
      {
         saveOrders();
         System.exit(0);
      }
      if (ae.getSource() == exitMenuItem)
      {
         saveOrders();
         System.exit(1);
      }
      if (ae.getSource() == loadMenuItem)
      {
         loadOrders();
      }
      if (ae.getSource() == saveButton)
      {
         registerOrder();
      }
      if (ae.getSource() == firstButton)
      {
         displayOrder(0);
      }
      if (ae.getSource() == prevButton)
      {
         saveOrders();
      }
      if (ae.getSource() == nextButton)
      {
         saveOrders();
      }
      if (ae.getSource() == lastButton)
      {
         saveOrders();
      }
   }
   
 /**
 * Main block instantiating OrdersScreen class
 */
   public static void main(String [] args) 
   {
      OrdersScreen test = new OrdersScreen();
      System.out.println(test.ordersMade);
   }
}