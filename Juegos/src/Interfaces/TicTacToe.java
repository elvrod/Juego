package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame {
    private JButton[][] buttons;
    private boolean playerX;
    private int movesCount;
    private Random random;
    private String currentUser;
    private RankingTicTacToe rankingTicTacToe;
    private Historial historialTicTacToe;

    public TicTacToe(String currentUser, RankingTicTacToe rankingTicTacToe, Historial historialTicTacToe) {
        this.currentUser = currentUser;
        this.rankingTicTacToe = rankingTicTacToe;
        this.historialTicTacToe = historialTicTacToe;

        setTitle("3 en Raya");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cambiar EXIT_ON_CLOSE a DISPOSE_ON_CLOSE
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        playerX = true;
        movesCount = 0;
        random = new Random();

        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
    }

    private void resetGame() {
        playerX = true;
        movesCount = 0;
        for (int i = 0; i < 3; i++) { // Corrección aquí
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }

    private boolean checkForWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText();
            }
        }

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) ||
                (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(""))) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) ||
            (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(""))) {
            return true;
        }

        return false;
    }

    private boolean checkForDraw() {
        return movesCount == 9;
    }

    private void makeComputerMove() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!buttons[x][y].getText().equals(""));

        buttons[x][y].setText("O");
        buttons[x][y].setEnabled(false);
        movesCount++;
        if (checkForWin()) {
            JOptionPane.showMessageDialog(null, "¡La computadora gana!");
            rankingTicTacToe.actualizarPuntos(currentUser, 0);
            historialTicTacToe.agregarPartida(currentUser + " vs Máquina: La computadora gana");
            resetGame();
        } else if (checkForDraw()) {
            JOptionPane.showMessageDialog(null, "¡Empate!");
            rankingTicTacToe.actualizarPuntos(currentUser, 1);
            historialTicTacToe.agregarPartida(currentUser + " vs Máquina: Empate");
            resetGame();
        } else {
            playerX = true;
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[x][y].getText().equals("")) {
                buttons[x][y].setText("X");
                buttons[x][y].setEnabled(false);
                movesCount++;
                if (checkForWin()) {
                    JOptionPane.showMessageDialog(null, "¡" + currentUser + " gana!");
                    rankingTicTacToe.actualizarPuntos(currentUser, 3);
                    historialTicTacToe.agregarPartida(currentUser + " vs Máquina: " + currentUser + " gana");
                    resetGame();
                } else if (checkForDraw()) {
                    JOptionPane.showMessageDialog(null, "¡Empate!");
                    rankingTicTacToe.actualizarPuntos(currentUser, 1);
                    historialTicTacToe.agregarPartida(currentUser + " vs Máquina: Empate");
                    resetGame();
                } else {
                    makeComputerMove();
                }
            }
        }
    }
}
