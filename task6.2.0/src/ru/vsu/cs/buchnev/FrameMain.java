package ru.vsu.cs.buchnev;

import util.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableGameField;
    private JTable tableOutput;
    private JCheckBox checkRel;
    private JButton buttonStart;
    public final TreeMapStudents mapDef = new DefaultTreeMapStudents();
    public final TreeMapStudents mapAvl = new BSTreeMapStudents();
    public FrameMain() throws FileNotFoundException {
        this.setTitle("Оценки студентов");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        //SwingUtils.setShowMessageDefaultErrorHandler();
        JTableUtils.initJTableForArray(tableGameField, 497, false, false, false, false);
        JTableUtils.initJTableForArray(tableOutput, 248, false, false, false, false);
        tableGameField.setRowHeight(25);
        String[][] matrix = Main.matrixFromMap(checkRel.isEnabled() ? mapAvl.readCSVFile("hide.csv") :mapDef.readCSVFile("hide.csv") );
        JTableUtils.writeArrayToJTable(tableGameField, matrix);
        JTableUtils.writeArrayToJTable(tableOutput,new String[][]{{"Предмет","Оценка"}});

        this.pack();
        tableGameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String[][] matrix = JTableUtils.readStringMatrixFromJTable(tableGameField);
                int row = tableGameField.rowAtPoint(e.getPoint());
                int col = tableGameField.columnAtPoint(e.getPoint());
                if (SwingUtilities.isLeftMouseButton(e)) {
                    String FIO = matrix[row][col];
                    JTableUtils.writeArrayToJTable(tableOutput, checkRel.isEnabled() ? mapAvl.mapInsidetoMatrix(FIO) : mapDef.mapInsidetoMatrix(FIO));

                }
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] matrix = new String[0][];
                try {
                    matrix = Main.matrixFromMap(checkRel.isEnabled() ? mapAvl.readCSVFile("hide.csv") :mapDef.readCSVFile("hide.csv") );
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                JTableUtils.writeArrayToJTable(tableGameField, matrix);
            }
        });
    }
}