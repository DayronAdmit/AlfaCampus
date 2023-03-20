/* Требования:
1. Метод generateStudents должен возвращать коллекцию List<Student> размера quantity
2. group в Student должны быть A,B,C
3. course от 0 до 5
4. gpa от 0 до 100

Подсказка:
1. Использовать random (https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
2. Для групп можно воспользоваться методом charAt (https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#charAt(int))
 */

import university.Person;
import university.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise1 {
    public List<Student> generateStudents(int quantity) {
        Random random = new Random();
        List<Student> students;
        try {
            students = new ArrayList<>(quantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Создан пустой список");
            quantity = 0;
        }
        students = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            students.add(new Student(new Person(), getRandomGroup(random), getRandomCourse(random), getRandomGPA(random)));
        }
        return students;
    }

    private char getRandomGroup(Random random) {
        String charGroupString = "ABC";
        return charGroupString.charAt(random.nextInt(3));
    }

    private int getRandomCourse(Random random) {
        return random.nextInt(6);
    }

    private int getRandomGPA(Random random) {
        return random.nextInt(101);
    }
}
