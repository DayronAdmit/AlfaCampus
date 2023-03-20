package ru.alfabank.campus.person;

public class Person {
    private String name;
    private String lastName;
    private int yearOfBirth;

    public Person(String name, String lastName, int yearOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastName + ";" + " Имя: " + name;
    }

}
