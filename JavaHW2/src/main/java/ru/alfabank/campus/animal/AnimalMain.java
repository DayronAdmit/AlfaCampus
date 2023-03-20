package ru.alfabank.campus.animal;

public class AnimalMain {
    public static void main(String[] args) {
        Cat cat = new Cat(4);
        Dog dog = new Dog(4);
        Hamster hamster = new Hamster(4);

        cat.makeSound();
        System.out.println("Количество лап: " + cat.getPawsCount());
        cat.sleep();
        cat.play();
        cat.catchMouse();
        System.out.println();

        dog.makeSound();
        System.out.println("Количество лап: " + dog.getPawsCount());
        dog.sleep();
        dog.play();
        dog.bringStick();
        System.out.println();

        hamster.makeSound();
        System.out.println("Количество лап: " + hamster.getPawsCount());
        hamster.sleep();
        hamster.play();
        hamster.hideFood();
        System.out.println();

    }
}
