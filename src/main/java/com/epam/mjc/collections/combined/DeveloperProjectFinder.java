package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> listOfProj = new ArrayList<>();
        for (Map.Entry<String, Set<String>> e : projects.entrySet()) {
            if (e.getValue().contains(developer)) {
                listOfProj.add(e.getKey());
            }
        }
        listOfProj.sort(Comparator.comparing(String::length));
        Collections.reverse(listOfProj);
        for (int i = 0; i < listOfProj.size(); i++) {
            for (int j = 0; j < listOfProj.size(); j++) {
                if (listOfProj.get(i).length() == listOfProj.get(j).length()
                        && listOfProj.get(i).charAt(0) > listOfProj.get(j).charAt(0)) {
                    String s = listOfProj.get(i);
                    listOfProj.set(i, listOfProj.get(j));
                    listOfProj.set(j, s);
                }
            }
        }
        return listOfProj;
    }
}
