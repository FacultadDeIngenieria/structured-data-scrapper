package austral.dpoi.scrapping.extractor;

import org.jsoup.nodes.Document;

import java.util.Optional;

public interface Extractor {

  /** Attempt to scrap given document. */
  Optional<String> scrap(final Document document);

}
