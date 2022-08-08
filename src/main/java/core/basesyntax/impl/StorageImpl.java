package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static Object[] keyArray;
    private static Object[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = new Object[MAX_ARRAY_SIZE];
        valueArray = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                //keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
        valueArray[size] = value;
        keyArray[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || (keyArray[i] != null && keyArray[i].equals(key))) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
