import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
    public static void main(String[] args) {

    }

  public static String puzzleMaker(String input) {
    String puzzle = "";
    char[] splitInput = input.toCharArray();
    for (int i=0; i < splitInput.length; i++){
      if (splitInput[i] == ('a')) {
        puzzle += "_";
      } else {
        puzzle += splitInput[i];
      }
    }
    return puzzle;
  }
}
