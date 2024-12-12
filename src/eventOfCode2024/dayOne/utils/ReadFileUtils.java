package eventOfCode2024.dayOne.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtils {


  /**
   * Reads file from directory
   * The resulted List of String will be converted into a list of Long.
   * @param fileName
   * @return List of fileInput as Long
   */
  public static List<Long> readFile(String fileName) {
    try {
      Path filePath = Path.of("C:/workarea/Workspace/advent-of-code/src/eventOfCode2024/dayOne/lists/" + fileName);
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
