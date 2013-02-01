package test;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest {

	public static void main(String[] args) throws Exception {
		String urlStr = "http://www.google.com.hk/";
		
		DefaultHandler handler = new DefaultHandler(){
			
			public void startElement(String namespaceURI, String lname, String qname, Attributes attrs){
				//判断节点名称
				if(lname.equals("a") && attrs != null){
					for (int i = 0; i < attrs.getLength(); i++){
						String aname = attrs.getLocalName(i);
						if(aname.equals("href")){
							System.out.println(attrs.getValue(i));
						}
					}
				}
			}
		};
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		
		SAXParser saxParser = factory.newSAXParser();
		URL url = new URL(urlStr);
		InputStream in = url.openStream();
		
	
//		File file = new File("1.xml");
		saxParser.parse(in, handler);
		
	}
}
