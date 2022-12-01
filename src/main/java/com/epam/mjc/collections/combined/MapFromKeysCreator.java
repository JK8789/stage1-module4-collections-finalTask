package com.epam.mjc.collections.combined;

import java.util.*;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> mapResult = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> element : sourceMap.entrySet()) {
            if (!mapResult.containsKey(element.getKey().length())) {
                Set<String> setOfKeys = new LinkedHashSet<>();
                setOfKeys.add(element.getKey());
                mapResult.put(element.getKey().length(), setOfKeys);
            } else {
                for (Map.Entry<Integer, Set<String>> el : mapResult.entrySet()) {
                    if (element.getKey().length() == el.getKey()) {
                        Set<String> oldSetOfKey = new LinkedHashSet<>(el.getValue());
                        oldSetOfKey.add(element.getKey());
                        mapResult.put(element.getKey().length(), oldSetOfKey);
                    }
                }
            }
        }
        return mapResult;
    }

    public static void main(String[] args) {
        MapFromKeysCreator mapKey = new MapFromKeysCreator();
        Map<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("one", 1);
        sourceMap.put("two", 2);
        sourceMap.put("three", 3);
        sourceMap.put("five", 4);
        sourceMap.put("ten", 10);
        mapKey.createMap(sourceMap);
    }
}
