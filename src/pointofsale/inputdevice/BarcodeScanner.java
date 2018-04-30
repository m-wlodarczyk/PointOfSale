package pointofsale.inputdevice;

import java.util.Scanner;

public class BarcodeScanner {
    public String scan() {
        return new Scanner(System.in).next();
    }
}
