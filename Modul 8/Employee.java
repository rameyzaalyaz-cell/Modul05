public class Employee implements Payable {
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalBelanja = 0;
        for (Invoice inv : invoices) {
            totalBelanja += inv.getPayableAmount();
        }
        return salaryPerMonth - totalBelanja;
    }

   public void display() {
    System.out.println("ID: " + registrationNumber);
    System.out.println("Nama: " + name);
    System.out.printf("Gaji per bulan: Rp%,d\n", salaryPerMonth);

    System.out.println("=== Detail Belanja ===");
    for (Invoice inv : invoices) {
        inv.display();
    }

    System.out.printf("Gaji setelah potongan: Rp%,.0f\n", getPayableAmount());
}
}
