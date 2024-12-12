package eventOfCode2024.dayOne.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimilarityCalculatorService {

  /**
   * Calculates sum of distances of List
   * @param list1
   * @param list2
   * @return
   */
  public long calculateSum(List<Long> list1, List<Long> list2) {
    List<Long> similarities = calculateSimilarity(list1, list2);
    return similarities.stream()
        .reduce(0L, Long::sum);
  }

  /**
   * Sorts lists in ascending order and calculates the distance between the value from both lists with the same index.
   *
   * @param list1
   * @param list2
   * @return List of distances between the numbers at the same index between the two files.
   */
  private static List<Long> calculateSimilarity(List<Long> list1, List<Long> list2) {
    List<Long> similarities = new ArrayList<>();
    list1.forEach(element -> {
      int appearanceInList2 = Collections.frequency(list2, element);
      similarities.add(element * appearanceInList2);
    });

    return similarities;
  }
}
