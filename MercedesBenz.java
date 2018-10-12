public class MercedesBenz extends Vehicle
{
   private int typeOfMake = -1;
   private int typeOfDrive = -1;
   private static final String [] allMakes = {"Coupe", "Sedan", "SUV", "Cabriolet"};
   private static final String [] allDrives = {"FWD", "4Matic"};
   
   public MercedesBenz ()
   {
      super();
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
         mileage = benzCoupeMpg;
      }
      else if (this.getTypeOfMake().equals("Sedan"))
      {
         mileage = benzSedanMpg;
      }
      else if (this.getTypeOfMake().equals("SUV"))
      {
         mileage = benzSuvMpg;
      }
      else
      {
         mileage = benzCabrioletMpg;
      }
      if (this.getTypeOfDrive().equals("4Matic"))
      {
         mileage -= benzAwdMileageReduction;
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
      return "Mercedes Benz:\n" + super.toString() + String.format("%n%5s%-10s %s%n%5s%-10s %s%n",
      "", "Car Type:", this.getTypeOfMake(),"", "Drive Type:", this.getTypeOfDrive());
   }
}