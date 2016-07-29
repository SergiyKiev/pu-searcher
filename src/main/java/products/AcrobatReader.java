package products;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AcrobatReader {
	
	private static String lastVersion() {
		
		Document doc;
		Elements  contentAcrobatReader = null;
		String version = null;
		try {
			  doc = Jsoup.connect("http://www.adobe.com/devnet-docs/acrobatetk/tools/ReleaseNotes/index.html").timeout(5000).get();
 			  contentAcrobatReader = doc.select("a[href*=11/]");	
		    } catch (IOException e) {
			  e.printStackTrace();
		    }  
		for (Element e : contentAcrobatReader) {				 
	        if (e.text().contains("Planned update")) {
	        	version = e.select("a").text();
	        	break;      
	        }
	    }
		if (contentAcrobatReader != null){
			 int start = 0;
             int end = version.lastIndexOf("P")-1;
             return version.substring(start, end); 
		   } else {
			   return "connection errore";
		   }
	    }
	
	public static String getLastVersion(){
		return lastVersion();
	}
	
	private static String releasedDate() {
		
		
		Document doc;
		String  connectAcrobatReader = null;
		try {
			doc = Jsoup.connect("http://www.adobe.com/devnet-docs/acrobatetk/tools/ReleaseNotes/index.html").timeout(5000).get();
			 connectAcrobatReader = doc.select("a[href*=11/]").get(0).text();
		} catch (IOException e) {
			e.getMessage();
		}  
	    
		if (connectAcrobatReader != null){
              int start = connectAcrobatReader.indexOf(",")+2;
              int end = connectAcrobatReader.length();
              char buf[] = new char[end - start];
              connectAcrobatReader.getChars(start, end, buf, 0);  
              return String.valueOf(buf);
		   } else {
			   return "N/A";
		   }
	}
	
	public static String getReleasedDate(){
		return  releasedDate();
	}
	
}

