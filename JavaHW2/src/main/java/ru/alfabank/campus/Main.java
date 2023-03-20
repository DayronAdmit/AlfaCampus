package ru.alfabank.campus;

import ru.alfabank.campus.person.Person;
import ru.alfabank.campus.phone.Phone;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Василий", "Иванов", 1999);
        Person person2 = new Person("Вадим", "Петров", 1992);

        Phone phone1 = new Phone("M6", "89063332206", person1);
        Phone phone2 = new Phone("iphone 15", "89153332216");
        Phone phone3 = new Phone("Note 4");
        Phone phone4 = new Phone();

        System.out.println(person1);
        System.out.println(person2);

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        System.out.println(phone4);

    }
}