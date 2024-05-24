package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PiedraPapelTijera extends JFrame {
    private JLabel resultadoLabel;
    private JButton piedraButton, papelButton, tijeraButton;
    private Random random;
    private String currentUser;
    private RankingPPT rankingPPT;
    private Historial historialPPT;

    public PiedraPapelTijera(String currentUser, RankingPPT rankingPPT, Historial historialPPT) {
    	getContentPane().setBackground(new Color(0, 204, 153));
        this.currentUser = currentUser;
        this.rankingPPT = rankingPPT;
        this.historialPPT = historialPPT;

        setTitle("Piedra, Papel, Tijera");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(4, 1));

        resultadoLabel = new JLabel("", SwingConstants.CENTER);
        getContentPane().add(resultadoLabel);

        piedraButton = new JButton("Piedra");
        piedraButton.setBackground(new Color(204, 255, 204));
        papelButton = new JButton("Papel");
        papelButton.setBackground(new Color(204, 255, 204));
        tijeraButton = new JButton("Tijera");
        tijeraButton.setBackground(new Color(204, 255, 204));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(piedraButton);
        buttonPanel.add(papelButton);
        buttonPanel.add(tijeraButton);
        getContentPane().add(buttonPanel);

        piedraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugar("PIEDRA");
            }
        });

        papelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugar("PAPEL");
            }
        });

        tijeraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugar("TIJERA");
            }
        });

        random = new Random();
    }

    private void jugar(String jugadaJugador) {
        String[] jugadas = {"PIEDRA", "PAPEL", "TIJERA"};
        String jugadaMaquina = jugadas[random.nextInt(jugadas.length)];

        String resultado = determinarGanador(jugadaJugador, jugadaMaquina);
        resultadoLabel.setText(resultado);
        historialPPT.agregarPartida(currentUser + " vs Maquina: " + resultado);
    }

    private String determinarGanador(String jugadaJugador, String jugadaMaquina) {
        if (jugadaJugador.equals(jugadaMaquina)) {
            rankingPPT.actualizarPuntos(currentUser, 1);
            return "�Empate!";
        } else if ((jugadaJugador.equals("PIEDRA") && jugadaMaquina.equals("TIJERA")) ||
                   (jugadaJugador.equals("PAPEL") && jugadaMaquina.equals("PIEDRA")) ||
                   (jugadaJugador.equals("TIJERA") && jugadaMaquina.equals("PAPEL"))) {
            rankingPPT.actualizarPuntos(currentUser, 3);
            return "�" + currentUser + " gana!";
        } else {
            return "�La maquina gana!";
        }
    }
}
