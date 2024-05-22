package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginPanel extends JPanel {
    private Map<String, String> users; // Referencia al mapa de usuarios del RegisterPanel

    public LoginPanel(JPanel mainPanel, CardLayout cardLayout, Map<String, String> users) {
        this.users = users;

        this.setLayout(new GridBagLayout());
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
                    // Cambiar al panel del menú principal
                    cardLayout.show(mainPanel, "menu");
                } else {
                    // Mostrar un mensaje de error al usuario (credenciales incorrectas)
                    JOptionPane.showMessageDialog(LoginPanel.this, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}