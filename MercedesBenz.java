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
   }
   
   public void setTypeOfDrive(int _typeOfDrive)
   {
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
   
   public String toString()
   {
      return "";
   }
}