public class Main {
    public static void main(String[] args) {

        Kue[] kue = new Kue[20];

        // isi 20 kue 
        kue[0] = new KuePesanan("Lapis", 10000, 2);
        kue[1] = new KueJadi("Donat", 5000, 10);
        kue[2] = new KuePesanan("Brownies", 20000, 1.5);
        kue[3] = new KueJadi("Kue Cubit", 3000, 15);
        kue[4] = new KuePesanan("Bolu", 15000, 2.5);
        kue[5] = new KueJadi("Roti", 4000, 8);
        kue[6] = new KuePesanan("Klepon", 8000, 1);
        kue[7] = new KueJadi("Onde", 3500, 12);
        kue[8] = new KuePesanan("Nastar", 25000, 1);
        kue[9] = new KueJadi("Putri Salju", 6000, 20);
        kue[10] = new KuePesanan("Lemper", 7000, 2);
        kue[11] = new KueJadi("Bakpia", 5000, 18);
        kue[12] = new KuePesanan("Serabi", 9000, 1.2);
        kue[13] = new KueJadi("Pukis", 4000, 14);
        kue[14] = new KuePesanan("Martabak", 30000, 1);
        kue[15] = new KueJadi("Cucur", 3000, 16);
        kue[16] = new KuePesanan("Dadar Gulung", 10000, 1.3);
        kue[17] = new KueJadi("Apem", 3500, 10);
        kue[18] = new KuePesanan("Talam", 12000, 1.7);
        kue[19] = new KueJadi("Risoles", 4500, 9);

        double totalHarga = 0;

        double totalHargaPesanan = 0;
        double totalBerat = 0;

        double totalHargaJadi = 0;
        double totalJumlah = 0;

        Kue kueTermahal = kue[0];

        for (int i = 0; i < kue.length; i++) {

            System.out.println(kue[i].toString() +
                    "Harga Akhir: " + kue[i].hitungHarga());

            totalHarga += kue[i].hitungHarga();

            //  pakai instanceof
            if (kue[i] instanceof KuePesanan) {
              KuePesanan kp = (KuePesanan) kue[i];
              totalHargaPesanan += kp.hitungHarga();
              totalBerat += kp.getBerat();

             } else if (kue[i] instanceof KueJadi) {
               KueJadi kj = (KueJadi) kue[i];
               totalHargaJadi += kj.hitungHarga();
               totalJumlah += kj.getJumlah();
            }

            // harga terbesar
            if (kue[i].hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = kue[i];
            }
        }

        // output akhir
        System.out.println("\nTotal semua harga: " + totalHarga);

        System.out.println("\nKuePesanan:");
        System.out.println("Total harga: " + totalHargaPesanan);
        System.out.println("Total berat: " + totalBerat);

        System.out.println("\nKueJadi:");
        System.out.println("Total harga: " + totalHargaJadi);
        System.out.println("Total jumlah: " + totalJumlah);

        System.out.println("\nKue dengan harga terbesar:");
        System.out.println(kueTermahal.toString() +
                "Harga Akhir: " + kueTermahal.hitungHarga());
    }
}
