package keystore;

import java.util.Scanner;
import keystore.KeyStore;

public class KeyStoreMain {
    public static void main(String[] args) {
        // TODO better bootup message
        System.out.println("Hello");

        Scanner cliInput = new Scanner(System.in);
        KeyStore keyStore = new KeyStore();
        boolean running = true; // TODO exit command?
        while (running) {
            Scanner line = new Scanner(cliInput.nextLine());
            String command = line.next();
            switch (command) {
                case "SET" :
                    keyStore.set();
                    break;
                default :
                    System.out.println("Command not recognized");
                    break;
            }
            line.close();
        }
        cliInput.close();
    }
}