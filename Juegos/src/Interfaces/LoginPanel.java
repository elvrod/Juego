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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear y agregar componentes para el inicio de sesión
        JLabel userLabel = new JLabel("Nombre Usuario:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(userLabel, gbc);

        JTextField userText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(userText, gbc);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(passwordText, gbc);

        JButton submitLoginButton = new JButton("Iniciar Sesión");
        submitLoginButton.setBackground(Color.LIGHT_GRAY);
        submitLoginButton.setForeground(Color.GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(submitLoginButton, gbc);

        JButton backButton = new JButton("Volver");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.GRAY);
        gbc.gridy = 3;
        this.add(backButton, gbc);

        // Acción del botón para volver al panel principal
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        // Acción del botón para iniciar sesión
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

                    // Cambiar al panel del menú principal
                    MenuPanel menuPanel = new MenuPanel(username, rankingPPT, rankingTicTacToe, historialPPT, historialTicTacToe, cardLayout, mainPanel);
                    mainPanel.add(menuPanel, "menu");
                    cardLayout.show(mainPanel, "menu");
                } else {
                    // Mostrar un mensaje de error al usuario (credenciales incorrectas)
                    JOptionPane.showMessageDialog(LoginPanel.this, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
