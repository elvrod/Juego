package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistorialPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Historial historial;

    public HistorialPanel(String titulo, Historial historial, CardLayout cardLayout, JPanel mainPanel) {
        this.historial = historial;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setAlignmentX(CENTER_ALIGNMENT);

        JTextArea textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        for (String resultado : historial.obtenerHistorial()) {
            textArea.append(resultado + "\n");
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.setAlignmentX(CENTER_ALIGNMENT);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lblTitulo);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(scrollPane);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnVolver);
    }
}
