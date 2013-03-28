/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author root
 */
public class SoloNumeros extends KeyAdapter {

    public SoloNumeros() {
        super();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(!Character.isDigit(e.getKeyChar()))
            e.consume();
    }
}