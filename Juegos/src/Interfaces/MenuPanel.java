package Interfaces;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JButton btnRanking3EnRaya;
    private JButton btnRankingPiedraPapelTijera;
    private JButton btnHistorial3EnRaya;
    private JButton btnHistorialPiedraPapelTijera;
    private JButton btnJugar3EnRaya;
    private JButton btnJugarPiedraPapelTijera;
    private JButton btnPerfil;

    public MenuPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        // Botón para ir al perfil (arriba a la izquierda)
        btnPerfil = createButton("Perfil");
        btnPerfil.setPreferredSize(new Dimension(150, 40));
        add(btnPerfil, BorderLayout.NORTH);

        // Panel para los botones de ranking y jugar
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setOpaque(false);
        add(centerPanel, BorderLayout.CENTER);

        // Botones de ranking y jugar para 3 en raya
        btnRanking3EnRaya = createButton("Ranking 3 en Raya");
        btnHistorial3EnRaya = createButton("Historial 3 en Raya");
        btnJugar3EnRaya = createButton("Jugar 3 en Raya");
        centerPanel.add(btnRanking3EnRaya);
        centerPanel.add(btnHistorial3EnRaya);
        centerPanel.add(btnJugar3EnRaya);

        // Botones de ranking y jugar para piedra, papel o tijera
        btnRankingPiedraPapelTijera = createButton("Ranking Piedra, Papel, Tijera");
        btnHistorialPiedraPapelTijera = createButton("Historial Piedra, Papel, Tijera");
        btnJugarPiedraPapelTijera = createButton("Jugar Piedra, Papel, Tijera");
        centerPanel.add(btnRankingPiedraPapelTijera);
        centerPanel.add(btnHistorialPiedraPapelTijera);
        centerPanel.add(btnJugarPiedraPapelTijera);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.GRAY);
        button.setFocusPainted(false);
        return button;
    }
}
