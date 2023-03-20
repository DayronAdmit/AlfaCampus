import university.Person;
import university.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Требования:
1. Метод generateMapOfStudents должен вернуть Map в которой Integer - порядковый номер студента, Student - студент
2. Метод getStudentsKeys должен возвращать только ключи из переданной Map
3. Метод getStudentValues должен возвращать список <Student> из переданной на вход Map
4. Метод removeStudent должен удалять из карты пару ключ-значение студента ФИО которого содержит переданную строку
5. Метод renameStudent должен переименовывать всех студентов фио которых содержит переданную строку

Подсказка:
Для манипуляции над объектом не обязательно его возвращать, можно провести манипуляцию над тем кто передан на вход
 */


public class Exercise4 {
    public Map<Integer, Student> generateMapOfStudents(int quantity) {
        Map<Integer, Student> studentMap = new HashMap<>();
        List<Student> studentList = new Exercise1().generateStudents(quantity);
        for (int i = 0; i < quantity; i++) {
            studentMap.put(i, new Student(new Person()));
        }
        return studentMap;
    }

    public List<Integer> getStudentsKeys(Map<Integer, Student> studentMap) {
        return new ArrayList<>(studentMap.keySet());
    }

    public List<Student> getStudentValues(Map<Integer, Student> studentMap) {
        return new ArrayList<>(studentMap.values());
    }

    public void removeStudent(Map<Integer, Student> studentsMap, String value) {
        studentsMap.entrySet().removeIf(student -> student.getValue().getPerson().toString().contains(value));
    }

    public void renameStudent(Map<Integer, Student> studentsMap, String value) {
        studentsMap.entrySet().stream().filter(student -> student.getValue().getPerson().toString().contains(value))
                .forEach(student -> student.getValue().getPerson().renameTo("Джон","Джонович","Иванов"));
    }
}
