package org.makaia;

import java.util.Arrays;
import java.util.List;

public class DataBase {
    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = Arrays.asList(
            new Passenger("Juan", 25, Career.ENGINEER.getNameInSpanish(), Nacionality.AMERICAN.name(), "NEW YORK"),
            new Passenger("Luisa", 17, Career.DOCTOR.getNameInSpanish(), Nacionality.AMERICAN.name(), "NEW YORK"),
            new Passenger("Ramón", 67, Career.VET.getNameInSpanish(), Nacionality.COLOMBIAN.name(), "MEDELLIN"),
            new Passenger("Valentina", 15, Career.STUDENT.getNameInSpanish(), Nacionality.COLOMBIAN.name(), "BOGOTA"),
            new Passenger("Carlos", 50, Career.CARPENTER.getNameInSpanish(), Nacionality.SPANISH.name(), "MEDELLIN")
        );
        return passengers;
    }

}
