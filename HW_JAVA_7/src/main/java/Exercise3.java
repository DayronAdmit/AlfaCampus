import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/* Требования:
1. Метод getUniqueNumbers должен вернуть коллекцию которая содержит только уникальные элементы из переданного на вход списка
 */

public class Exercise3 {
    public HashSet<Integer> getUniqueNumbers(List<Integer> integers) {
        return new HashSet<>(integers);
    }

    //Вариант реализации через stream
//    public List<Integer> getUniqueNumbers(List<Integer> integers) {
//        return integers.stream().distinct().collect(Collectors.toList());
//    }

}
