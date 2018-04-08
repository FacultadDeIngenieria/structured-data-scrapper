package austral.dpoi.scrapping;

import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.utils.JsonUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class ScraperTest {

  @Test public void testScrapFileJsonLdLaNacion() throws IOException, JsonLdError {
    // Example: https://www.lanacion.com.ar/2123329
    assertFile("jsonld-lanacion-2123329.html", "https://www.lanacion.com.ar/2123329");
  }

  @Test public void testScrapFileMicrodataImdb() throws IOException, JsonLdError {
    // Example: http://www.imdb.com/title/tt5580390
    assertFile("microdata-imdb-tt0111161.html", "http://www.imdb.com/title/tt5580390");
  }

  @Test public void testScrapFileMicrodataSimple() throws IOException, JsonLdError {
    assertFile("microdata-simple.html", "");
  }

  @Test public void testScrapFileMicrodataAdvanced() throws IOException, JsonLdError {
    assertFile("microdata-advanced.html", "");
  }

  @SuppressWarnings("unchecked")
  private void assertFile(final String candidate, final String baseUri) throws IOException, JsonLdError {
    final File file = new File(TEST_RESOURCES + candidate);
    final String output = new Scraper().scrap(file, baseUri);

    final Object actual = JsonUtils.fromString(output);

    final FileInputStream golden = new FileInputStream(TEST_RESOURCES + candidate.replace(".html", ".json"));
    final Object expected = JsonUtils.fromInputStream(golden);

    if (expected instanceof List) {
      assertThat((List<Object>) expected).containsOnlyElementsOf((List<?>) actual);
    }
    else if(expected instanceof Map) {
      assertThat((Map<String, Object>) expected).containsAllEntriesOf((Map<String, ?>) expected);
    }
  }

  private static final String TEST_RESOURCES = "src/test/resources/pages/";
}
