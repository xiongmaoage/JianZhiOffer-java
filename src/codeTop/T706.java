package codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T706 {
}

class MyHashMap {
    List<int[]>[] map;

    public MyHashMap() {
        map = new List[1024];
    }

    public void put(int key, int value) {
        int hash = key >> 10;
        if (map[hash] == null) {
            map[hash] = new LinkedList<>();
            map[hash].add(new int[]{key, value});
        } else {
            boolean isFound = false;
            for (int[] entry : map[hash]) {
                if (entry[0] == key) {
                    entry[1] = value;
                    isFound = true;
                }
            }
            if (!isFound) {
                map[hash].add(new int[]{key, value});
            }
        }
    }

    public int get(int key) {
        int hash = key >> 10;
        if (map[hash] != null) {
            for (int[] entry : map[hash]) {
                if (entry[0] == key) {
                    return entry[1];
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key >> 10;
        if (map[hash] != null) {
            map[hash].removeIf(entry -> entry[0] == key);
        }
    }
}
