public interface Vinfo {
   /** Mileage of a Sedan car */
   final static double SEDAN_MPG = 23.7;
   /** Mileage of a Coupe car*/
   final static double COUPE_MPG = 28.2;
   /** Mileage of a Wagon car*/
   final static double WAGON_MPG = 19.5;
   /** Mileage that is to be deducted if the car has towing capability */
   final static double TOWING_MPG_REDUCTION = 3;
      
   /** Mileage of a Pontoon boat */
   final static double PONTOON_MPG = 3.5;
   /** Mileage of a PWC boat*/
   final static double PWC_MPG = 2.2;
   /** Mileage of a SailBoat */
   final static double SAIL_BOAT_MPG = 0;
   
   
   
   /** Mileage of a benz Coupe */
   final static double BENZ_PETROL_MPG = 20.8;
   /** Mileage of a benz Sedan */
   final static double BENZ_DIESEL_MPG = 22.0;
   /** Mileage reduction for benz 4matic All Wheel Drive */
   final static double BENZ_AWD_MILEAGE_REDUCTION = 2.0;
   /** Calculates and returns the Mileage of a vehicle 
   *@return Mileage of the vehicle
   */
	public abstract double gasMileage();
   
   
   
}
