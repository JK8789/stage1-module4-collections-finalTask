package com.epam.mjc.collections.combined;

import java.util.*;

public class LessonsGetter {
    public Set<String> getLessons(Map<String, List<String>> timetable) {
        Set<String> lessons = new HashSet<>();
        for (Map.Entry<String, List<String>> element : timetable.entrySet()) {
            lessons.addAll(element.getValue());
        }
        return lessons;
    }

    public static void main(String[] args) {
        Map<String, List<String>> schedule = new HashMap<>();
        schedule.put("Modnay", Collections.singletonList("English"));
        schedule.put("Tuesday", Collections.singletonList("Mathematics"));
        schedule.put("Wednesday", Collections.singletonList("English, Chemistry"));
        LessonsGetter lessonsGetter = new LessonsGetter();
        System.out.println(lessonsGetter.getLessons(schedule));
    }
}
