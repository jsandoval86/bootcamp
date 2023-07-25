package org.makaia;

import org.makaia.list.CustomGenericStack;
import org.makaia.list.CustomIntStack;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String []args) {
        DataBase db = new DataBase();

        List<Passenger> passengers = new ArrayList<>(db.getAllPassengers());
        // Lists, Arrays
        List<Passenger> passengersLess18Years = getPassengersLess18Years(passengers);
        List<Passenger> passengersOver65YearsOld = getPassengersOver65YearsOld(passengers);
        int average = getAverage(passengers);
        List<Passenger> passengersDoctorProfession = getPassengersDoctorProfession(passengers);
        Map<String, List<Passenger>> map = getPassengersByNacionality(passengers);
        Set<String> cities = getDestinyCities(passengers);

        // stacks
        CustomIntStack customIntStack = createCustomIntStack();

        // generic stacks
        CustomGenericStack<String> stringStack = new CustomGenericStack<>();
        CustomGenericStack<Integer> integerStacks = new CustomGenericStack<>();

        // queues
        Queue<Passenger> passengerQueue = db.getAllPassengersOrderByAge();
        board(passengerQueue);

    }

    private static void board(Queue<Passenger> passengerQueue) {
        for (int i= 0; i < passengerQueue.size(); i++){
            Passenger passenger = passengerQueue.poll();
            // callOtherMethod(passager)
        }
    }

    private static CustomIntStack createCustomIntStack() {
        CustomIntStack customIntStack = new CustomIntStack();
        customIntStack.push(1);
        customIntStack.push(2);
        customIntStack.push(3);
        customIntStack.search(5);
        return customIntStack;
    }

    private static Set<String> getDestinyCities(List<Passenger> passengers) {
        Set<String> cities = new HashSet<>();
        for (Passenger passenger: passengers) {
            cities.add(passenger.getCityDestiny());
        }
        return cities;
    }

    private static Map<String, List<Passenger>> getPassengersByNacionality(List<Passenger> passengers) {
        Map<String, List<Passenger>> map = new HashMap<>();

        for (Passenger passenger: passengers) {
            if(map.containsKey(passenger.getNationality())){
                List<Passenger> nacionalityPassengers = map.get(passenger.getNationality());
                nacionalityPassengers.add(passenger);
            } else {
                List<Passenger> nacionalityPassengers = new ArrayList<>();
                nacionalityPassengers.add(passenger);
                map.put(passenger.getNationality(),  nacionalityPassengers);
            }
        }
        return map;
    }

    private static List<Passenger> getPassengersDoctorProfession(List<Passenger> passengers) {
        List<Passenger> passengersDoctorProfession = new ArrayList<>();

        for (Passenger passenger: passengers) {
            if (passenger.isCareer(Career.DOCTOR)) {
                passengersDoctorProfession.add(passenger);
            }
        }
        return passengersDoctorProfession;
    }

    private static int getAverage(List<Passenger> passengers) {
        int sumAge = 0;
        for (Passenger passenger: passengers) {
            sumAge = sumAge + passenger.getAge();
        }
        int average = sumAge / passengers.size();
        return average;
    }

    private static List<Passenger> getPassengersOver65YearsOld(List<Passenger> passengers) {
        List<Passenger> passengersOver65YearsOld = new ArrayList<>();

        for (Passenger passenger: passengers) {
            if (passenger.getAge() > 65) {
                passengersOver65YearsOld.add(passenger);
            }
        }
        return passengersOver65YearsOld;
    }

    private static List<Passenger> getPassengersLess18Years(List<Passenger> passengers) {
        List<Passenger> passengersLess18Years = new ArrayList<>();

        for (Passenger passenger: passengers) {
            if (passenger.getAge() < 18) {
                passengersLess18Years.add(passenger);
            }
        }
        return passengersLess18Years;
    }
}
