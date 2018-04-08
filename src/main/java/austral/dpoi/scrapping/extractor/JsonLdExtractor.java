package austral.dpoi.scrapping.extractor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

public class JsonLdExtractor implements Extractor {

  @Override public Optional<String> scrap(final Document document) {
    return findJsonLdScript(document).map(Element::data);
  }

  private Optional<Element> findJsonLdScript(Document document) {
    final Element element = document.selectFirst("script[type=application/ld+json]");
    return Optional.ofNullable(element);
  }

}
