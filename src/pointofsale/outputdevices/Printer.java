package pointofsale.outputdevices;

import pointofsale.product.Product;
import pointofsale.receipt.Receipt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Printer implements OutputDevice<Receipt> {
    @Override
    public void output(Receipt data) {
        String name = "Receipt " + data.getDate().toString();
        File receipt = new File(name);
        try {
            PrintWriter writer = new PrintWriter(receipt, "UTF-8");
            writer.println("Receipt #" + data.getRecepitId());
            writer.println(data.getDate());
            for (Product p: data.getProducts()) {
                writer.println(p.getName() + " " + p.getPrice());
            }
            writer.println("Total: " + data.getTotal());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
