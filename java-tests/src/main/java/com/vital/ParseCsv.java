package com.vital;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class ParseCsv {
  // Распарить csv файл с пациентами , и сгруппировать по имени фамилии по группам


  public static void main(String[] args) throws IOException {
    String current = new java.io.File( "." ).getCanonicalPath();
    System.out.println("Current dir:"+current);
    BufferedReader reader = new BufferedReader(new FileReader("./java-tests/target" +
        "/classes/patients" +
        ".csv"));

    String row;
    HashMap<String, Pair<String,String>> map = new HashMap<>();
    while ((row = reader.readLine()) != null) {
      if (row.startsWith("#")) continue; // skip header
      String[] data = row.split(",");
      System.out.println(Arrays.asList(data));
      map.put(data[2], new Pair<String, String>(data[0], data[1]));
    }

    for (String group: map.keySet() ) {
//      Set<Pair<String, String>> set = map.retainAll(group);
    }

  }
}
