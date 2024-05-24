package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilPanel extends JPanel {
    private String currentUser;
    private RankingPPT rankingPPT;
    private RankingTicTacToe rankingTicTacToe;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public PerfilPanel(String currentUser, RankingPPT rankingPPT, RankingTicTacToe rankingTicTacToe, CardLayout cardLayout, JPanel mainPanel) {
        this.currentUser = currentUser;
        this.rankingPPT = rankingPPT;
        this.rankingTicTacToe = rankingTicTacToe;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(0, 204, 153));

        JLabel lblNombre = new JLabel("Nombre: " + currentUser);
        lblNombre.setBackground(new Color(204, 255, 204));
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        lblNombre.setAlignmentX(CENTER_ALIGNMENT);

        JLabel lblRankingPPT = new JLabel("Ranking Piedra, Papel, Tijera: Posicion " + obtenerPosicionRanking(rankingPPT, currentUser));
        lblRankingPPT.setFont(new Font("Arial", Font.PLAIN, 14));
        lblRankingPPT.setAlignmentX(CENTER_ALIGNMENT);

        JLabel lblRankingTicTacToe = new JLabel("Ranking 3 en Raya: Posicion " + obtenerPosicionRanking(rankingTicTacToe, currentUser));
        lblRankingTicTacToe.setFont(new Font("Arial", Font.PLAIN, 14));
        lblRankingTicTacToe.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(204, 255, 204));
        btnVolver.setAlignmentX(CENTER_ALIGNMENT);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });

        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setBackground(new Color(204, 255, 204));
        btnCerrarSesion.setAlignmentX(CENTER_ALIGNMENT);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "login");
            }
        });

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lblNombre);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lblRankingPPT);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lblRankingTicTacToe);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnVolver);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(btnCerrarSesion);
    }

    private int obtenerPosicionRanking(Ranking ranking, String usuario) {
        return ranking.obtenerPosicion(usuario);
    }
}
