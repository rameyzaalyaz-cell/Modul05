public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat){
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga(){
        return harga * berat;
    }

    @Override
    public String toString() {
       return super.toString() +
       String.format(
            "Berat: %s\n" +
            "Jenis: Kue Pesanan\n", 
            
        berat
        );

    
    }
}
