package pratikum91;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class HasilFrame extends JFrame {

    private static final String[] KEYS = {
        "Nama", "Tanggal Lahir", "No. Pendaftaran", "No. Telp", "Alamat", "E-mail"
    };

    public HasilFrame(JFrame parent, String[] values) {
        setTitle("Data Mahasiswa");
        setSize(420, 340);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel panel = new PanelGradient();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 24, 20, 24));

        // Judul
        JLabel lblJudul = new JLabel("Data Mahasiswa");
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblJudul.setForeground(new Color(21, 67, 96));
        lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
        lblJudul.setBorder(new EmptyBorder(0, 0, 12, 0));
        panel.add(lblJudul, BorderLayout.NORTH);

        // Card data
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 230)),
                new EmptyBorder(14, 16, 14, 16)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 4, 4, 8);

        for (int i = 0; i < KEYS.length; i++) {
            gbc.gridx = 0; gbc.gridy = i;
            JLabel k = new JLabel(KEYS[i]);
            k.setFont(new Font("SansSerif", Font.BOLD, 12));
            k.setForeground(new Color(40, 80, 120));
            k.setPreferredSize(new Dimension(120, 20));
            card.add(k, gbc);

            gbc.gridx = 1;
            JLabel sep = new JLabel(": ");
            sep.setFont(new Font("SansSerif", Font.PLAIN, 12));
            card.add(sep, gbc);

            gbc.gridx = 2;
            JLabel v = new JLabel("<html>" + values[i].replace("\n", "<br>") + "</html>");
            v.setFont(new Font("SansSerif", Font.PLAIN, 12));
            v.setForeground(new Color(30, 30, 30));
            card.add(v, gbc);
        }

        panel.add(card, BorderLayout.CENTER);

        // Tombol tutup
        JButton btnTutup = new JButton("Tutup");
        btnTutup.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnTutup.setFocusPainted(false);
        btnTutup.setBorder(new EmptyBorder(7, 20, 7, 20));
        btnTutup.addActionListener(e -> dispose());

        JPanel btnP = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10));
        btnP.setOpaque(false);
        btnP.add(btnTutup);
        panel.add(btnP, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}