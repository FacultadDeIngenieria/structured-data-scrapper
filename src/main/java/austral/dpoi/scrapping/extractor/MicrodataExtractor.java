package austral.dpoi.scrapping.extractor;

import org.jsoup.nodes.Document;

import java.util.Optional;

public class MicrodataExtractor implements Extractor {

  @Override
  public Optional<String> scrap(Document document) {
    return Optional.empty(); // todo implement
  }
}
