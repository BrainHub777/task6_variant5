package ru.vsu.cs.buchnev;

import ru.vsu.cs.buchnev.bst.avl.AVLTreeMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BSTreeMapStudents implements TreeMapStudents {
    private final Map<String,Map<String,String>> map = new AVLTreeMap();

    @Override
    public Map<String, Map<String, String>> getTree() {
        return map;
    }
}
