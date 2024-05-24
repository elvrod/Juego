package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HistorialPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Historial historial;

    public HistorialPanel(String titulo, Historial historial, CardLayout cardLayout, JPanel mainPanel) {
        this.historial = historial;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        add(lblTitulo, BorderLayout.NORTH);

        JTextArea txtHistorial = new JTextArea();
        txtHistorial.setEditable(false);
        txtHistorial.setBackground(Color.LIGHT_GRAY);
        txtHistorial.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(txtHistorial);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(Color.LIGHT_GRAY);
        btnVolver.setForeground(Color.GRAY);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });
        add(btnVolver, BorderLayout.SOUTH);

        // Cargar el historial de partidas
        List<String> partidas = historial.obtenerHistorial();
        for (String partida : partidas) {
            txtHistorial.append(partida + "\n");
        }
    }
}
