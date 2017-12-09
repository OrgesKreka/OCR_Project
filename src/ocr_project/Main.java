/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr_project;

import javax.swing.JFrame;
import ocr_gui.Application;
/**
 *
 * @author Orges
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Application obj = new Application();
        obj.setVisible(true);
        obj.setExtendedState( JFrame.MAXIMIZED_BOTH );
    }
    
}
