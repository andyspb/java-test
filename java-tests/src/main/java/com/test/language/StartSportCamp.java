package com.test.language;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StartSportCamp {
  public static void main(String... args) {

    Collection<SportsCamp> sport =
        Arrays.asList(
            new SportsCamp("Ivan", 5),
            new SportsCamp(null, 15),
            new SportsCamp("Petr", 7),
            new SportsCamp("Ira", 10),
            new SportsCamp("Ivan", 17));
    String max_name =
        sport.stream()
            .filter((p) -> p.getName() != null)
            .max((p1, p2) -> p1.getDay().compareTo(p2.getDay()))
            .get()
            .getName();
    System.out.println("max Name=" + max_name);

    String min_name =
        sport.stream()
            .filter((p) -> p.getName() != null)
            .min((p1, p2) -> p1.getDay().compareTo(p2.getDay()))
            .get()
            .getName();
    System.out.println("min Name=" + min_name);

    long countName =
        sport.stream().filter((p) -> p.getName() != null && p.getName().equals("Ivan")).count();
    System.out.println("countName=" + countName);

    long countNameParallel =
        sport
            .parallelStream()
            .filter((p) -> p.getName() != null && p.getName().equals("Ivan"))
            .count();
    System.out.println("countNameParallel=" + countNameParallel);

    List<SportsCamp> onlyI =
        sport.stream()
            .filter(p -> p.getName() != null && p.getName().startsWith("I"))
            .collect(Collectors.toList());
    System.out.println("SIZE=" + onlyI.size());

    String campPeople =
        sport.stream()
            .filter(p -> p.getName() != null)
            .map(SportsCamp::getName)
            .collect(Collectors.joining(" and ", "In camp ", " rest all days."));
    System.out.println(campPeople);

    Integer daySum =
        sport.stream().reduce(0, (sum, p) -> sum += p.getDay(), (sum1, sum2) -> sum1 + sum2);
    System.out.println("DaySize=" + daySum);

    Collection<StringBuilder> list =
        Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));

    list.stream().forEachOrdered((p) -> p.append("_new")); // list - �������� [a1_new, a2_new,
    // a3_new]

    list.stream().forEach(System.out::println);

    List<StringBuilder> newList =
        list.stream().peek((p) -> p.append("_new")).collect(Collectors.toList());
  }
}
