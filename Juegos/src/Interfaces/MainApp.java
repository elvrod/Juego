package Interfaces;

import javax.swing.*;
import java.awt.*;

public class MainApp {

    public static void main(String[] args) {
        // Crear la ventana principal (JFrame)
        JFrame mainFrame = new JFrame("Ventana Principal");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(434, 277);

        // Crear un CardLayout para gestionar los paneles
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Crear el panel de inicio
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.GRAY);
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBackground(Color.LIGHT_GRAY);
        registerButton.setForeground(Color.GRAY);
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setForeground(Color.GRAY);
        loginButton.setBackground(Color.LIGHT_GRAY);
        homePanel.add(registerButton);
        homePanel.add(loginButton);

        // Crear los paneles de registro, inicio de sesión y menú principal
        RegisterPanel registerPanel = new RegisterPanel(mainPanel, cardLayout);
        LoginPanel loginPanel = new LoginPanel(mainPanel, cardLayout, registerPanel.getUsers());

        // Inicializar rankings
        RankingPPT rankingPPT = new RankingPPT();
        RankingTicTacToe rankingTicTacToe = new RankingTicTacToe();
        
        // Obtener el usuario actual (ejemplo: solicitándolo al inicio)
        String currentUser = "Usuario"; // Puedes cambiar esto para obtener el usuario real
        
        // Crear el panel de menú principal
        MenuPanel menuPanel = new MenuPanel(currentUser, rankingPPT, rankingTicTacToe);

        // Agregar los paneles al CardLayout
        mainPanel.add(homePanel, "home");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(menuPanel, "menu");

        // Agregar el mainPanel al JFrame
        mainFrame.getContentPane().add(mainPanel);

        // Acción del botón para mostrar el panel de registro
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "register"));

        // Acción del botón para mostrar el panel de inicio de sesión
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        // Hacer visible la ventana principal
        mainFrame.setVisible(true);
    }
}
