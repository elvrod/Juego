package Interfaces;

import javax.swing.*;
import java.awt.*;

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
        JButton loginButton = new JButton("Iniciar Sesi�n");
        loginButton.setForeground(Color.GRAY);
        loginButton.setBackground(Color.LIGHT_GRAY);
        homePanel.add(registerButton);
        homePanel.add(loginButton);

        // Crear los paneles de registro, inicio de sesi�n y men� principal
        RegisterPanel registerPanel = new RegisterPanel(mainPanel, cardLayout);
        LoginPanel loginPanel = new LoginPanel(mainPanel, cardLayout, registerPanel.getUsers());

        // Inicializar rankings e historiales
        RankingPPT rankingPPT = new RankingPPT();
        RankingTicTacToe rankingTicTacToe = new RankingTicTacToe();
        Historial historialPPT = new Historial();
        Historial historialTicTacToe = new Historial();
        
        // Obtener el usuario actual (ejemplo: solicit�ndolo al inicio)
        String currentUser = "Usuario"; // Puedes cambiar esto para obtener el usuario real
        
        // Crear el panel de men� principal
        MenuPanel menuPanel = new MenuPanel(currentUser, rankingPPT, rankingTicTacToe, historialPPT, historialTicTacToe, cardLayout, mainPanel);

        // Agregar los paneles al CardLayout
        mainPanel.add(homePanel, "home");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(menuPanel, "menu");

        // Agregar el mainPanel al JFrame
        mainFrame.getContentPane().add(mainPanel);

        // Acci�n del bot�n para mostrar el panel de registro
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "register"));

        // Acci�n del bot�n para mostrar el panel de inicio de sesi�n
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        // Hacer visible la ventana principal
        mainFrame.setVisible(true);
    }
}
