import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FormDaftarUlang extends JFrame {

    private JTextField tfNama, tfTanggal, tfNomorPendaftaran, tfNoTelp, tfEmail;
    private JTextArea  taAlamat;

    public FormDaftarUlang() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        initUI();
        setVisible(true);
    }

    private void initUI() {
        JPanel mainPanel = new PanelGradient();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));

        tfNama             = FormHelper.buatTextField(28);
        tfTanggal          = FormHelper.buatTextField(28);
        tfNomorPendaftaran = FormHelper.buatTextField(28);
        tfNoTelp           = FormHelper.buatTextField(28);
        tfEmail            = FormHelper.buatTextField(28);
        taAlamat           = FormHelper.buatTextArea(28, 3);

        mainPanel.add(new FormPanel(tfNama, tfTanggal, tfNomorPendaftaran,
                                    tfNoTelp, taAlamat, tfEmail), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 8));
        btnPanel.setOpaque(false);
        JButton btnSubmit = FormHelper.buatTombolSubmit();
        btnSubmit.addActionListener(e -> prosesSubmit());
        btnPanel.add(btnSubmit);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private boolean validasiForm() {
        String[] namaField = {
            "Nama Lengkap", "Tanggal Lahir", "Nomor Pendaftaran",
            "No. Telp", "Alamat", "E-mail"
        };
        String[] nilai = {
            tfNama.getText(), tfTanggal.getText(), tfNomorPendaftaran.getText(),
            tfNoTelp.getText(), taAlamat.getText(), tfEmail.getText()
        };

        for (int i = 0; i < nilai.length; i++) {
            if (nilai[i].trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Field \"" + namaField[i] + "\" belum diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void prosesSubmit() {
        if (!validasiForm()) return;

        int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "Apakah anda yakin data yang Anda isi sudah benar?",
            "Konfirmasi Data",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (konfirmasi == JOptionPane.OK_OPTION) {
            String[] vals = {
                tfNama.getText(), tfTanggal.getText(), tfNomorPendaftaran.getText(),
                tfNoTelp.getText(), taAlamat.getText(), tfEmail.getText()
            };
            new HasilFrame(this, vals);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        SwingUtilities.invokeLater(FormDaftarUlang::new);
    }
}
