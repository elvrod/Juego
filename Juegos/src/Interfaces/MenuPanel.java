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
    private JButton btnCerrarSesion;
    private String currentUser;
    private RankingPPT rankingPPT;
    private RankingTicTacToe rankingTicTacToe;
    private Historial historialPPT;
    private Historial historialTicTacToe;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MenuPanel(String currentUser, RankingPPT rankingPPT, RankingTicTacToe rankingTicTacToe, Historial historialPPT, Historial historialTicTacToe, CardLayout cardLayout, JPanel mainPanel) {
        this.currentUser = currentUser;
        this.rankingPPT = rankingPPT;
        this.rankingTicTacToe = rankingTicTacToe;
        this.historialPPT = historialPPT;
        this.historialTicTacToe = historialTicTacToe;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

        // Botón para ir al perfil (arriba a la izquierda)
        btnPerfil = createButton("Perfil");
        btnPerfil.setPreferredSize(new Dimension(150, 40));
        btnPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PerfilPanel perfilPanel = new PerfilPanel(currentUser, rankingPPT, rankingTicTacToe, cardLayout, mainPanel);
                mainPanel.add(perfilPanel, "perfil");
                cardLayout.show(mainPanel, "perfil");
            }
        });
        add(btnPerfil, BorderLayout.NORTH);

        // Botón para cerrar sesión (abajo al centro)
        btnCerrarSesion = createButton("Cerrar Sesión");
        btnCerrarSesion.setPreferredSize(new Dimension(150, 40));
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "login");
            }
        });
        add(btnCerrarSesion, BorderLayout.SOUTH);

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
                TicTacToe tictactoe = new TicTacToe(currentUser, rankingTicTacToe, historialTicTacToe);
                tictactoe.setVisible(true);
            }
        });
        btnHistorial3EnRaya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistorialPanel historialPanel = new HistorialPanel("Historial 3 en Raya", historialTicTacToe, cardLayout, mainPanel);
                mainPanel.add(historialPanel, "historialTicTacToe");
                cardLayout.show(mainPanel, "historialTicTacToe");
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
                PiedraPapelTijera juego = new PiedraPapelTijera(currentUser, rankingPPT, historialPPT);
                juego.setVisible(true);
            }
        });
        btnHistorialPiedraPapelTijera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistorialPanel historialPanel = new HistorialPanel("Historial Piedra, Papel, Tijera", historialPPT, cardLayout, mainPanel);
                mainPanel.add(historialPanel, "historialPPT");
                cardLayout.show(mainPanel, "historialPPT");
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
        btnHistorial3EnRaya.setEnabled(true);
        btnHistorialPiedraPapelTijera.setEnabled(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.GRAY);
        button.setFocusPainted(false);
        return button;
    }
}
