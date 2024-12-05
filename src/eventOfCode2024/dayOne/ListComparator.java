package eventOfCode2024.dayOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListComparator {

  public static void main(String[] args) {

    ListComparator comparator = new ListComparator();
    List<Long> list1 = comparator.readFile("listOne.txt");
    List<Long> list2 = comparator.readFile("listTwo.txt");

    long totalDistacne = comparator.calculateSum(list1, list2);

    System.out.println("The total distance between my two lists is " + totalDistacne);
  }

  /**
   * Calculates sum of distances of List
   * @param list1
   * @param list2
   * @return
   */
  private long calculateSum(List<Long> list1, List<Long> list2) {
    List<Long> distances = calculateDistances(list1, list2);
    return distances.stream()
        .reduce(0L, Long::sum);
  }

  /**
   * Sorts lists in ascending order and calculates the distance between the value from both lists with the same index.
   *
   * @param list1
   * @param list2
   * @return List of distances between the numbers at the same index between the two files.
   */
  private static List<Long> calculateDistances(List<Long> list1, List<Long> list2) {
    List<Long> distances = new ArrayList<>();
    Collections.sort(list1);
    Collections.sort(list2);

    for (int i = 0; i < list1.size(); i++) {
      Long distance = list1.get(i) - list2.get(i);
      distances.add(Math.abs(distance));
    }

    return distances;
  }

  /**
   * Reads file from directory eventOfCode2024/dayOne/fileName.
   * The resulted List of String will be converted into a list of Long.
   * @param fileName
   * @return List of fileInput as Long
   */
  private List<Long> readFile(String fileName) {
    try {
      Path filePath = Path.of("src/eventOfCode2024/dayOne/" + fileName);
      String[] splitedStringValues = Files.readString(filePath).split(",");
      return convertToLongs(splitedStringValues);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static List<Long> convertToLongs(String[] splitedStringValues) {
    List<Long> stringsConvertedToLongs = new ArrayList<>();
    for (String stringValue : splitedStringValues) {
      stringsConvertedToLongs.add(Long.parseLong(stringValue));
    }
    return stringsConvertedToLongs;
  }
}
