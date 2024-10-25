package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Controls;
import main.GameScreen.GamePanel;

public class Player extends Entity {

    GamePanel GamePanel;
    Controls Controls;

    public Player(GamePanel GamePanel, Controls Controls) {
        this.GamePanel = GamePanel;
        this.Controls = Controls;

        this.DefaultValues();
        this.getPlayerSprite();
    }

    public void DefaultValues() {
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.direction = "down";
    }

    public void getPlayerSprite() {
        try {
            this.moveRight = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/MoveManRight.png.png"));
            this.standRight = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/StandManRight.png.png"));
            this.moveLeft = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/MoveManLeft.png.png"));
            this.moveUp = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/MoveManUp.png.png"));
            this.standUp = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/StandManUp.png.png"));
            this.moveDown = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/MoveManDown.png.png"));
            this.standDown = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/StandManDown2.png.png"));
            this.standLeft = ImageIO.read(
                    this.getClass().getResourceAsStream("/player/StandManLeft.png.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (this.Controls.upPress == true || this.Controls.downPress == true
                || this.Controls.leftPress == true || this.Controls.rightPress == true) {

            if (this.Controls.upPress == true) {
                this.direction = "up";
                this.y -= this.speed;
            } else if (this.Controls.downPress == true) {
                this.direction = "down";
                this.y += this.speed;
            } else if (this.Controls.leftPress == true) {
                this.direction = "left";
                this.x -= this.speed;
            } else if (this.Controls.rightPress == true) {
                this.direction = "right";
                this.x += this.speed;
            }

            this.SpriteCount++;
            if (this.SpriteCount > 1) {
                if (this.SpriteNum == 1) {
                    this.SpriteNum = 2;
                } else if (this.SpriteNum == 2) {
                    this.SpriteNum = 1;
                }
                this.SpriteCount = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (this.direction) {
            case "up":
                if (this.SpriteNum == 1) {
                    image = this.moveUp;
                }
                if (this.SpriteNum == 2) {
                    image = this.standUp;
                }
                break;
            case "down":
                if (this.SpriteNum == 1) {
                    image = this.moveDown;
                }
                if (this.SpriteNum == 2) {
                    image = this.standDown;
                }

                break;
            case "left":
                if (this.SpriteNum == 1) {
                    image = this.moveLeft;
                }
                if (this.SpriteNum == 2) {
                    image = this.standLeft;
                }

                break;
            case "right":
                if (this.SpriteNum == 1) {
                    image = this.moveRight;
                }
                if (this.SpriteNum == 2) {
                    image = this.standRight;
                }

                break;
        }
        g2.drawImage(image, this.x, this.y, this.GamePanel.TileSize,
                this.GamePanel.TileSize, null);
    }

}
