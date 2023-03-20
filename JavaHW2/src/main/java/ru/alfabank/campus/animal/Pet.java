package ru.alfabank.campus.animal;

public abstract class Pet {
    private int pawsCount;

    public Pet(int pawsCount) {
        this.pawsCount = pawsCount;
    }

    public int getPawsCount() {
        return pawsCount;
    }

    public void sleep() {
        System.out.println("Я сплю");
    }

    public void play() {
        System.out.println("Я играю");
    }

    abstract public void makeSound();
}
