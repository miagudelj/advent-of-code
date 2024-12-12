package eventOfCode2024.dayOne.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistanceCalculatorService {

  /**
   * Calculates sum of distances of List
   * @param list1
   * @param list2
   * @return
   */
  public long calculateSum(List<Long> list1, List<Long> list2) {
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
      long distance = list1.get(i) - list2.get(i);
      distances.add(Math.abs(distance));
    }

    return distances;
  }
}
