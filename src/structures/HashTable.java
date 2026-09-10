package structures;

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

    private Bucket<K, V>[] buckets;
    public int size = 0;
    private int defaultCapacity = 10;
    private double loadCapacityThreshold = 0.75;

    public HashTable(){
        this.buckets = new Bucket[this.defaultCapacity];
    }

    public HashTable(int capacity) {
        this.buckets = new Bucket[capacity];
        this.defaultCapacity = capacity;
    }

    public HashTable(int capacity, double loadCapacityThreshold) {
        this.buckets = new Bucket[capacity];
        this.defaultCapacity = capacity;
        this.loadCapacityThreshold = loadCapacityThreshold;
    }

    public void put(K key, V value) {
        // check load capacity of bucket
        if(size >= buckets.length * loadCapacityThreshold) {
            resize();
        }

        // check if bucket already exists
        int index = this.hash(key);
        Bucket<K, V> bucket = buckets[index];

        // checks to see if index already exists
        while(bucket != null) {
            if(java.util.Objects.equals(bucket.key, key)){
                bucket.value = value;
                return;
            }
            bucket = bucket.next;
        }

        // if it doesn't
        buckets[index] = new Bucket<K, V>( key, value, buckets[index]);
        ++size;
    }

    public V get(K key) {
        int index = hash(key);
        Bucket<K, V> bucket = buckets[index];

        while(bucket != null) {
            if(java.util.Objects.equals(bucket.key, key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }

        return null;
    }

    public boolean remove(K key) {
        int index = hash(key);
        Bucket<K, V> bucket = buckets[index];
        Bucket<K , V> prevBucket = null;

        while(bucket != null) {
            if(java.util.Objects.equals(bucket.key, key)) {
                //remove head
                if(prevBucket == null) {
                    buckets[index] = bucket.next;
                } else {
                    prevBucket.next = bucket.next;
                }
                --size;
                return true;
            }
            prevBucket = bucket;
            bucket = bucket.next;
        }

        return false;
    }

    private int hash(K key) {
        if(key == null) return 0;
        int hashcode = key.hashCode();
        hashcode ^= hashcode >>> 16;
        return (hashcode & 0x7fffffff) % buckets.length;
    }

    private void resize() {
        Bucket<K , V>[] oldBuckets = buckets;
        buckets = new Bucket[oldBuckets.length * 2];
        size = 0;

        for(Bucket headBucket : oldBuckets) {
            Bucket<K, V> currentBucket = headBucket;
            while(currentBucket != null) {
                put(currentBucket.key, currentBucket.value);
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
