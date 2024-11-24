import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private final Map<T, Integer> countMap = new HashMap<>();

    @Override
    public void add(T o) {
        countMap.put(o, countMap.getOrDefault(o, 0) + 1);
    }

    @Override
    public int getCount(T o) {
        return countMap.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        int count = countMap.getOrDefault(o, 0);
        if (count > 1) {
            countMap.put(o, count - 1);
        } else {
            countMap.remove(o);
        }
        return count;
    }

    @Override
    public int size() {
        return countMap.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        Map<? extends T, Integer> sourceMap = source.toMap();
        for (Map.Entry<? extends T, Integer> entry : sourceMap.entrySet()) {
            countMap.put(entry.getKey(), countMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(countMap); // Возвращаем копию, чтобы избежать модификации
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        destination.clear();
        destination.putAll(countMap);
    }
}