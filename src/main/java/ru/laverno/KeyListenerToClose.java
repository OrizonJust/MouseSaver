package ru.laverno;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerToClose implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Application.exit = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.exit(0);
    }
}
