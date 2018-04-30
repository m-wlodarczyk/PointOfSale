package pointofsale;

import pointofsale.database.ProductsDatabase;
import pointofsale.inputdevice.BarcodeScanner;
import pointofsale.outputdevices.LcdDisplay;
import pointofsale.outputdevices.Printer;
import pointofsale.receipt.Receipt;

public class PointOfSale {

    private static ProductsDatabase database;
    private static BarcodeScanner barcodeScanner;
    private static LcdDisplay lcdDisplay;
    private static Printer printer;

    public static void main(String[] args) {
        barcodeScanner = new BarcodeScanner();
        printer = new Printer();
        lcdDisplay = new LcdDisplay();
        try {
            database = new ProductsDatabase("Database");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                shopping(new Receipt());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    private static void shopping(Receipt receipt) throws Exception {
        String code = barcodeScanner.scan();
        while (!code.equals("exit")) {
            if (database.validBarcode(code)) {
                receipt.addProduct(database.getProduct(code));
                lcdDisplay.output(database.getProduct(code));
            }
            else if (code.equals("poweroff")) {
                throw new Exception("Point of Sale system shutdown.");
            }
            else {
                lcdDisplay.error();
            }
            code = barcodeScanner.scan();
        }
        lcdDisplay.printTotal(receipt);
        printer.output(receipt);
    }

}
