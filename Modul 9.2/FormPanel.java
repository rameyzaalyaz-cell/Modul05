package pratikum91;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FormPanel extends JPanel {

    public FormPanel(JTextField tfNama, JTextField tfTanggal, JTextField tfNomor,
                     JTextField tfNoTelp, JTextArea taAlamat, JTextField tfEmail) {
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(new EmptyBorder(10, 0, 10, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets  = new Insets(6, 4, 6, 4);
        gbc.anchor  = GridBagConstraints.WEST;

        String[]    labelTeks  = {"Nama Lengkap", "Tanggal Lahir", "Nomor Pendaftaran", "No. Telp", "Alamat", "E-mail"};
        Component[] komponen   = {tfNama, tfTanggal, tfNomor, tfNoTelp, taAlamat, tfEmail};

        for (int i = 0; i < labelTeks.length; i++) {
            // Label
            gbc.gridx   = 0;
            gbc.gridy   = i;
            gbc.fill    = GridBagConstraints.NONE;
            gbc.weightx = 0;
            JLabel lbl = new JLabel(labelTeks[i]);
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
            lbl.setForeground(new Color(40, 60, 80));
            lbl.setPreferredSize(new Dimension(140, 24));
            add(lbl, gbc);

            // Input
            gbc.gridx   = 1;
            gbc.fill    = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;

            if (komponen[i] instanceof JTextArea) {
                JScrollPane sp = new JScrollPane((JTextArea) komponen[i]);
                sp.setBorder(BorderFactory.createLineBorder(new Color(180, 210, 230)));
                sp.setPreferredSize(new Dimension(280, 70));
                add(sp, gbc);
            } else {
                add(komponen[i], gbc);
            }
        }
    }
}
