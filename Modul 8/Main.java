public class Main {
    public static void main(String[] args) {

        Invoice i1 = new Invoice("Laptop", 1, 5000000);
        Invoice i2 = new Invoice("Tablet", 1, 200000);
        Invoice i3 = new Invoice("keyboard", 1, 500000);

        Invoice[] invoices = {i1, i2, i3};

        Employee e = new Employee(999, "Sylva", 10000000, invoices);

        e.display();
    }
}
