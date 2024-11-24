import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {

    // Перенос всех элементов из source в destination
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    // Создаёт новый список
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    // Индекс элемента в списке
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    // Возвращает первые size элементов списка
    public static <T> List<T> limit(List<? extends T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    // Добавляет элемент в список
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    // Удаляет все элементы c2 из removeFrom
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    // Возвращает true, если первый список содержит все элементы второго
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    // Возвращает true, если первый список содержит хотя бы один элемент второго
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T item : c2) {
            if (c1.contains(item)) {
                return true;
            }
        }
        return false;
    }

    // Возвращает элементы в диапазоне от min до max (с использованием Comparable)
    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        return list.stream()
                .filter(e -> e.compareTo(min) >= 0 && e.compareTo(max) <= 0)
                .sorted()
                .collect(Collectors.toList());
    }

    // Возвращает элементы в диапазоне от min до max
    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {

        T realMin = comparator.compare(min, max) <= 0 ? min : max;
        T realMax = comparator.compare(min, max) > 0 ? min : max;

        return list.stream()
                .filter(e -> comparator.compare(e, realMin) >= 0 && comparator.compare(e, realMax) <= 0) // Фильтрация
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}