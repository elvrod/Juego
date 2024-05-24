package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {
        // Crear la ventana principal (JFrame)
        JFrame mainFrame = new JFrame("Ventana Principal");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);

        // Crear un CardLayout para gestionar los paneles
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Crear el panel de inicio
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.GRAY);
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setForeground(Color.GRAY);
        JButton loginButton = new JButton("Iniciar Sesion");
        loginButton.setForeground(Color.GRAY);
        loginButton.setBackground(Color.LIGHT_GRAY);
        homePanel.add(registerButton);
        homePanel.add(loginButton);

        // Crear los paneles de registro, inicio de sesion y menu principal
        RegisterPanel registerPanel = new RegisterPanel(mainPanel, cardLayout);
        Map<String, String> users = registerPanel.getUsers();

        // Inicializar rankings e historiales globales
        RankingPPT rankingPPT = new RankingPPT();
        RankingTicTacToe rankingTicTacToe = new RankingTicTacToe();
        Map<String, Historial> historialesPPT = new HashMap<>();
        Map<String, Historial> historialesTicTacToe = new HashMap<>();

        LoginPanel loginPanel = new LoginPanel(mainPanel, cardLayout, users, historialesPPT, historialesTicTacToe, rankingPPT, rankingTicTacToe);

        // Agregar los paneles al CardLayout
        mainPanel.add(homePanel, "home");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(loginPanel, "login");

        // Agregar el mainPanel al JFrame
        mainFrame.getContentPane().add(mainPanel);

        // Accion del boton para mostrar el panel de registro
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "register"));

        // Accion del boton para mostrar el panel de inicio de sesion
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        // Hacer visible la ventana principal
        mainFrame.setVisible(true);
    }
}
