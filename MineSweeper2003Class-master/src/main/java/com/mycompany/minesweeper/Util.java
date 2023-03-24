/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minesweeper;

import static com.mycompany.minesweeper.Button.SIZE;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author victor
 */
public class Util {
    
    public static Icon getIcon(String path) {
        Image image = new ImageIcon(Config.instance.getClass()
                        .getResource(path))
                        .getImage();
        Image newimg = image.getScaledInstance
                (SIZE, SIZE,  java.awt.Image.SCALE_SMOOTH); 
        Icon icon = new ImageIcon(newimg);
        return icon;
 
    }
    
}
