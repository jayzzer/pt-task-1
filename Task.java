/*
  Задача 1:
  Написать программу, которая заменяет все нули из исходного файла на 'null'.
*/

import java.io.*;

public class Task {
  public static void main(String[] args) {
    String inFile = "input.log";
    // List<String> lines = new ArrayList<String>();
    String text = "";
    String line = null;

    // Reading from file
    try {
      FileReader fileReader =
        new FileReader(inFile);

      BufferedReader bufferedReader =
        new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null) {
        text = text.concat(line).concat("\n");
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

      String result = text
        .replaceAll(" 0 ", " null ")
        .replaceAll(" 0,0 ", " null ");

      bufferedWriter.write(result);
    
      bufferedWriter.close();
    }
    catch(IOException ex) {
      System.out.println(
        "Error writing to file '"
        + outFile + "'");
    }
  }
}