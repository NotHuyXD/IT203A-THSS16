import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("E01", "Laptop Dell", 15000000, 24));
        repo.add(new ElectronicProduct("E02", "Chuột Logitech", 500000, 12));
        repo.add(new FoodProduct("F01", "Bánh mì Mì", 20000, 10));
        repo.add(new FoodProduct("F02", "Sữa tươi TH", 35000, 5));

        System.out.println("=== 1. TOÀN BỘ DANH SÁCH SẢN PHẨM ===");
        for (Product p : repo.findAll()) {
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice() + "\n");
        }

        System.out.println("=== 2. TÌM KIẾM SẢN PHẨM ===");
        Product searchResult = repo.findById("E01");
        if (searchResult != null) {
            searchResult.displayInfo();
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }

        System.out.println("\n=== 3. SẮP XẾP THEO GIÁ TĂNG DẦN ===");
        List<Product> sortedList = repo.findAll();
        Collections.sort(sortedList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        for (Product p : sortedList) {
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice() + "\n");
        }

        System.out.println("=== 4. THỐNG KÊ SỐ LƯỢNG ===");
        Map<String, Integer> stats = repo.countByType();
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " sản phẩm");
        }
    }
}