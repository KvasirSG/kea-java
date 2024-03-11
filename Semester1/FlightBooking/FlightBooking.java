package Semester1.FlightBooking;

public class FlightBooking {

    public static void main(String[] args) {
        String myTrip = "Rome";
        int bookings = 2;
        Airplane airPlane1 = new Airplane("New York");
        Airplane airPlane2 = new Airplane("Rome");
        Airplane airPlane3 = new Airplane("Male");
        Airplane myAirplane;

        if (airPlane1.getDestination() == myTrip) {

            myAirplane = airPlane1;
        } else if (airPlane2.getDestination() == myTrip) {
            myAirplane = airPlane2;
        } else if (airPlane3.getDestination() == myTrip) {
            myAirplane = airPlane3;
        } else {
            myAirplane = null;
        }

        if (myAirplane != null) {
            if (bookings <= myAirplane.getFreeSeats()) {
                int temp = myAirplane.getFreeSeats() - bookings;
                myAirplane.setFreeSeats(temp);
                System.out.println("You got it! vacation to " + myTrip + " is booked");
            } else {
                System.out.println(
                        "Sorry, destination not found or no free seats -try again later or change destination");
            }
        }

    }

}