package ru.alfabank.campus.animal;

public class Cat extends Pet {

    public Cat(int pawsCount) {
        super(pawsCount);
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу-мяу-мяу");
    }

    public void catchMouse() {
        System.out.println("Поймала мышку");
    }
}
