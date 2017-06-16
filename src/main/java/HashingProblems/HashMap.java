package HashingProblems;

import java.util.Collection;

/**
 * 1. Class to implement a hashmap in java
 *
 *  Hashmap best and average case for Search, Insert and Delete is O(1) and worst case is O(n).
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> implements Map{
    Entry[] bucket;

    public HashMap(int size) {
        bucket = new Entry[size];
    }

    public V get(final Object key) {
        if(key == null) {
            return null;
        }

        int index = hashCode((Integer)key);
        Entry currEntry = bucket[index];
        if(currEntry == null) {
            return null;
        }
        while(currEntry.next != null) {
            if(key.equals(currEntry.key)) {
                return (V)currEntry.value;
            }
            currEntry = currEntry.next;
        }
        return null;
    }

    public int hashCode(int h) {
        /*
         * Integer.MAX_VALUE which is 231−1231−1 to mask out the sign bit and then just take modulo.
         * Handles negative values without a branch and is as fast as it gets
         * without assuming the hash table is a power of two size
         */
        return (h & Integer.MAX_VALUE) % bucket.length;
    }

    public void put(final Object key, final Object value) {
        if(key == null) {
            return;
        }

        //key can be null - return null
        //key may not exist - make an entry
        //key might already exist - override
        int index = hashCode((Integer)key);

        Entry currEntry = bucket[index];
        if(currEntry == null) { //no entry at that index
            Entry entry = new Entry(key, value);
            bucket[index]  = entry;
            return;
        }
        //there is an entry at that index maintained as a linked list. Go through it and serach for key, if exists override else put an entry.
        while(currEntry.next != null) {
            if(key.equals(currEntry.key)) {
                currEntry.value = value; //override
                break;
            }
            currEntry = currEntry.next;
        }
        if(!currEntry.key.equals(key)) {
            currEntry.next = new Entry(key, value);
        } else {
            currEntry.value = value;
        }
    }

    public boolean containsKey(final Object key) {
        //return this.get(key) == null ? ;
        return this.get(key) == null ? false:true;
    }

    public Object remove(final Object key) {
        return null;
    }

    public int size() {
        return bucket.length;
    }

    public Collection<V> values() {
        return null;
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
}
