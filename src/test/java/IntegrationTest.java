import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void homeTest() {
      goTo("http://localhost:4567");
      assertThat(pageSource()).contains("Puzzle Maker");
    }

  @Test
    public void puzzleTest() {
      goTo("http://localhost:4567/puzzle?input=word");
      assertThat(pageSource()).contains("Puzzle");
    }
}
