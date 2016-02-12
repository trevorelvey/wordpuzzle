import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
    public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/home.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/puzzle", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/puzzle.vtl");

      String input= request.queryParams("input");
      String puzzle = puzzleMaker(input);
      model.put("puzzle", puzzle);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String puzzleMaker(String input) {
    String puzzle = "";
    char[] splitInput = input.toCharArray();
    for (int i=0; i < splitInput.length; i++){
      if (splitInput[i] == ('a') || splitInput[i] == ('e') || splitInput[i] == ('i') || splitInput[i] == ('o') || splitInput[i] == ('u')) {
        puzzle += "_";
      } else {
        puzzle += splitInput[i];
      }
    }
    return puzzle;
  }
}
