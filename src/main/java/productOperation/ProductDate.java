package productOperation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProductDate {
	
	 private static Method method = null;
	 private static Class<?> c = null;
	 private static String date;
	 private static Object[] args1 = null;
	 
	
	 static String Date(String name){
	   try {
		     c = Class.forName("products." + name);
       	} catch (ClassNotFoundException e) {
		     e.printStackTrace();
	    }	
   
	   try {
		    method = c.getDeclaredMethod("getReleasedDate");
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (SecurityException e) {
		e.printStackTrace();
	}
      args1 = new Object[]{new String ()};
	 try {
		date = (String) method.invoke(args1);
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
   
	 return date;
	 }

}
