/*
 * Classname:TestMap.java
 *
 * Version information:1
 *
 * Date:04/07/2019
 *@author : Anuradha Nitin Bhave and Himanshi Chetwani
 */

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TestMap {
    public static final int upperlimit = 1000000;
    long st, ed;
    Timestamp start, end;
    Random random = new Random();
    void forTreeMap(TreeMap<Integer, Integer> testTreeMap) {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Replace with new value");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testTreeMap.toString());
            testTreeMap.replace(i, 20 * i);
            System.out.println("After" + testTreeMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Replace old value with new value");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testTreeMap.toString());
            testTreeMap.replace(i, 20 * i, 10 * i);
            System.out.println("After" + testTreeMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    void forHashMap(HashMap<Integer, Integer> testMap) {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Put if absent");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testMap.toString());
            testMap.putIfAbsent(i, 20 * i);
            System.out.println("After" + testMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Replace old value");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testMap.toString());
            testMap.replace(i, 10 * i);
            System.out.println("After" + testMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Repacing old value with new value");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testMap.toString());
            testMap.replace(i, 10 * i, 20 * i);
            System.out.println("After" + testMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Remove");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testMap.toString());
            testMap.remove(i, 20 * i);
            System.out.println("After" + testMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);


    }

    boolean checkSize(int original, int updated) {
        return original == updated;
    }

    void printTheResult(boolean equalSize) {

        if (equalSize) {
            System.out.println("Test: put passed");
        }
    }

    void printTheResultRem(boolean equalSize) {

        if (equalSize) {
            System.out.println("Test: remove passed");
        }
    }

    void testCommonFunctions(Map testMap) {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Put");
        for (int i = 0; i < upperlimit; i++) {
            testMap.put(i, 10 * i);
            System.out.println("Current Size" + testMap.size());

        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        printTheResult(checkSize(testMap.size(), 10));
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Contains  Key");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Checking if key is conatined in the map" + testMap.containsKey(i));
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Contains Value");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Checking if value is contained in the map" + testMap.containsValue(10 * i));
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Get");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Gets the value at a specific key" + testMap.get(i));
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);

        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Adding a map to another map");
        for (int i = 0; i < upperlimit; i++) {
            System.out.println("Before" + testMap.toString());
            testMap.putAll(testMap);
            System.out.println("After" + testMap.toString());
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Removing a value from a map");
        for (int i = 0; i < upperlimit; i++) {
            testMap.remove(i);
        }

        printTheResultRem(checkSize(testMap.size(), 0));
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);


    }

    void sortHashMaps(Map<Integer, Integer> test){
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Before" + test.toString());
        TreeMap<Integer, Integer> sortMap = new TreeMap<>();
        sortMap.putAll(test);
        System.out.println("After" + sortMap.toString());
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);

    }
    void sortTreeMap(Map<Integer,Integer> test){
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        System.out.println("Before" + test.toString());
        System.out.println("After");
        test.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach
                (System.out::println);

        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }
    public static void main(String[] args) {
        TestMap object = new TestMap();
        Map<Integer, Integer> test = new HashMap<>();
        Map<Integer, Integer> testTree = new TreeMap<>();
        System.out.println("Common functionality check");
        object.testCommonFunctions(test);
        object.testCommonFunctions(testTree);
        System.out.println("Hashmap check");
        HashMap<Integer, Integer> testMap = new HashMap<>();
        object.forHashMap(testMap);
        for (int i = 0; i < upperlimit; i++) {
            testMap.put(object.random.nextInt()/1000000,i);
        }
        System.out.println("Hashmap sort");
        object.sortHashMaps(testMap);
        System.out.println("Tree Map check");
        TreeMap<Integer, Integer> testTreeMap = new TreeMap<>();
        for (int i = 0; i < upperlimit; i++) {
            testTreeMap.put(i, 10 * i);
        }
        object.forTreeMap(testTreeMap);
        for (int i = 0; i < upperlimit; i++) {
            testTreeMap.remove(i, 10 * i);
        }
        for (int i = 0; i < upperlimit; i++) {
            testTreeMap.put(object.random.nextInt()/1000000,i);
        }
        System.out.println("Treemap sort");
        object.sortTreeMap(testTreeMap);
        System.out.println("Current Size" + testTree.size());


    }

}