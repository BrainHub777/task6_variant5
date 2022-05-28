package ru.vsu.cs.buchnev;

import ru.vsu.cs.buchnev.bst.avl.AVLTreeMap;

import java.util.Map;
import java.util.TreeMap;

public class DefaultTreeMapStudents implements TreeMapStudents {
    private final Map<String, Map<String,String>> map = new TreeMap<>();

    @Override
    public Map<String, Map<String, String>> getTree() {
        return map;
    }
}
