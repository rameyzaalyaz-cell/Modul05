public class Manusia {
    private String nama;
    private boolean jenisKelamin;
     private String nik;
     private boolean menikah;

    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah) {
       this.nama = nama;
       this.jenisKelamin = jenisKelamin;
       this.nik = nik;
       this.menikah = menikah;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setJenisKelamin(boolean jeniskelamin){
        this.jenisKelamin = jeniskelamin;
    }

    public void setNik(String nik){
        this.nik = nik;
    }

    public void setMenikah(boolean menikah){
        this.menikah = menikah;
    }

    public String getNik(){
         return nik;
    }

    public double getTunjangan() {
        if (menikah) {
            if (jenisKelamin) return 25;
            else return 20;
         
        } else {
            return 15;
        }
    }

    public double getPendapatan () {
        return getTunjangan();
    }


    @Override
    public String toString() {
       return String.format(
        "Nama          : %s\n" +
        "NIK           : %s\n" +
        "Jenis Kelamin : %s\n" +
        "Pendapatan    : %.1f",
        nama, nik,
        jenisKelamin ? "Laki-laki" : "Perempuan",
        getPendapatan()
    );
    }
}

      
