package org.makaia;

public class Passenger {
    private String name;
    private int age;
    private String career;
    private String nationality;
    private String cityDestiny;

    public Passenger(String name, int age, String career, String nationality, String cityDestiny) {
        this.name = name;
        this.age = age;
        this.career = career;
        this.nationality = nationality;
        this.cityDestiny = cityDestiny;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCareer() {
        return career;
    }

    public String getNationality() {
        return nationality;
    }

    public String getCityDestiny() {
        return cityDestiny;
    }

    public boolean isCareer(Career career) {
        return this.career.equals(career.getNameInSpanish());
    }
}
