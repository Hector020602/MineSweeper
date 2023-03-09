/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.mycompany.minesweeper;

/**
 *
 * @author alu10571073
 */
public class Config {
    
    public static Config instance  = new Config();
    private int level;
    
    
    private Config() {
        level = 0;
        
    }
    
    public int getNumRows() {
        switch (level) {
            case 0:
                return 10;
            case 1:
                return 16;
            case 2:
                return 25;
            default:
                throw new AssertionError();
        }
    }
    
    public int getNumCols() {
        switch (level) {
            case 0:
                return 10;
            case 1:
                return 16;
            case 2:
                return 25;
            default:
                throw new AssertionError();
        }
        
    }
    public int getNumBoms() {
        switch (level) {
            case 0:
                return 10;
            case 1:
                return 38;
            case 2:
                return 125;
            default:
                throw new AssertionError();
        }
        
    }
}
