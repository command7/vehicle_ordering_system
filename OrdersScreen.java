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
      modelComboBox = new JComboBox();
      modelLabel.setLabelFor(modelComboBox);
      modelComboBox.setPreferredSize(new Dimension(250,20));
      
      colorLabel = new JLabel("Color", SwingConstants.RIGHT);
      colorComboBox = new JComboBox();
      colorLabel.setLabelFor(colorComboBox);
      colorComboBox.setPreferredSize(new Dimension(250,20));
      
      costLabel = new JLabel("Cost", SwingConstants.RIGHT);
      costComboBox = new JComboBox();
      costLabel.setLabelFor(costComboBox);
      costComboBox.setPreferredSize(new Dimension(250,20));
      
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
      
      comboContainer.setLayout(new GridLayout(0,2));
      comboContainer.add(vehicleTypeLabel);
      comboContainer.add(vehicleTypeComboBox);
      comboContainer.add(modelLabel);
      comboContainer.add(modelComboBox);
      comboContainer.add(colorLabel);
      comboContainer.add(colorComboBox);
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
      this.setSize(600,400);
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
   }
}