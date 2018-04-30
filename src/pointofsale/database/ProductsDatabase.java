package pointofsale.database;

import pair.Pair;
import pointofsale.product.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ProductsDatabase {
    public Map<String, Pair<String, Float>> database;

    public ProductsDatabase(String path) throws Exception {
        database = new HashMap<>();
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        while (line != null) {
            String[] parts = line.split(";");
            database.put(parts[0], new Pair<>(parts[1], Float.parseFloat(parts[2])));
            line = reader.readLine();
        }
    }

    public boolean validBarcode(String barcode) {
        if (database.containsKey(barcode)) {
            return true;
        }
        return false;
    }

    public Product getProduct(String barcode) {
        return new Product(barcode, database.get(barcode).getLeft(), database.get(barcode).getRight());
    }
}
