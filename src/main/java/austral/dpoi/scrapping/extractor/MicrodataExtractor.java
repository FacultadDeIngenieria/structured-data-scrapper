package austral.dpoi.scrapping.extractor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;

import java.util.Optional;

public class MicrodataExtractor implements Extractor {

  @Override
  public Optional<String> scrap(Document document) {
    final Elements element = document.select("[itemscope]:not([itemscope] [itemscope])");
    if (element != null) {
      element.traverse(new NodeVisitor() {
        @Override
        public void head(Node node, int depth) {
          System.out.println("node = " + node + " ");
        }

        @Override
        public void tail(Node node, int depth) {

        }
      });
    }
    return Optional.empty();
  }
}
