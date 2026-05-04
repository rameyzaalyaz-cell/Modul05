public class Matkomlan extends MataKuliah {

    public Matkomlan(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.25 + kuis * 0.15 + uts * 0.30 + uas * 0.30;
    }

    @Override
    public String getNama() { return "Matkomlan"; }

    @Override
    public String getRumus() { return "Tugas(25%) + Kuis(15%) + UTS(30%) + UAS(30%)"; }
}
