public class Probstat extends MataKuliah {

    public Probstat(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.10 + kuis * 0.20 + uts * 0.30 + uas * 0.40;
    }

    @Override
    public String getNama() { return "Probstat"; }

    @Override
    public String getRumus() { return "Tugas(10%) + Kuis(20%) + UTS(30%) + UAS(40%)"; }
}

