public class Pemlan extends MataKuliah {

    public Pemlan(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return tugas * 0.20 + kuis * 0.20 + uts * 0.25 + uas * 0.35;
    }

    @Override
    public String getNama() { return "Pemlan"; }

    @Override
    public String getRumus() { return "Tugas(20%) + Kuis(20%) + UTS(25%) + UAS(35%)"; }
}

