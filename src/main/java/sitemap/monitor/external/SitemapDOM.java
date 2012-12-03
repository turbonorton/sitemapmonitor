package sitemap.monitor.external;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sitemap.monitor.domain.SitemapEntry;
import sitemap.monitor.util.Utils;

public class SitemapDOM {

     private static final String URL_ELEMENT = "url";
     private static final String LASTMOD_ELEMENT = "lastmod";
     
	 private URL toRead;
	 
	 public SitemapDOM(URL location) {
		 this.toRead = location;
	 }
	 
	 public List<SitemapEntry> build() {
		 Document doc = parse();
		 Element root = doc.getRootElement();
		 return populate(root);
	 }
	 
	 protected Document parse() {
		 	try {
		 		SAXReader reader = new SAXReader();
		 		Document document = reader.read(toRead);
		 		return document;
		 	} catch (DocumentException docEx) {
		 		throw new SitemapNotAvailableException(docEx);
		 	}
	 } 
	 
	 protected List<SitemapEntry> populate(Element root) {
		 List<SitemapEntry> result = new ArrayList<SitemapEntry>();
		 
		 for (Object url : root.elements(URL_ELEMENT)) {
			 Element urlElement = (Element) url;
			 Element lastmod = urlElement.element(LASTMOD_ELEMENT);
			 result.add(new SitemapEntry(Utils.Strings.safe(lastmod.getData())));
		 }
		 
		 return result;
	 }
}
