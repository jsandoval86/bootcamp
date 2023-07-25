package org.makaia;

import java.util.*;

public class DataBase {
    public static final List<Passenger> ALL_PASSENGERS = Arrays.asList(new Passenger("Juan", 25, Career.ENGINEER.getNameInSpanish(), Nacionality.AMERICAN.name(), "NEW YORK"),
            new Passenger("Luisa", 17, Career.DOCTOR.getNameInSpanish(), Nacionality.AMERICAN.name(), "NEW YORK"),
            new Passenger("Ramón", 67, Career.VET.getNameInSpanish(), Nacionality.COLOMBIAN.name(), "MEDELLIN"),
            new Passenger("Valentina", 15, Career.STUDENT.getNameInSpanish(), Nacionality.COLOMBIAN.name(), "BOGOTA"),
            new Passenger("Carlos", 50, Career.CARPENTER.getNameInSpanish(), Nacionality.SPANISH.name(), "MEDELLIN"));


    public List<Passenger> getAllPassengers() {
        return ALL_PASSENGERS;
    }

    public Queue<Passenger> getAllPassengersOrderByAge() {
        List<Passenger> orderList = new ArrayList<>(ALL_PASSENGERS);
        Collections.sort(orderList);

        Queue<Passenger> passengerQueue = new ArrayDeque<>();
        for (Passenger passenger: orderList) {
            passengerQueue.add(passenger);
        }

        return passengerQueue;
    }

}
