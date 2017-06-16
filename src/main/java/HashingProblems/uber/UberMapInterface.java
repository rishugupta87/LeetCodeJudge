package HashingProblems.uber;

/**
 * Created by rg029761 on 9/5/16.
 */
public interface UberMapInterface<K, V> {
    V get(Object key);
    void put(K key, V value);
    V remove(Object key);
    int hashCode(int key);
    Object getRandomKey();
    Object getRandomValue();
}
