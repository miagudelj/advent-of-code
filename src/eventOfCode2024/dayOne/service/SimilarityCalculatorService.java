package eventOfCode2024.dayOne.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimilarityCalculatorService {

  /**
   * Calculates sum of similarities of List
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
   * Calculates how often the numer of list1 is present in list2
   *
   * @param list1
   * @param list2
   * @return List of occurrence of numbers from list1 in list2.
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
