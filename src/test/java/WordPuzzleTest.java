import org.junit.*;
import static org.junit.Assert.*;

public class WordPuzzleTest {

  @Test
    public void WordPuzzle_replacesAWithBlank (){
      WordPuzzle wordPuzzle = new WordPuzzle();
      assertEquals("_nd", wordPuzzle.puzzleMaker("and"));
    }

  @Test
    public void WordPuzzle_replacesRestOfVowels (){
      WordPuzzle wordPuzzle = new WordPuzzle();
      assertEquals("__d__ _nd", wordPuzzle.puzzleMaker("audio end"));
    }
}
