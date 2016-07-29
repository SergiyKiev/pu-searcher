package products;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AcrobatReaderDC {
        	
		 private static String lastVersion() {
		
			Document doc;
			Elements  contentAcrobatReaderDC = null;
		    String versionDC = null;
			try {
				doc = Jsoup.connect("http://www.adobe.com/devnet-docs/acrobatetk/tools/ReleaseNotes/index.html").timeout(5000).get();
				contentAcrobatReaderDC  = doc.select("a[href*=DC/]");	
			} catch (IOException e) {
				e.printStackTrace();
			}  
			
			for (Element e : contentAcrobatReaderDC) {				 
		        if (e.text().contains("Planned update")) {
		        	versionDC = e.select("a").text();
		        	break;      
		        }
		    }
						
			if (contentAcrobatReaderDC != null){
	             int start = versionDC.indexOf("15");
	             int end = versionDC.lastIndexOf("P")-1;
	             return versionDC.substring(start, end);  	         
			   } else {
				   return "connection errore";
			   }						
	       }
          
		 
		  public static String getLastVersion(){     	
 				return lastVersion();
          }
		
		
		
		  private static String releasedDate() {
			
			
			Document doc;
			String  connectAcrobatReaderDC = null;

			try {
				doc = Jsoup.connect("http://www.adobe.com/devnet-docs/acrobatetk/tools/ReleaseNotes/index.html").timeout(5000).get();
				connectAcrobatReaderDC = doc.select("a[href*=DC/]").get(0).text();	
			} catch (IOException e) {
				e.getMessage();
			}  
		    
			if (connectAcrobatReaderDC != null){
	             int start = connectAcrobatReaderDC.indexOf(",")+2;
	             int end = connectAcrobatReaderDC.length();
	             char buf[] = new char[end - start];	     
	             connectAcrobatReaderDC.getChars(start, end, buf, 0);  
		         return String.valueOf(buf);     
	       
			} else {
				return "N/A";
			}		
		}
		
		  public static String getReleasedDate(){     	
				return releasedDate();
        }
		 
}
