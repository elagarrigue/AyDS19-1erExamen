package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Model {

  public static OnUpdateListener listener;

  public static  List<String> List = new ArrayList<>();

  public Model() {
    // init();
  }

  public void setListener(OnUpdateListener listener) {
    this.listener = listener;
  }

  public void addString(String string, LocalDateTime parsedDate) {

    // Rules
    if (string.startsWith("upper")) {
      string = string.replace("upper", "").toUpperCase();
    } else if (string.startsWith("vowels")) {
      string = string.replace("vowels", "")
              .replaceAll("a", "4")
              .replaceAll("e", "3")
              .replaceAll("i", "1")
              .replaceAll("o", "0")
              .replaceAll("u", "7")
      ;
    } else if (string.startsWith("EN")) {
      string = string.replace("EN", "")
              .replaceAll("the", "el")
              .replaceAll("cat", "park")
              .replaceAll("is", "está")
              .replaceAll("in", "en")
              .replaceAll("park", "parque")
      ;
    } else if (!string.equals("end")){
      string = "No rule " + string;
    }

    // Log string for statistics and further analysis
    try {

      // Open given file in append mode.
      BufferedWriter out = new BufferedWriter(
              new FileWriter("Logs.txt", true));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm");
      out.write(
              parsedDate.toString() + " " + string + "\n");
      out.close();
    }
    catch (IOException e) {
      System.out.println("exception occoured" + e);
    }

    List.add(string);
    if (listener != null) listener.onStringsUpdated(List);
  }


  private void init() {
    // clean file
    File file = new File("Logs.txt");
    try {
      boolean result = Files.deleteIfExists(file.toPath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
