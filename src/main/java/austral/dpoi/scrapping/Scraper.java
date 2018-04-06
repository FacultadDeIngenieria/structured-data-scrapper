package austral.dpoi.scrapping;

import austral.dpoi.scrapping.extractor.Extractor;
import austral.dpoi.scrapping.extractor.JsonLdExtractor;
import austral.dpoi.scrapping.extractor.MicrodataExtractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scraper {

  private final List<Extractor> extractors;

  public Scraper() {
    extractors = Arrays.asList(
            new JsonLdExtractor(),
            new MicrodataExtractor()
    );
  }

  /** Scrap given file and return structured data as json-ld. */
  public String scrap(final File file) throws IOException { return scrap(Jsoup.parse(file, "UTF-8")); }

  /** Scrap given url and return structured data as json-ld. */
  public String scrap(final String url) throws IOException { return scrap(Jsoup.connect(url).get()); }

  private String scrap(final Document document) {
    final Optional<String> result =
            extractors.stream().map(extractor -> extractor.scrap(document))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .findFirst();

    return result.orElse("[]");
  }
}
