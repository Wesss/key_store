package keystore;

import java.util.Scanner;
import java.util.NoSuchElementException;
import keystore.KeyStore;

public class KeyStoreMain {
    public static void main(String[] args) {
        System.out.println("Key Store CLI");
        System.out.println("=============");
        System.out.println("available commands are SET, GET, DELETE, COUNT, BEGIN, COMMIT, ROLLBACK, and EXIT");
        System.out.println();

        Scanner cliInput = new Scanner(System.in);
        KeyStore keyStore = new KeyStore();
        boolean running = true;
        while (running) {
            Scanner line = new Scanner(cliInput.nextLine());
            try {
                String command = line.next();
                switch (command) {
                    case "SET" :
                        keyStore.set(line.next(), line.next());
                        break;
                    case "GET" :
                        String value = keyStore.get(line.next());
                        if (value == null) {
                            print("key not set");
                        } else {
                            print(value);
                        }
                        break;
                    case "DELETE" :
                        keyStore.delete(line.next());
                        break;
                    case "COUNT" :
                        print(keyStore.count(line.next()) + "");
                        break;
                    case "BEGIN" :
                        keyStore.begin();
                        break;
                    case "COMMIT" :
                        try {
                            keyStore.commit();
                        } catch (RuntimeException e) {
                            print("no transaction");
                        }
                        break;
                    case "ROLLBACK" :
                        try {
                            keyStore.rollback();
                        } catch (RuntimeException e) {
                            print("no transaction");
                        }
                        break;
                    case "EXIT" :
                        running = false;
                        break;
                    default :
                        print("Command not recognized");
                        break;
                }
            } catch (NoSuchElementException e) {
                print("not enough arguments supplied");
            }
            line.close();
        }
        cliInput.close();
    }

    private static void print(String msg) {
        System.out.println("=> " + msg);
    }
}