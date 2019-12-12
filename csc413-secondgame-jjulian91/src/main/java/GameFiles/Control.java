/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameFiles;




import GameFiles.GameObjects.Ship;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author anthony-pc
 *
 * unchanged from source files
 */
public class Control extends KeyAdapter {
    private Ship t1;
    private final int right;
    private final int left;
    private final int blastOff;


    public Control(Ship t1, int left, int right, int blastOff){
        this.t1 = t1;
        this.right = right;
        this.left = left;
        this.blastOff = blastOff;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();

        if (keyPressed == left) {
            this.t1.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.t1.toggleRightPressed();
        }
        if(keyPressed == blastOff){
            this.t1.toggleblastOffPressed();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();

        if (keyReleased  == left) {
            this.t1.unToggleLeftPressed();
        }
        if (keyReleased  == right) {
            this.t1.unToggleRightPressed();
        }
    }
}
