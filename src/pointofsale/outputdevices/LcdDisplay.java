package pointofsale.outputdevices;

import pointofsale.product.Product;
import pointofsale.receipt.Receipt;

public class LcdDisplay implements OutputDevice<Product> {
    @Override
    public void output(Product data) {
        System.out.println("Name: " + data.getName() + " Price: " + data.getPrice());
    }

    public void printTotal(Receipt receipt) {
        System.out.println("Total price: " + receipt.getTotal());
    }

    public void error() {
        System.out.println("Invalid barcode");
    }
}
