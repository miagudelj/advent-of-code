package eventOfCode2024.dayOne;

import java.util.List;

import eventOfCode2024.dayOne.service.DistanceCalculatorService;
import eventOfCode2024.dayOne.service.SimilarityCalculatorService;
import eventOfCode2024.dayOne.utils.ReadFileUtils;

public class RunDayOne {

  public static void main(String[] args) {
    List<Long> list1 = ReadFileUtils.readFile("listOne.txt");
    List<Long> list2 = ReadFileUtils.readFile("listTwo.txt");

    // Part 1
    DistanceCalculatorService distanceService = new DistanceCalculatorService();

    long totalDistacne = distanceService.calculateSum(list1, list2);

    System.out.println("Part 1 - The total distance between my two lists is " + totalDistacne);

    // Part 2
    SimilarityCalculatorService similarityService = new SimilarityCalculatorService();

    long totalSimilarities = similarityService.calculateSum(list1, list2);
    System.out.println("Part 2 - The total similarity between my two lists is " + totalSimilarities);
  }
}
