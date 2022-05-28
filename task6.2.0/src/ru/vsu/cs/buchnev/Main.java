
package ru.vsu.cs.buchnev;

import java.io.*;
import java.util.*;

import com.opencsv.CSVReader;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Map<String, Map<String,String>> mapMark = new TreeMap<>();
        Scanner sc = new Scanner(new FileInputStream("hide.csv"));
        while (sc.hasNext()){
            String[] a = sc.nextLine().split(";");
            if (mapMark.containsKey(a[1])){
                mapMark.get(a[1]).put(a[0],a[2]);
            }
            else {
                Map<String, String> mp = new TreeMap<>();
                mp.put(a[0], a[2]);
                mapMark.put(a[1], mp);
            }

        }
        printmMap(mapMark);
    }
    public static Map<String, Map<String,String>> getMap(String name) throws FileNotFoundException {
        Map<String, Map<String,String>> mapMark = new TreeMap<>();
        Scanner sc = new Scanner(new FileInputStream("hide.csv"));
        while (sc.hasNext()){
            String[] a = sc.nextLine().split(";");
            if (mapMark.containsKey(a[1])){
                mapMark.get(a[1]).put(a[0],a[2]);
            }
            else {
                Map<String, String> mp = new TreeMap<>();
                mp.put(a[0], a[2]);
                mapMark.put(a[1], mp);
            }

        }
        return mapMark;
    }
    public static void printmMap(Map<String, Map<String,String>> map){
        for (String key:map.keySet()){
            System.out.println(key);
            Map<String,String> mp = map.get(key);
            for (String k:mp.keySet()){
                String a =mp.get(k);
                System.out.println(k +":"+a);
            }
            System.out.println("--------------------------");
        }
    }
    public static String[][] matrixFromMap(Map<String, Map<String,String>> map){
        String[][] result = new String[map.keySet().size()][1];
        int i = 0;
        for (String key:map.keySet()){
            result[i][0] = key;
            i++;
        }
        return result;
    }
    public static String[][] matrixTwoFromMap(Map<String,String> a){
        return new String[1][];
    }

}