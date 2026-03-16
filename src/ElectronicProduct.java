public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        if (warrantyMonths > 12) {
            return price + 1000000;
        }
        return price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bảo hành: " + warrantyMonths + " tháng");
    }
}