package keystore;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import keystore.KeyStore;

public class KeyStoreTest {

    private KeyStore keystore;

    @Before
    public void setup() {
        keystore = new KeyStore();
    }

    @Test
    public void testSetGet() {
        keystore.set("key1", "value1");
        String value = keystore.get("key1");
        assertTrue(value.equals("value1")); 
    }

    @Test
    public void testDelete() {
        keystore.set("key1", "value1");
        keystore.delete("key1");
        String value = keystore.get("key1");
        assertTrue(value == null); 
    }

    @Test
    public void testCount() {
        keystore.set("key1", "value1");
        keystore.set("key2", "value1");
        keystore.set("key3", "value1");
        int count = keystore.count("value1");
        assertTrue(count == 3); 
    }
    
    @Test
    public void testCountNothing() {
        int count = keystore.count("value1");
        assertTrue(count == 0); 
    }

    @Test
    public void testRollbackTransaction() {
        keystore.begin();
        keystore.set("key1", "value1");
        keystore.rollback();
        String value = keystore.get("key1");
        assertTrue(value == null); 
    }

    @Test
    public void testCommitTransaction() {
        keystore.begin();
        keystore.set("key1", "value1");
        keystore.commit();
        String value = keystore.get("key1");
        assertTrue(value.equals("value1")); 
    }

    @Test
    public void testNestedTransactionRollbacks() {
        keystore.set("key1", "value1");
        keystore.begin();
        keystore.set("key1", "value2");
        keystore.begin();
        keystore.set("key1", "value3");

        assertTrue(keystore.get("key1").equals("value3"));
        keystore.rollback();
        assertTrue(keystore.get("key1").equals("value2"));
        keystore.rollback();
        assertTrue(keystore.get("key1").equals("value1"));
    }

    @Test
    public void testRollbackACommitedNestedTransaction() {
        keystore.set("key1", "value1");
        keystore.begin();
        keystore.set("key1", "value2");
        keystore.begin();
        keystore.set("key1", "value3");

        assertTrue(keystore.get("key1").equals("value3"));
        keystore.commit();
        assertTrue(keystore.get("key1").equals("value3"));
        keystore.rollback();
        assertTrue(keystore.get("key1").equals("value1"));
    }

    @Test(expected = RuntimeException.class)
    public void testCommitBeforeBeginThrows() {
        keystore.commit();
    }

    @Test(expected = RuntimeException.class)
    public void testRollbackBeforeBeginThrows() {
        keystore.rollback();
    }
}
