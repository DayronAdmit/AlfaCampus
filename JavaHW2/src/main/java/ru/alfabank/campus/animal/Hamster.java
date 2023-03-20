package ru.alfabank.campus.animal;

public class Hamster extends Pet{
    public Hamster(int pawsCount) {
        super(pawsCount);
    }

    @Override
    public void makeSound() {
        System.out.println("Уи-уи-уи");
    }

    public void hideFood() {
        System.out.println("Вся еда моя");
    }
}
