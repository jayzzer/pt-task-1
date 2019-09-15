/*
  Задача 1:
  Написать программу, которая заменяет все нули из исходного файла на 'null'.
*/

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Task {
  public static void main(String[] args) {
    String inFile = "input.log";
    List<String> lines = new ArrayList<String>();
    String line = null;

    // Reading from file
    try {
      FileReader fileReader =
        new FileReader(inFile);

      BufferedReader bufferedReader =
        new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null) {
        lines.add(line);
      }

      bufferedReader.close();
    }
    catch(FileNotFoundException ex) {
      System.out.println(
        "Unable to open file '" +
        inFile + "'");
    }
    catch(IOException ex) {
      System.out.println(
        "Error reading file '"
        + inFile + "'");
    }

    String outFile = "output.log";
    try {
      FileWriter fileWriter =
        new FileWriter(outFile);
  
      BufferedWriter bufferedWriter =
        new BufferedWriter(fileWriter);

      for (int i=0; i<lines.size(); i++) {
        String result = lines.get(i)
          .replaceAll(" 0 ", " null ")
          .replaceAll(" 0,0 ", " null ");

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      }
    
      bufferedWriter.close();
    }
    catch(IOException ex) {
      System.out.println(
        "Error writing to file '"
        + outFile + "'");
    }
  }
}