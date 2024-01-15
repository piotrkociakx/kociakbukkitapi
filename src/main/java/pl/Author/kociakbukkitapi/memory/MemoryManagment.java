package pl.Author.kociakbukkitapi.memory;

import java.util.List;
import java.util.Map;

public class MemoryManagment {
    public static void removeStringfromMemory(String str) {
        str = null;
        runGarbageCollection();
    }

    public static void removeIntfromMemory(Integer intValue) {
        intValue = null;
        runGarbageCollection();
    }

    public static void removeListfromMemory(List<?> list) {
        list.clear();
        list = null;
        runGarbageCollection();
    }
    public static void removefromMemory(Object object) {
        object = null;
        runGarbageCollection();
    }

    public static void removeMapfromMemory(Map<?, ?> map) {
        map.clear();
        map = null;
        runGarbageCollection();
    }
    public static void runGarbageCollection() {
        System.gc();
    }
}
