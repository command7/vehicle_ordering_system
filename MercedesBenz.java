public class MercedesBenz extends Vehicle
{
   private int typeOfMake = -1;
   private int typeOfDrive = -1;
   private final String [] allMakes = {"Coupe", "Sedan", "SUV", "Cabriolet"};
   private final String [] allDrives = {"FWD", "4Matic"};
   final double coupeMpg = 20.8;
   final double sedanMpg = 19.0;
   final double suvMpg = 18.0;
   final double cabrioletMpg = 20.0;
   final double awdMileageReduction = 2.0;
   
   public MercedesBenz ()
   {
      super.generalDetailsMenu();
      typeOfMakeMenu();
      typeOfDriveMenu();
      
   }
   
   public String getTypeOfMake()
   {
      if (this.typeOfMake == -1)
      {
         return "";
      }
      else
      {
         return allMakes[this.typeOfMake];
      }
   }
   
   public String getTypeOfDrive()
   {
      if (this. typeOfDrive == -1)
      {
         return "";
      }
      else
      {
         return allDrives[this.typeOfDrive];
      }
   }
   
   public void setTypeOfMake(int _typeOfMake)
   {
      if (_typeOfMake >= 0 && _typeOfMake < allMakes.length)
      {
         this.typeOfMake = _typeOfMake;
      }
   }
   
   public void setTypeOfDrive(int _typeOfDrive)
   {
      if (_typeOfDrive >= 0 && _typeOfDrive < allDrives.length)
      {
         this.typeOfDrive = _typeOfDrive;
      }
   }
   
   public double gasMileage()
   {
      double mileage = 0;
      if (this.getTypeOfMake().equals("Coupe"))
      {
         mileage = coupeMpg;
      }
      else if (this.getTypeOfMake().equals("Sedan"))
      {
         mileage = sedanMpg;
      }
      else if (this.getTypeOfMake().equals("SUV"))
      {
         mileage = suvMpg;
      }
      else
      {
         mileage = cabrioletMpg;
      }
      if (this.getTypeOfDrive().equals("4Matic"))
      {
         mileage -= awdMileageReduction;
      }
      return mileage;
   }
   
   public void typeOfMakeMenu()
   {
      int typeOfMakeIndex = super.showMenu("What type of Car is this?", allMakes);
      setTypeOfMake(typeOfMakeIndex);
   }
   
   public void typeOfDriveMenu()
   {
      int typeOfDriveIndex = super.showMenu("What type of Drive is this?", allDrives);
      setTypeOfDrive(typeOfDriveIndex);
   }
   
   public String toString()
   {
      return "Mercedes Benz\n" + super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", " Car Type:", this.getTypeOfMake(),"", "Drive Type:", this.getTypeOfDrive());
   }
}