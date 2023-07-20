package org.makaia;

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
        /**
         *   key -> value
         *   nacionality -> list(passengers)
         *
         *   AMERICAN -> list(american passengers)
         *   COLOMBIAN -> list(colombian passengers)
         *   SPANISH -> list(spanish passengers)
         */

        Map<String, List<Passenger>> map = getPassengersByNacionality(passengers);
        Set<String> cities = getDestinyCities(passengers);
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
