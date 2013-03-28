/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class MaximaLongitud extends KeyAdapter {
    private int MAX_LENGTH;
    public MaximaLongitud(int longitud) {
        super();
        MAX_LENGTH= longitud;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(((JTextField)e.getSource()).getText().length() + 1 > MAX_LENGTH)
            e.consume();
    }
}
