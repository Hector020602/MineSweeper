/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Timer;
import javax.swing.border.*;

/**
 *
 * @author victor
 */
public class UpperPanel extends javax.swing.JPanel implements TimerInterface, FlagInterface {

    
    private Timer timer;
    private int seconds;
    private InitGamer initGamer;
    private int flagRemaining;
    
    public UpperPanel() {
        initComponents();
        myInit();
    }
    
    public void setInitGamer(InitGamer initGamer) {
        this.initGamer = initGamer;
    }
    
    public void resetTimer() {
        seconds = 0;
        timer.stop();
        updateTimerLabel(0, 0);
        //timer.restart();
    }
    
    private void myInit() {
        resetFlagRemaining();
        buttonSmile.setFocusable(false);
        Border border = labelTime.getBorder();
        Border margin = new EmptyBorder(10,5,5,5);
        labelTime.setBorder(new CompoundBorder(border, margin)); 
        labelRemaining.setBorder(new CompoundBorder(border, margin));
        seconds = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tick();
            }
        });
        // startTimer();
    }

    public void resetFlagRemaining() {
        flagRemaining = Config.instance.getNumBombs();
        updateLabelRemaining();
    }
    
    @Override
    public void startTimer() {
        if (!timer.isRunning()) {
            timer.start();
        }
    }
    
    @Override
    public void stopTimer() {
        timer.stop();
    }
    
    private void tick() {
        seconds ++;
        int min = seconds / 60;
        int sec = seconds % 60;
        updateTimerLabel(min, sec);  
    }
    
    public void updateTimerLabel(int min, int sec) {
        String timeStr = String.format("%02d:%02d", min, sec);
        labelTime.setText(timeStr);
    }
    
    public void updateLabelRemaining() {
        String remainingStr = String.format("%03d", flagRemaining);
        labelRemaining.setText(remainingStr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLeft = new javax.swing.JPanel();
        labelRemaining = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        labelTime = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        buttonSmile = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(new java.awt.BorderLayout());

        panelLeft.setBackground(new java.awt.Color(204, 255, 204));
        panelLeft.setMinimumSize(new java.awt.Dimension(100, 89));
        panelLeft.setPreferredSize(new java.awt.Dimension(100, 100));
        panelLeft.setLayout(new java.awt.GridBagLayout());

        labelRemaining.setBackground(new java.awt.Color(0, 0, 0));
        labelRemaining.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        labelRemaining.setForeground(new java.awt.Color(255, 51, 51));
        labelRemaining.setText("999");
        labelRemaining.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 20, 33, 20);
        panelLeft.add(labelRemaining, gridBagConstraints);

        add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelRight.setBackground(new java.awt.Color(204, 255, 255));
        panelRight.setMinimumSize(new java.awt.Dimension(100, 84));
        panelRight.setPreferredSize(new java.awt.Dimension(100, 100));
        panelRight.setLayout(new java.awt.GridBagLayout());

        labelTime.setBackground(new java.awt.Color(0, 0, 0));
        labelTime.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        labelTime.setForeground(new java.awt.Color(255, 51, 51));
        labelTime.setText("00:00");
        labelTime.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 23, 31, 31);
        panelRight.add(labelTime, gridBagConstraints);

        add(panelRight, java.awt.BorderLayout.LINE_END);

        panelCenter.setBackground(new java.awt.Color(255, 255, 204));
        panelCenter.setLayout(new java.awt.GridBagLayout());

        buttonSmile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smiley.png"))); // NOI18N
        buttonSmile.setAlignmentX(0.5F);
        buttonSmile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSmile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSmileActionPerformed(evt);
            }
        });
        panelCenter.add(buttonSmile, new java.awt.GridBagConstraints());

        add(panelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSmileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSmileActionPerformed
        initGamer.initGame();
        seconds = 0;
        timer.restart();
        updateTimerLabel(0, 0);        
        resetFlagRemaining();
    }//GEN-LAST:event_buttonSmileActionPerformed


    @Override
    public void incrementFlagRemaining() {
        flagRemaining ++;
        updateLabelRemaining();
    }

    @Override
    public void decrementFlagRemaining() {
        flagRemaining --;
        updateLabelRemaining();
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSmile;
    private javax.swing.JLabel labelRemaining;
    private javax.swing.JLabel labelTime;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    // End of variables declaration//GEN-END:variables


   
}
