public interface Vinfo {
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
	public abstract double gasMileage();
}
