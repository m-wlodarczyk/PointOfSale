package pointofsale.receipt;

import pointofsale.product.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    private Date date;
    private static int recepitId = 0;
    private ArrayList<Product> products;
    private double total;

    public Receipt() {
        date = new Date();
        total = 0;
        recepitId++;
        products = new ArrayList<>();
    }

    public Date getDate() {
        return this.date;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        total+=product.getPrice();
    }

    public String getTotal() {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(this.total);
    }

    public static Integer getRecepitId() {
        return recepitId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
