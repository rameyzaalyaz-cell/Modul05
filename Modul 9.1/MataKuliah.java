public abstract class MataKuliah {
    protected double tugas, kuis, uts, uas;

    public MataKuliah(double tugas, double kuis, double uts, double uas) {
        this.tugas = tugas;
        this.kuis  = kuis;
        this.uts   = uts;
        this.uas   = uas;
    }

    public abstract double hitungNilaiAkhir();
    public abstract String getNama();
    public abstract String getRumus();
}

