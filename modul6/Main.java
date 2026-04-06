public class Main {
    public static void main(String[] args) {

        // Manusia
        Manusia m1 = new Manusia("Alya", true, "111", true);
        Manusia m2 = new Manusia("Budi", false, "112", true);
        Manusia m3 = new Manusia("Caca", true, "113", false);

        
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();
        System.out.println(m3);
        System.out.println();
        System.out.println("===============================");

        // Mahasiswa
        MahasiswaFILKOM mh1 = new MahasiswaFILKOM("255150701111029", 2.8, "Ganjar", "114", true, false);
        MahasiswaFILKOM mh2 = new MahasiswaFILKOM("135150401111029", 3.3, "Prabowo", "115", true, false);
        MahasiswaFILKOM mh3 = new MahasiswaFILKOM("245150201111029", 3.7, "Anies", "116", true, false);

       
        System.out.println(mh1);
        System.out.println();
        System.out.println(mh2);
        System.out.println();
        System.out.println(mh3);
        System.out.println();
        System.out.println("===============================");
        
        

        // Pekerja
        Pekerja p1 = new Pekerja(1000, 2022, 1, 1, 2, "Anton", "117", true, true);
        Pekerja p2 = new Pekerja(1000, 2015, 1, 1, 0, "Mark", "118", false, true);
        Pekerja p3 = new Pekerja(1000, 2000, 1, 1, 10, "Ten", "119", true, true);

        
        System.out.println(p1);
        System.out.println();
        System.out.println(p2);
        System.out.println();
        System.out.println(p3);
        System.out.println();
        System.out.println("===============================");

        // Manager
        Manager mg = new Manager("HRD", 7500, 2010, 1, 1, 3, "Jokowi", "120", true, true);

       System.out.println(mg);
    }
}
