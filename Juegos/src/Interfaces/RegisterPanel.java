package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RegisterPanel extends JPanel {
    private Map<String, String> users = new HashMap<>(); // Almacena los usuarios registrados (nombre de usuario, contrasena)

    public RegisterPanel(JPanel mainPanel, CardLayout cardLayout) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear y agregar componentes para el registro
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

        JButton submitRegisterButton = new JButton("Registrar");
        submitRegisterButton.setBackground(Color.LIGHT_GRAY);
        submitRegisterButton.setForeground(Color.GRAY);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(submitRegisterButton, gbc);

        JButton backButton = new JButton("Volver");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.GRAY);
        gbc.gridy = 3;
        this.add(backButton, gbc);

        // Accion del boton para volver al panel principal
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        // Accion del boton para registrar un nuevo usuario
        submitRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Verificar si el usuario ya existe
                if (users.containsKey(username)) {
                    JOptionPane.showMessageDialog(RegisterPanel.this, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Guardar el nuevo usuario
                users.put(username, password);
                JOptionPane.showMessageDialog(RegisterPanel.this, "Usuario registrado con exito", "exito", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public Map<String, String> getUsers() {
        return users;
    }
}
