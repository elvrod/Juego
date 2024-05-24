package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginPanel extends JPanel {
    private Map<String, String> users;
    private Map<String, Historial> historialesPPT;
    private Map<String, Historial> historialesTicTacToe;
    private RankingPPT rankingPPT;
    private RankingTicTacToe rankingTicTacToe;

    public LoginPanel(JPanel mainPanel, CardLayout cardLayout, Map<String, String> users, Map<String, Historial> historialesPPT, Map<String, Historial> historialesTicTacToe, RankingPPT rankingPPT, RankingTicTacToe rankingTicTacToe) {
        this.users = users;
        this.historialesPPT = historialesPPT;
        this.historialesTicTacToe = historialesTicTacToe;
        this.rankingPPT = rankingPPT;
        this.rankingTicTacToe = rankingTicTacToe;

        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(51, 204, 153)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear y agregar componentes para el inicio de sesion
        JLabel userLabel = new JLabel("Nombre Usuario:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(userLabel, gbc);

        JTextField userText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(userText, gbc);

        JLabel passwordLabel = new JLabel("Contrasena:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(passwordText, gbc);

        JButton submitLoginButton = new JButton("Iniciar Sesion");
        submitLoginButton.setBackground(new Color(204, 255, 204)); // Azul pastel
        submitLoginButton.setForeground(new Color(47, 79, 79)); // Texto gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(submitLoginButton, gbc);

        JButton backButton = new JButton("Volver");
        backButton.setBackground(new Color(204, 255, 204)); // Azul pastel
        backButton.setForeground(new Color(47, 79, 79)); // Texto gris oscuro
        gbc.gridy = 3;
        this.add(backButton, gbc);

        // Accion del boton para volver al panel principal
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        // Accion del boton para iniciar sesion
        submitLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Verificar las credenciales
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    // Obtener o crear el historial del usuario actual
                    Historial historialPPT = historialesPPT.computeIfAbsent(username, k -> new Historial());
                    Historial historialTicTacToe = historialesTicTacToe.computeIfAbsent(username, k -> new Historial());

                    // Cambiar al panel del menu principal
                    MenuPanel menuPanel = new MenuPanel(username, rankingPPT, rankingTicTacToe, historialPPT, historialTicTacToe, cardLayout, mainPanel);
                    mainPanel.add(menuPanel, "menu");
                    cardLayout.show(mainPanel, "menu");
                } else {
                    // Mostrar un mensaje de error al usuario (credenciales incorrectas)
                    JOptionPane.showMessageDialog(LoginPanel.this, "Nombre de usuario o contrasena incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
