package products;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class OpenOffice {
	
	
	static String lastVersion() {	
		Document doc;
		String  contentOpenOffice = null;
		try {
			doc = Jsoup.connect("http://www.openoffice.org/download/").timeout(5000).get();
			contentOpenOffice = doc.select("div#announce a").text();
		} catch (IOException e) {
			e.getMessage();
		}  
	    
		if (contentOpenOffice != null){
            int start = 18;
            int end = 23;
            return contentOpenOffice.substring(start, end);
     
		} else {
			return "connection errore";
		}
	}
     
	public static  String getLastVersion(){	
    	return lastVersion();
     }
    
	
	static String releasedDate() {
			
		Document doc;
		String  connectOpenOffice = null;
		String versiontmp = OpenOffice.getLastVersion();
		String url = ("https://cwiki.apache.org/confluence/display/OOOUSERS/AOO+"+versiontmp+"+Release+Notes");
		try {
			doc = Jsoup.connect(url).timeout(5000).get();
			connectOpenOffice = doc.select("a[class=last-modified]").text();
		} catch (IOException e) {
			e.getMessage();
		}  
	    
		if (connectOpenOffice != null){
            return connectOpenOffice;
     
		} else {
			return  "N/A";
		}
	}
	
	public static String getReleasedDate(){
		return releasedDate();
	}
	
}
