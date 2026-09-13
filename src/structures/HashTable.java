package structures;

/**
 * A crude hash table that aims to show the internals of how java util hash table works
 * Pass in a Key-Value pair, where the key represents the access/ name of a bucket
 * and is used to access the value in the bucket, a hash table is an array of
 * indexed hashed keys, where when a collision is encountered, it links the new
 * bucket to the previous bucket of that index of the array
 *
 * Insertion - big(O) O(1)
 * Removal - O(1), worst case scenario of O(n)
 * Get - O(1), worst case scenario of O(n)
 *
 * Best world between linked list and array list
 * @param <K> key
 * @param <V> Value
 */
public class HashTable<K, V> {

    private static class Bucket<K, V> {
        private final K key;
        private V value;
        public Bucket<K, V> next;

        public Bucket(K key, V value, Bucket<K , V> bucket) {
            this.key = key;
            this.value = value;
            this.next = bucket;
        }
    }

    private Bucket[] buckets;
    public int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private double DEFAULT_THRESHOLD_CAPACITY = 0.75;

    public HashTable(){
        this.buckets = new Bucket[this.DEFAULT_CAPACITY];
    }

    public HashTable(int capacity) {
        this.buckets = new Bucket[capacity];
        this.DEFAULT_CAPACITY = capacity;
    }

    public HashTable(int capacity, double loadCapacityThreshold) {
        this.buckets = new Bucket[capacity];
        this.DEFAULT_CAPACITY = capacity;
        this.DEFAULT_THRESHOLD_CAPACITY = loadCapacityThreshold;
    }

    public void put(K key, V value) {
        if(size >= this.DEFAULT_THRESHOLD_CAPACITY * this.buckets.length) {
            resize();
        }

        int index = toIndex(key);
        Bucket<K,V> bucket = this.buckets[index];

        //check if bucket exists and change value by provided key
        while(bucket != null) {
            if(java.util.Objects.equals(bucket.key, key)) {
                bucket.value = value;
                return;
            }
            bucket = bucket.next;
        }

        // insert into beginning of index to give insertion O(1)
        this.buckets[index] = new Bucket<K,V>(key, value, this.buckets[index]);
        ++size;
    }

    public boolean remove(K key) {
        int index = toIndex(key);
        Bucket<K,V> bucket = this.buckets[index];
        Bucket<K,V> prevBucket = null;

        // using linked list remove pattern to remove
        // a bucket by its index
        while(bucket != null) {
            if(java.util.Objects.equals(bucket.key, key)) {
                // remove head if prev is null
                if (prevBucket == null) {
                    this.buckets[index] = bucket.next;
                } else {
                    prevBucket.next = bucket.next;
                }
                --size;
                return  true;
            }
            prevBucket = bucket;
            bucket = bucket.next;
        }

        // no match
        return false;
    }

    public V get(K key) {
        int index = toIndex(key);
        Bucket<K,V> bucket = this.buckets[index];

        //check if bucket exists and change value by provided key
        while(bucket != null) {
            if(java.util.Objects.equals(bucket.key, key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }

        return null;
    }

    /**
     * Hashes the data type using custom .hashCode() method
     * then converts it to its positive hash before using array
     * modulo to find its index
     */
    private int toIndex(K key) {
        if(key == null)  return 0;
        int hash = key.hashCode();
        hash ^= (hash >>> 16);
        return (hash & 0x7fffffff) % this.buckets.length;
    }

    private  void resize() {
        Bucket<K,V>[] oldBuckets = this.buckets;
        this.buckets = new Bucket[this.buckets.length * 2];
        this.size = 0; // avoids infinite recursion

        for(Bucket<K,V> currentBucket : oldBuckets) {
            while(currentBucket != null) {
                // helps hashing and indexing of bucket into new array
                this.put( currentBucket.key, currentBucket.value);
                currentBucket = currentBucket.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        for (Bucket<K, V> bucket : buckets) {
            Bucket<K, V> current = bucket;
            while (current != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(current.key).append("=").append(current.value);
                first = false;
                current = current.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
