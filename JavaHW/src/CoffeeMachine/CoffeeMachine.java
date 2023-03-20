package CoffeeMachine;

public class CoffeeMachine {
    private int countOfWaterIn = 0;
    private final short MAX_WATER_COUNT = 2000;
    private double countOfCoffeeIn = 0;
    private final short MAX_COFFEE_COUNT = 500;
    private final byte MAX_CONSUMPTION = 20;
    Coffee coffeeIn;


    public void showCountOfCoffee() {
        System.out.println("Кофе осталось " + countOfCoffeeIn + " г.");
    }

    public void showCountOfWater() {
        System.out.println("Воды осталось " + countOfWaterIn + " мл.");
    }

    public void addWater(int countOfWater) {
        if (countOfWater < 0) {
            System.out.println("Эй, так нельзя, набери себе воду в другом месте!");
        } else if (countOfWaterIn + countOfWater > MAX_WATER_COUNT) {
            countOfWaterIn = MAX_WATER_COUNT;
            System.out.println("Друг, кажется вода уже переливается!");
        } else {
            countOfWaterIn = +countOfWater;
        }
    }

    public void addCoffee(int countOfCoffee, Coffee coffee) {
        if (countOfCoffee < 0) {
            System.out.println("              !АЛАРМ!   ЗАПРЕЩЕНО!");
            System.out.println("Внимание! Кто-то пытается прикарманить кофе из кофемашины!");
        } else if (countOfCoffeeIn + countOfCoffee > MAX_COFFEE_COUNT) {
            countOfCoffeeIn = MAX_COFFEE_COUNT;
            System.out.println("Достаточно, отсек для кофе заполнился!");
            coffeeIn = coffee;
        } else {
            countOfCoffeeIn = +countOfCoffee;
            coffeeIn = coffee;
        }
    }

    public void makeCoffee(double coffeeStrength, int cupVolume) {
        if (cupVolume <= 0) {
            System.out.println("С твоей ёмкостью что-то не так, попробуй другую!");
            return;
        }
        if (cupVolume > countOfWaterIn) {
            System.out.println("Долейте воды!");
            return;
        }
        if (coffeeStrength < 0.1 || coffeeStrength > 1) {
            System.out.println("Крепость напитка должна быть в пределах от 0.1 до 1.0");
            return;
        }
        if (coffeeStrength * MAX_CONSUMPTION > countOfCoffeeIn) {
            System.out.println("Досыпьте кофе!");
            return;
        }
        countOfWaterIn -= cupVolume;
        countOfCoffeeIn -= MAX_CONSUMPTION * coffeeStrength;
        System.out.printf("Готовлю кофе %s объемом %d, крепость %.1f\n", coffeeIn.getCoffeeName(), cupVolume, coffeeStrength);
    }
}
