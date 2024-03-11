package Semester1.FlightBooking;

import java.util.Random;

public class Airplane {
    private String destination;
    private int freeSeats;
    private Random rnd = new Random();

    public Airplane(String destination) {
        this.destination = destination;
        freeSeats = rnd.nextInt(5);
    }

    public String getDestination() {
        return destination;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

}
