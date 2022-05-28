package ru.vsu.cs.buchnev;


import util.SwingUtils;

import java.io.FileNotFoundException;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws Exception
    {
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameMain().setVisible(true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
