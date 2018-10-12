public interface Vinfo {
   /** Mileage of a Sedan car */
   final static double sedanMpg = 23.7;
   /** Mileage of a Coupe car*/
   final static double coupeMpg = 28.2;
   /** Mileage of a Wagon car*/
   final static double wagonMpg = 19.5;
   /** Mileage that is to be deducted if the car has towing capability */
   final static double towingMpg = 3;
   /** Mileage of a Pontoon boat */
   final static double pontoonMpg = 3.5;
   /** Mileage of a PWC boat*/
   final static double pwcMpg = 2.2;
   /** Mileage of a SailBoat */
   final static double sailBoatMpg = 0;
   /** Mileage of a benz Coupe */
   final static double benzCoupeMpg = 20.8;
   /** Mileage of a benz Sedan */
   final static double benzSedanMpg = 19.0;
   /** Mileage of a benz SUV */
   final static double benzSuvMpg = 18.0;
   /** Mileage of a benz Cabriolet */
   final static double benzCabrioletMpg = 20.0;
   /** Mileage reduction for benz 4matic All Wheel Drive */
   final static double benzAwdMileageReduction = 2.0;
   /** Calculates and returns the Mileage of a vehicle */
	public abstract double gasMileage();
}
