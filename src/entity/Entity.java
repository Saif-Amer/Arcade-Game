// this is the parent class for all entities in the game, like the player
package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    // Stores image files with a buffer of image data (I think?)
    public BufferedImage standLeft, moveRight, moveLeft, moveDown, moveUp, standRight,
            standDown, standUp;

    public String direction;

    public int SpriteCount = 0;
    public int SpriteNum = 1;
}
