package keystore;

import java.util.Map;
import java.util.HashMap;

public class KeyStore {

    private Map<String, String> map;

    public KeyStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public void delete(String key) {
        throw new RuntimeException();

    }

    public int count(String value) {
        throw new RuntimeException();
    }

    public void begin() {
        throw new RuntimeException();

    }

    public void commit() {
        throw new RuntimeException();

    }

    public void rollback() {
        throw new RuntimeException();

    }
}