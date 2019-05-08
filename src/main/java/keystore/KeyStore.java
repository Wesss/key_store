package keystore;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class KeyStore {

    private Map<String, String> map;
    private ArrayList<Map<String, String>> transactionStartMaps;

    public KeyStore() {
        map = new HashMap<>();
        transactionStartMaps = new ArrayList<>();
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public void delete(String key) {
        map.remove(key);
    }

    public int count(String value) {
        return (int) map.values().stream().filter(val -> val.equals(value)).count();
    }

    public void begin() {
        Map<String, String> state = new HashMap<String, String>(map);
        transactionStartMaps.add(state);
    }

    public void commit() throws RuntimeException {
        if (transactionStartMaps.isEmpty()) {
            throw new RuntimeException("No transactions begun");
        }
        transactionStartMaps.remove(transactionStartMaps.size() - 1);
    }

    public void rollback() throws RuntimeException {
        if (transactionStartMaps.isEmpty()) {
            throw new RuntimeException("No transactions begun");
        }
        Map<String, String> state = transactionStartMaps.remove(transactionStartMaps.size() - 1);
        map = state;
    }
}