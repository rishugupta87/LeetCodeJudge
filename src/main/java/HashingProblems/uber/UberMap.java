package HashingProblems.uber;

import java.util.Arrays;
import java.util.Random;

/**
 * http://blog.gainlo.co/index.php/2016/08/14/uber-interview-question-map-implementation/
 *
 * Implement data structure “Map” storing pairs of integers (key, value)
 * and define following member functions in O(1) runtime: void insert(key, value),
 * void delete(key), int get(key), int getRandomKey().
 */
public class UberMap<K, V> implements UberMapInterface {
    Entry[] bucket;
    static Entry[] keyArray;
    static int count = 0;

    public UberMap(int size) {
        bucket = new Entry[size];
        keyArray = new Entry[8];
    }

    /**
     * Note we returning the entry object here.
     *
     * @param key
     * @return
     */
    public Object get(final Object key) {
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
                return (V)currEntry;
            }
            currEntry = currEntry.next;
        }
        return null;
    }

    /**
     * When you put an entry in the map also store keys in a separate array
     *
     * @param key
     * @param value
     */
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
            Entry entry = new Entry(key, value, count);
            bucket[index]  = new Entry(key, value, count);;
            keyArray[count++] = entry;
            return;
        }
        //there is an entry at that index maintained as a linked list. Go through it and serach for key, if exists override else put an entry.
        while(currEntry.next != null) {
            if(key.equals(currEntry.key)) {
                currEntry.value = value; //override
                currEntry.arrayIndex = count;
                keyArray[count++] = currEntry;
                break;
            }
            currEntry = currEntry.next;
        }
        if(!currEntry.key.equals(key)) {
            Entry entry = new Entry(key, value, count);
            currEntry.next = entry;
            keyArray[count++] = entry;
        }
    }

    public Object getRandomKey() {
        Random random = new Random();
        int index = random.nextInt(keyArray.length - 1);
        return keyArray[index].key;
    }

    public Object getRandomValue() {
        Random random = new Random();
        int index = random.nextInt(keyArray.length - 1);
        return keyArray[index].value;
    }

    /**
     * Since you are maintaining a separate array to keep track of keys.
     * When you delete a key from map, you also need to delete key from array . which makes it O(n) operation
     * How can you reduce this ?
     *
     * Suppose you array has [1, 4, 2, 5, 9] and you delete 2.
     * Instead of move 5 and 9 to the left, you can just switch 2 with 9 and reduce the length by 1.
     * We lose order but deletion can be done in O(1) time.
     *
     * @param key
     * @return
     */
    public Object remove(final Object key) {
        Entry entry = (Entry)this.get(key);
        int arrayIndex = entry.arrayIndex;
        keyArray[arrayIndex] = keyArray[keyArray.length - 1]; //replace last element with one to be deleted
        return Arrays.copyOf(keyArray, keyArray.length-1); //remove last element copy into new array.
    }

    public int hashCode(final int h) {
        return (h & Integer.MAX_VALUE) % bucket.length;
    }

    static class Entry<K, V> {
        K key;
        V value;
        int arrayIndex; //to map key to array index, useful if we want to remove a key we can directly get the array index where the key is stored in array.
        Entry next;

        public Entry(K key, V value, int arrayIndex) {
            this.key = key;
            this.value = value;
            next = null;
            this.arrayIndex = arrayIndex;
        }
    }
}
