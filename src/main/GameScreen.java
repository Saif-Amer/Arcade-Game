package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GameScreen {

    public class GamePanel extends JPanel implements Runnable {

        //Screen Settings
        final int originalTileSize = 16; //making the sprites 16x16
        // Increase Scale so the sprite isnt tiny.
        final int scale = 3;

        public final int TileSize = this.originalTileSize * this.scale;

        final int MaxScreenCol = 16; //Amount of Columns in the screen
        final int MaxScreenRow = 12; // Amount of Rows in the screen
        final int ScreenWidth = this.TileSize * this.MaxScreenCol; //768 Pixels
        final int ScreenHeight = this.TileSize * this.MaxScreenRow; //576 Pixels

        //FPS
        int FPS = 60;
        //Calls the controls from the controls file
        Controls control = new Controls();
        // Calls the run function, basically starts the game clock (FPS)
        Thread gameThread;
        // Calls the Player from Entity
        Player player = new Player(this, this.control);
        //player's default position
        int PlayerX = 100;
        int PlayerY = 100;
        // Speed of the Player
        int PlayerSpeed = 4;

        public GamePanel() {

            this.setPreferredSize(new Dimension(this.ScreenWidth, this.ScreenHeight));
            this.setBackground(Color.white);
            //All drawings will be done in an offscreen buffer (Improves preformance)
            this.setDoubleBuffered(true);

            this.addKeyListener(this.control);
            // GamePanel can be focused on getting keyboard inputs
            this.setFocusable(true);
        }

        public void startGameThread() {
            this.gameThread = new Thread(this);
            this.gameThread.start();

        }

        @Override
        public void run() {
            double drawInterval = 1000000000 / this.FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            while (this.gameThread != null) {
                // Checks current time
                currentTime = System.nanoTime();
                // subtracts this time from last time, to see how much time has passed
                delta += (currentTime - lastTime) / drawInterval;
                /*
                 * every loop drawInterval is added to delta, once delta reaches
                 * the draw interval, it updates and repaints
                 */
                lastTime = currentTime;
                if (delta >= 1) {
                    this.update();
                    this.repaint();
                    delta--;

                }

            }

        }

        // updates player poistion with Keyboard inputs
        public void update() {
            this.player.update();

        }

        // java made graphics
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            Graphics2D g2 = (Graphics2D) g;
            this.player.draw(g2);

            //Helps with resource management
            g2.dispose();
        }

    }

}
