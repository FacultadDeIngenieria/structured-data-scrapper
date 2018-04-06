package austral.dpoi.scrapping;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ScraperTest {

  @Test public void testScrapFileLaNacion() throws IOException {
    final File file = new File("src/test/resources/pages/lanacion-2123329.html");
    final String output = new Scraper().scrap(file);
    //    assertEquals("Expected json-ld", "");
  }

  @Test public void testScrapFileImdb() throws IOException {
    final File file = new File("src/test/resources/pages/imdb-tt0111161.html");
    final String output = new Scraper().scrap(file);
    //    assertEquals("Expected json-ld", "");
    System.out.println("output = " + output);
  }
}
