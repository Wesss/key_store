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
}
