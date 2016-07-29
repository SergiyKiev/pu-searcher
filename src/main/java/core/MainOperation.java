package core;

import java.io.IOException;

import excelOperations.ExcelTable;
import productOperation.ProductInstance;

public class MainOperation {

	public static void main(String[] args) {
	   
		 
		String[] productName = null;
		try {
			productName = ExcelTable.getProductNameList();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		 for (int i=0;i<productName.length;i++)	{
			   
                  ProductInstance product = new ProductInstance(productName[i]);
                  String d = product.getDate();
                  String n = product.getVersion();
                  System.out.println(productName[i]);
                  System.out.println(n);
                  System.out.println(d);
               
		 }
	}

}
