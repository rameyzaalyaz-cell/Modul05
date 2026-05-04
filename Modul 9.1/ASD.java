public class ASD extends MataKuliah {

    public ASD(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.15 + kuis * 0.25 + uts * 0.30 + uas * 0.30;
    }

    @Override
    public String getNama() { return "ASD"; }

    @Override
    public String getRumus() { return "Tugas(15%) + Kuis(25%) + UTS(30%) + UAS(30%)"; }
}
