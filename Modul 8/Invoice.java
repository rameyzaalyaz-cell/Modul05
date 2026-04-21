public class Invoice implements Payable {
    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return quantity * pricePerItem;
    }

    public void display() {
    System.out.println("Produk: " + productName);
    System.out.println("Jumlah: " + quantity);
    System.out.printf("Harga per item: Rp%,d\n", pricePerItem);
    System.out.printf("Total: Rp%,.0f\n", getPayableAmount());
    System.out.println("----------------------");
}
}
