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
public class NumeroDecimal extends KeyAdapter {

    public NumeroDecimal() {
        super();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        String txt= ((JTextField)e.getSource()).getText();
        if(!Character.isDigit(e.getKeyChar()))
            if(e.getKeyChar() == '.') {
                if(txt.indexOf(".") >= 0)
                    e.consume();
            } else e.consume();
    }
}