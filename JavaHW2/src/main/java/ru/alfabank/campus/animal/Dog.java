package ru.alfabank.campus.animal;

public class Dog extends Pet {
    public Dog(int pawsCount) {
        super(pawsCount);
    }

    @Override
    public void makeSound() {
        System.out.println("Гав-Гав! Уаууууууууууууууууууу");
    }

    public void bringStick() {
        System.out.println("Я принес палку");
    }
}
