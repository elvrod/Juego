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

    public PiedraPapelTijera() {
        setTitle("Piedra, Papel, Tijera");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        resultadoLabel = new JLabel("", SwingConstants.CENTER);
        add(resultadoLabel);

        piedraButton = new JButton("Piedra");
        papelButton = new JButton("Papel");
        tijeraButton = new JButton("Tijera");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(piedraButton);
        buttonPanel.add(papelButton);
        buttonPanel.add(tijeraButton);
        add(buttonPanel);

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
    }

    private String determinarGanador(String jugadaJugador, String jugadaMaquina) {
        if (jugadaJugador.equals(jugadaMaquina)) {
            return "¡Empate!";
        } else if ((jugadaJugador.equals("PIEDRA") && jugadaMaquina.equals("TIJERA")) ||
                   (jugadaJugador.equals("PAPEL") && jugadaMaquina.equals("PIEDRA")) ||
                   (jugadaJugador.equals("TIJERA") && jugadaMaquina.equals("PAPEL"))) {
            return "¡Ganaste!";
        } else {
            return "¡Perdiste!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PiedraPapelTijera().setVisible(true);
            }
        });
    }
}