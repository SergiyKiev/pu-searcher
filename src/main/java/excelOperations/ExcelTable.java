package excelOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelTable {
	

	 
	 
	    public static XSSFSheet ProductList() throws IOException{
	   
	         
	         File excel = new File("C:/Users/maksymk/workspace/PUmanager/AllNMP_tmp.xlsx"); 
	         FileInputStream fis = new FileInputStream(excel);
	         XSSFWorkbook myBook = new XSSFWorkbook (fis); 
	         XSSFSheet mySheet = myBook.getSheet("Info");   
	         
	  
	                  myBook.close(); 
	                  fis.close(); 
	                  return mySheet;
	    }
	    
	    public static  int RowCount() throws IOException {
	    	
	       
	    	int  rowCount = 0;
	    	XSSFSheet mySheet = ProductList();
		
	    	int  rowEnd = mySheet.getLastRowNum();

            try {  
                   for (int i = 0; i <= rowEnd;i++){
	               XSSFRow row = mySheet.getRow(i); 
	               final XSSFCell cell = row.getCell(1);	   	    		       
                   if (cell.getStringCellValue()  != null){  
                	 rowCount = cell.getRowIndex(); 
	                } else { 
		               break;
	                  }	    		
                    }
  
                } catch (NullPointerException e) { 
	               e.getLocalizedMessage(); 
	            }
            return rowCount;
	    }
	    
	  
	    public static  String[] ProductVersionList() throws IOException {
	    	
	    	 XSSFSheet mySheet = ProductList();
	    	 int rowCount = RowCount();
		     String[] productVersion = new String[rowCount];
		    
		    // получаю массив с именами программ
		     for (int i = 1; i <= rowCount;i++){
		          XSSFRow row = mySheet.getRow(i);	
		          final DataFormatter df = new DataFormatter();
		          final XSSFCell cell = row.getCell(2);
		          String name = df.formatCellValue(cell);
	              productVersion[i-1] = name;
		        }   
		          return productVersion;
	    }
	  
	    public static String[] ProductNameList() throws IOException {
	       
	       int rowCount = RowCount();
	       XSSFSheet mySheet = ProductList();
    	   String[] productName = new String[rowCount];
    	   
    
	// получаю массив с версиями программ
	        for (int i=1; i <= rowCount;i++){
		        XSSFRow row = mySheet.getRow(i);	
		        final DataFormatter df = new DataFormatter();
		        final XSSFCell cell = row.getCell(1);
		        String name = df.formatCellValue(cell);
	            productName[i-1] = name;    	         
		        }
	            return productName;
        }	      	  
	  
       	
	  public static String[] getProductVersionList() throws IOException {
		  return ProductVersionList();
	    } 
	   
	  public static String[] getProductNameList() throws IOException {
		  return ProductNameList();
	    } 
	   
	}

