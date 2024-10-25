package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Arcade GAEM!!");

        // Adding GameScreen to the Window
        GameScreen gameScreen = new GameScreen();
        GameScreen.GamePanel gamePanel = gameScreen.new GamePanel();

        window.add(gamePanel);

        window.pack(); // Sizes the window to be fit in the layout of gamePanel
        window.setLocationRelativeTo(null); // Centers Window on Screen
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
