package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private JButton btnRanking3EnRaya;
    private JButton btnRankingPiedraPapelTijera;
    private JButton btnHistorial3EnRaya;
    private JButton btnHistorialPiedraPapelTijera;
    private JButton btnJugar3EnRaya;
    private JButton btnJugarPiedraPapelTijera;
    private JButton btnPerfil;
    private String currentUser;
    private RankingPPT rankingPPT;
    private RankingTicTacToe rankingTicTacToe;

    public MenuPanel(String currentUser, RankingPPT rankingPPT, RankingTicTacToe rankingTicTacToe) {
        this.currentUser = currentUser;
        this.rankingPPT = rankingPPT;
        this.rankingTicTacToe = rankingTicTacToe;

        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        // Botón para ir al perfil (arriba a la izquierda)
        btnPerfil = createButton("Perfil");
        btnPerfil.setPreferredSize(new Dimension(150, 40));
        add(btnPerfil, BorderLayout.NORTH);

        // Panel para los botones de ranking y jugar
        JPanel centerPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        centerPanel.setOpaque(false);
        add(centerPanel, BorderLayout.CENTER);

        // Botones de ranking y jugar para 3 en raya
        btnRanking3EnRaya = createButton("Ranking 3 en Raya");
        btnHistorial3EnRaya = createButton("Historial 3 en Raya");
        btnJugar3EnRaya = createButton("Jugar 3 en Raya");
        btnJugar3EnRaya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToe tictactoe = new TicTacToe(currentUser, rankingTicTacToe);
                tictactoe.setVisible(true);
            }
        });
        centerPanel.add(btnRanking3EnRaya);
        centerPanel.add(btnHistorial3EnRaya);
        centerPanel.add(btnJugar3EnRaya);

        // Botones de ranking y jugar para piedra, papel o tijera
        btnRankingPiedraPapelTijera = createButton("Ranking Piedra, Papel, Tijera");
        btnHistorialPiedraPapelTijera = createButton("Historial Piedra, Papel, Tijera");
        btnJugarPiedraPapelTijera = createButton("Jugar Piedra, Papel, Tijera");
        btnJugarPiedraPapelTijera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PiedraPapelTijera juego = new PiedraPapelTijera(currentUser, rankingPPT);
                juego.setVisible(true);
            }
        });
        centerPanel.add(btnRankingPiedraPapelTijera);
        centerPanel.add(btnHistorialPiedraPapelTijera);
        centerPanel.add(btnJugarPiedraPapelTijera);

        // Acciones de los botones de ranking
        btnRanking3EnRaya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, rankingTicTacToe.mostrarRanking(), "Ranking 3 en Raya", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnRankingPiedraPapelTijera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, rankingPPT.mostrarRanking(), "Ranking Piedra, Papel, Tijera", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Deshabilitar botones de historial por ahora
        btnHistorial3EnRaya.setEnabled(false);
        btnHistorialPiedraPapelTijera.setEnabled(false);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.GRAY);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 100)); // Ajusta el tamaño del botón
        return button;
    }
}
