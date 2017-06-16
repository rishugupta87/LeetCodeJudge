package HashingProblems;

import java.util.Collection;

/**
 * Created by rg029761 on 9/3/16.
 */
public interface Map<K, V> {
    V get(Object key);
    void put(K key, V value);
    boolean containsKey(Object key);
    V remove(Object key);
    int size();
    Collection<V> values();
    int hashCode(int key);
}
