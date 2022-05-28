package ru.vsu.cs.buchnev;

import ru.vsu.cs.buchnev.bst.avl.AVLTreeMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public interface TreeMapStudents {
    //Map<String,Map<String,String>> readCSVFile(String name) throws FileNotFoundException;
    //String[][] toMatrix();
    //String[][] mapInsidetoMatrix(String key);
    Map<String,Map<String,String>> getTree();
    default Map<String, Map<String, String>> readCSVFile(String name) throws FileNotFoundException {
        //Map<String, Map<String,String>> map = new TreeMap<>();
        Scanner sc = new Scanner(new FileInputStream("hide.csv"));
        while (sc.hasNext()){
            String[] a = sc.nextLine().split(";");
            if (getTree().containsKey(a[1])){
                getTree().get(a[1]).put(a[0],a[2]);
            }
            else {
                Map<String, String> mp;
                if(getTree() instanceof TreeMap) {
                    mp = new TreeMap<>();
                }
                else{
                    mp = new AVLTreeMap<>();
                }

                mp.put(a[0], a[2]);
                getTree().put(a[1], mp);
            }

        }
        return getTree();
    }
    
    default String[][] toMatrix() {
        String[][] matrix = new String[getTree().size()][1];
        int i = 0;
        for (String key: getTree().keySet()){
            matrix[i][0] = key;
            i++;
        }
        return matrix;
    }
    
    default String[][] mapInsidetoMatrix(String key) {
        String[][] matrix = new String[getTree().size()][1];
        Map<String,String> mapInside = getTree().get(key);
        String[][] result  = new String[mapInside.size()+2][2];
        result[1][0] = "Предмет";
        result[1][1] = "Оценка";
        result[0][0] = key.split(" ")[0];
        result[0][1] = key.split(" ")[1] + " " +  key.split(" ")[2] ;
        int i=2;
        for (String item: mapInside.keySet()){
            if (key != null) {
                result[i][0] = item;
                result[i][1] = mapInside.get(item);
                i++;
            }
        }
        return result;
    }
}
