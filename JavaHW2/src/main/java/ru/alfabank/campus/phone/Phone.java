package ru.alfabank.campus.phone;

import ru.alfabank.campus.person.Person;

public class Phone {
    private String model;
    private String phoneNumber;
    Person owner;

    public Phone(String model, String phoneNumber, Person owner) {
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public Phone(String model, String phoneNumber) {
        this(model, phoneNumber, null);

    }

    public Phone(String model) {
        this(model, null, null);
    }

    public String getModel() {
        return model;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String telephoneInfo = "Неизвестный телефон";
        if (owner != null) {
            telephoneInfo = "Владелец телефона: " + owner.getName() + " " + owner.getLastName() + ". " +
                    "Модель: " + getModel() + ". " + "Номер телефона: " + getPhoneNumber();
            return telephoneInfo;
        }
        if (phoneNumber != null) {
            telephoneInfo = "Модель: " + getModel() + ". " + "Номер телефона: " + getPhoneNumber();
            return telephoneInfo;
        }
        if (model != null) {
            telephoneInfo = "Модель: " + getModel();
            return telephoneInfo;
        }
        return telephoneInfo;
    }

}
