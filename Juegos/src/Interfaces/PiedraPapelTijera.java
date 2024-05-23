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
        this.currentUser = currentUser;
        this.rankingPPT = rankingPPT;
        this.historialPPT = historialPPT;

        setTitle("Piedra, Papel, Tijera");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

    public PiedraPapelTijera() {
		// TODO Auto-generated constructor stub
	}

	private void jugar(String jugadaJugador) {
        String[] jugadas = {"PIEDRA", "PAPEL", "TIJERA"};
        String jugadaMaquina = jugadas[random.nextInt(jugadas.length)];

        String resultado = determinarGanador(jugadaJugador, jugadaMaquina);
        resultadoLabel.setText(resultado);
        historialPPT.agregarPartida(currentUser + " vs M�quina: " + resultado);
    }

    private String determinarGanador(String jugadaJugador, String jugadaMaquina) {
        if (jugadaJugador.equals(jugadaMaquina)) {
            return "�Empate!";
        } else if ((jugadaJugador.equals("PIEDRA") && jugadaMaquina.equals("TIJERA")) ||
                   (jugadaJugador.equals("PAPEL") && jugadaMaquina.equals("PIEDRA")) ||
                   (jugadaJugador.equals("TIJERA") && jugadaMaquina.equals("PAPEL"))) {
            rankingPPT.actualizarPuntos(currentUser, 3);
            return "�" + currentUser + " gana!";
        } else {
            return "�La m�quina gana!";
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
