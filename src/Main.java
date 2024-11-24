import java.util.*;

public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        //Task 1
        System.out.println("//Task 1 -----------------");

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println("Количество 5: " + map.getCount(5));
        System.out.println("Количество 6: " + map.getCount(6));
        System.out.println("Количество 10: " + map.getCount(10));
        System.out.println("Размер: " + map.size());

        CountMap<Integer> anotherMap = new CountMapImpl<>();
        anotherMap.add(5);
        anotherMap.add(7);
        anotherMap.add(10);

        map.addAll(anotherMap);

        System.out.println("После добавления anotherMap:");
        System.out.println("Количество 5: " + map.getCount(5));
        System.out.println("Количество 10: " + map.getCount(10));
        System.out.println("Количество 7: " + map.getCount(7));

        Map<Integer, Integer> resultMap = new HashMap<>();
        map.toMap(resultMap);
        System.out.println("Копия карты: " + resultMap);

        System.out.println("//Task 2 -----------------");

        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> destination = new ArrayList<>();

        // addAll
        CollectionUtils.addAll(source, destination);
        System.out.println("После addAll: " + destination);

        // indexOf
        int index = CollectionUtils.indexOf(source, 4);
        System.out.println("Индекс элемента 4: " + index);

        // limit
        List<Integer> limited = CollectionUtils.limit(source, 3);
        System.out.println("Первые 3 элемента: " + limited);

        // range (Comparable)
        List<Integer> ranged = CollectionUtils.range(source, 3, 6);
        System.out.println("Диапазон от 3 до 6: " + ranged);

        // range (Comparator)
        List<Integer> customRanged = CollectionUtils.range(source, 3, 6, Comparator.reverseOrder());
        System.out.println("Диапазон от 3 до 6 (обратный порядок): " + customRanged);

        // containsAll
        System.out.println(CollectionUtils.containsAll(source, Arrays.asList(3, 4)));
        System.out.println(CollectionUtils.containsAll(source, Arrays.asList(9)));

        // containsAny
        System.out.println(CollectionUtils.containsAny(source, Arrays.asList(4, 9)));
        System.out.println(CollectionUtils.containsAny(source, Arrays.asList(10)));

        // removeAll
        CollectionUtils.removeAll(destination, Arrays.asList(2, 4, 6));
        System.out.println("После removeAll: " + destination);
    }
}