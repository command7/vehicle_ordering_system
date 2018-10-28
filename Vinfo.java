public interface Vinfo {
   /** An array containing types of cars for the user to select one*/
   static final String [] TYPES_OF_CARS = {"Sedan", "Coupe", "Wagon"};
   /** An array containing possible towing capabilities for car */
   static final String [] TOWING_CAPABILITY = {"Towing Package", "No towing package"};
   /** Mileage of a Sedan car */
   final static double SEDAN_MPG = 23.7;
   /** Mileage of a Coupe car*/
   final static double COUPE_MPG = 28.2;
   /** Mileage of a Wagon car*/
   final static double WAGON_MPG = 19.5;
   /** Mileage that is to be deducted if the car has towing capability */
   final static double TOWING_MPG_REDUCTION = 3;
   static final String [] CAR_ATTRIBUTE_LABELS = {"Type of car", "Towing package"};
   
   /** Stores various sizes of truck as menu options for the user to select from */ 
   static final String [] ALL_TRUCK_SIZES = {"Half-ton", "Full ton"};
   /** Stores various engine sizes as menu options for the user to select from  */
   static final String [] ALL_ENGINE_SIZES = {"1000cc", "2000cc"};
   static final String [] TRUCK_ATTRIBUTE_LABELS = {"Truck size", "Engine size"};
   
   /** A String array containing options for types of boat menu*/
   static final String [] TYPES_OF_BOATS = {"Pontoon", "PWC", "Sailboat"};
   /** A String array containing options for construction types of boat menu */
   static final String [] TYPES_OF_BOAT_CONSTRUCTION = {"Wood", "Fiberglass", "Steel"};
   /** Mileage of a Pontoon boat */
   final static double PONTOON_MPG = 3.5;
   /** Mileage of a PWC boat*/
   final static double PWC_MPG = 2.2;
   /** Mileage of a SailBoat */
   final static double SAIL_BOAT_MPG = 0;
   static final String [] BOAT_ATTRIBUTE_LABELS = {"Type of boat", "Construction"};
   
   /** Contains all options of makes for Mercedes Benz */
   final static String [] FUEL_TYPES = {"Unleaded Petrol", "Diesel"};
   /** Contains all driving types available for Mercedes Benz */
   final static String [] ALL_DRIVES = {"FWD", "4Matic"};
   /** Mileage of a benz Coupe */
   final static double BENZ_PETROL_MPG = 20.8;
   /** Mileage of a benz Sedan */
   final static double BENZ_DIESEL_MPG = 22.0;
   /** Mileage reduction for benz 4matic All Wheel Drive */
   final static double BENZ_AWD_MILEAGE_REDUCTION = 2.0;
   /** Calculates and returns the Mileage of a vehicle */
	public abstract double gasMileage();
   
   final static String [] SLED_ATTRIBUTE_LABELS = {"Used for", "Type of sled"};
}
