package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

    public boolean upPress, downPress, leftPress, rightPress;

    public void keyTyped(KeyEvent e) {
        // This doesnt do anything

    }

    // this is for when the key is pressed
    public void keyPressed(KeyEvent e) {
        //returns the int associated with the key in this event
        int code = e.getKeyCode();
        // if the W key is pressed, the value is passed to code and it does the thing
        if (code == KeyEvent.VK_W) {
            this.upPress = true;

        }
        if (code == KeyEvent.VK_S) {
            this.downPress = true;

        }
        if (code == KeyEvent.VK_A) {
            this.leftPress = true;

        }
        if (code == KeyEvent.VK_D) {
            this.rightPress = true;

        }
    }

    // this is for when the key is released
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            this.upPress = false;

        }
        if (code == KeyEvent.VK_S) {
            this.downPress = false;

        }
        if (code == KeyEvent.VK_A) {
            this.leftPress = false;

        }
        if (code == KeyEvent.VK_D) {
            this.rightPress = false;

        }
    }

}
