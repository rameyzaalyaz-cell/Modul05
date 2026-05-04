import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class HitungNilaiAkhir extends JFrame {

    private JRadioButton rbPemlan, rbASD, rbMatkomlan, rbProbstat;
    private ButtonGroup  group;

    private JTextField tfTugas, tfKuis, tfUTS, tfUAS, tfHasil;
    private JTextArea  taHasil;
    private JLabel     lblRumus;

    private Map<String, Double> nilaiMap = new LinkedHashMap<>();

    public HitungNilaiAkhir() {
        setTitle("Hitung Nilai Akhir dengan GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(460, 560);
        setLocationRelativeTo(null);
        setResizable(false);
        initUI();
        setVisible(true);
    }

    private void initUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(16, 20, 16, 20));
        mainPanel.setBackground(Color.WHITE);

        // Judul
        JLabel judul = new JLabel("Hitung Nilai Akhir");
        judul.setFont(new Font("SansSerif", Font.BOLD, 16));
        judul.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(judul);
        mainPanel.add(Box.createVerticalStrut(12));

        //  buttons
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        radioPanel.setBackground(Color.WHITE);

        rbPemlan    = new JRadioButton("Pemlan", true);
        rbASD       = new JRadioButton("ASD");
        rbMatkomlan = new JRadioButton("Matkomlan");
        rbProbstat  = new JRadioButton("Probstat");

        group = new ButtonGroup();
        for (JRadioButton rb : new JRadioButton[]{rbPemlan, rbASD, rbMatkomlan, rbProbstat}) {
            rb.setBackground(Color.WHITE);
            rb.setFont(new Font("SansSerif", Font.PLAIN, 13));
            group.add(rb);
            radioPanel.add(rb);
            rb.addActionListener(e -> updateRumusLabel());
        }

        mainPanel.add(radioPanel);
        mainPanel.add(Box.createVerticalStrut(6));

        // Label rumus
        lblRumus = new JLabel();
        lblRumus.setFont(new Font("SansSerif", Font.ITALIC, 11));
        lblRumus.setForeground(new Color(100, 100, 100));
        lblRumus.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblRumus);
        mainPanel.add(Box.createVerticalStrut(12));

        // untuk input
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 8, 4, 8);
        gbc.anchor = GridBagConstraints.WEST;

        tfTugas = new JTextField(8);
        tfKuis  = new JTextField(8);
        tfUTS   = new JTextField(8);
        tfUAS   = new JTextField(8);
        tfHasil = new JTextField(8);
        tfHasil.setEditable(false);
        tfHasil.setBackground(new Color(234, 243, 222));
        tfHasil.setFont(new Font("Monospaced", Font.BOLD, 13));

        String[]     labels = {"Tugas :", "Kuis :", "UTS :", "UAS :", "Hasil :"};
        JTextField[] fields = {tfTugas, tfKuis, tfUTS, tfUAS, tfHasil};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i;
            JLabel lbl = new JLabel(labels[i]);
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
            formPanel.add(lbl, gbc);
            gbc.gridx = 1;
            formPanel.add(fields[i], gbc);
        }

        mainPanel.add(formPanel);
        mainPanel.add(Box.createVerticalStrut(12));

        // Tombol Hitung
        JButton btnHitung = new JButton("Hitung");
        btnHitung.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnHitung.setBackground(new Color(24, 95, 165));
        btnHitung.setForeground(Color.WHITE);
        btnHitung.setFocusPainted(false);
        btnHitung.setBorder(new EmptyBorder(8, 28, 8, 28));
        btnHitung.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHitung.addActionListener(e -> hitungNilai());
        mainPanel.add(btnHitung);
        mainPanel.add(Box.createVerticalStrut(14));

        // Label hasil
        JLabel lblArea = new JLabel("HASIL NILAI SEMUA MATA KULIAH");
        lblArea.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblArea.setForeground(new Color(90, 90, 90));
        lblArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblArea);
        mainPanel.add(Box.createVerticalStrut(6));

        // hasil
        taHasil = new JTextArea(6, 32);
        taHasil.setEditable(false);
        taHasil.setFont(new Font("Monospaced", Font.PLAIN, 13));
        taHasil.setBackground(new Color(245, 245, 243));
        taHasil.setBorder(new EmptyBorder(8, 10, 8, 10));
        JScrollPane scroll = new JScrollPane(taHasil);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(scroll);
        mainPanel.add(Box.createVerticalStrut(10));

        // Tombol Tampilkan
        JButton btnTampilkan = new JButton("Tampilkan nilai semua matkul");
        btnTampilkan.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnTampilkan.setFocusPainted(false);
        btnTampilkan.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTampilkan.addActionListener(e -> tampilkanSemua());
        mainPanel.add(btnTampilkan);

        add(mainPanel);
        updateRumusLabel();
    }

    private void updateRumusLabel() {
        MataKuliah mk = buatMataKuliah(0, 0, 0, 0);
        lblRumus.setText("Rumus: " + mk.getRumus());
    }

    private MataKuliah buatMataKuliah(double t, double k, double u, double a) {
        if (rbASD.isSelected())        return new ASD(t, k, u, a);
        if (rbMatkomlan.isSelected())  return new Matkomlan(t, k, u, a);
        if (rbProbstat.isSelected())   return new Probstat(t, k, u, a);
        return new Pemlan(t, k, u, a);
    }

    private void hitungNilai() {
        try {
            double t = parseNilai(tfTugas.getText(), "Tugas");
            double k = parseNilai(tfKuis.getText(),  "Kuis");
            double u = parseNilai(tfUTS.getText(),   "UTS");
            double a = parseNilai(tfUAS.getText(),   "UAS");

            MataKuliah mk = buatMataKuliah(t, k, u, a);
            double hasil  = mk.hitungNilaiAkhir();

            tfHasil.setText(String.format("%.1f", hasil));
            nilaiMap.put(mk.getNama(), hasil);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseNilai(String teks, String namaField) {
        teks = teks.trim();
        if (teks.isEmpty())
            throw new NumberFormatException("Field '" + namaField + "' tidak boleh kosong!");
        double val = Double.parseDouble(teks);
        if (val < 0 || val > 100)
            throw new NumberFormatException("Nilai " + namaField + " harus antara 0 - 100!");
        return val;
    }

    private void tampilkanSemua() {
        if (nilaiMap.isEmpty()) {
            taHasil.setText("Belum ada nilai yang dihitung.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> e : nilaiMap.entrySet()) {
            sb.append(String.format("%-12s : %.1f%n", e.getKey(), e.getValue()));
        }
        taHasil.setText(sb.toString());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        SwingUtilities.invokeLater(HitungNilaiAkhir::new);
    }
}

