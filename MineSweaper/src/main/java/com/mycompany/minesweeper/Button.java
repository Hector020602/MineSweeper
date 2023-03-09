/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minesweeper;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author alu10571073
 */
public class Button extends JButton{
    
    public static final int SIZE = 30;
    private CellState state;
    
    private class MymouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Button button = (Button) e.getSource();
            if(!SwingUtilities.isRightMouseButton(e)) {
                if (button.state == CellState.CLOSED) {
                button.setIcon(getIcon("/images/boton_pressed.jpg"));
            }
            
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            Button button = (Button) e.getSource();
            if(!SwingUtilities.isRightMouseButton(e)) {
                button.updateState();
            }
            
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
                Button button = (Button) e.getSource();
                if (SwingUtilities.isLeftMouseButton(e) && button.state == CellState.CLOSED) {
                    button.state = CellState.OPEN;
                    button.updateState();
                }else if (SwingUtilities.isRightMouseButton(e)) {
                    processRightClick(button);
                }
        }
        
    }
    
    private void processRightClick(Button button) {
        switch (button.state) {
            case CLOSED:
                button.state = CellState.FLAG;
                break;
            case FLAG:
                button.state = CellState.QUESTION;
                break;
            case QUESTION:
                button.state = CellState.CLOSED;
                break;
            default:
                break;
        }
        button.updateState();
        button.repaint();
    }
    
    private static MymouseAdapter mouseAdapter;
    
    
    public Button() {
        super();
        myInit();
    }
    
    private void myInit() {
        setMargin(new Insets(0, 0, 0, 0));
        setBorderPainted(false);
        setContentAreaFilled(false);
        if (mouseAdapter == null) {
            mouseAdapter = new MymouseAdapter();  
        }
        addMouseListener(mouseAdapter);
        state = CellState.CLOSED;
        updateState();
    }
    
    public Icon getIcon(String path) {
                Image image = new ImageIcon(getClass().getResource(path)).getImage();
                Image newimg = image.getScaledInstance(SIZE, SIZE,  java.awt.Image.SCALE_SMOOTH); 
                Icon icon = new ImageIcon(newimg);
                return icon;
        
    }
    
    public void updateState() {
        switch (state) {
            case CLOSED:
                setIcon(getIcon("/images/boton.jpg"));
                break;
            case OPEN:
                setVisible(false);
                break;
            case FLAG:
                repaint();
                break;
            case QUESTION:
                repaint();
                break;
            default:
                throw new AssertionError();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (state == CellState.FLAG) {
            Icon flag =getIcon("/images/flag.png");
            flag.paintIcon(this, g, 0, 0);
        }else if (state == CellState.QUESTION) {
            Icon question = getIcon("/images/question.png");
            question.paintIcon(this, g, 0, 0);
        }
    }
    
}
