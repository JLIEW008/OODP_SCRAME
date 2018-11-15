package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DatabaseManager {
	
	 public static Object retrieveData(String filename) throws Exception{
	    	File f = new File(filename);
	    	Object o;
	    	if(f.exists()) {
	    		FileInputStream fi = new FileInputStream(new File(filename));
	    		ObjectInputStream oi = new ObjectInputStream(fi);
	    		Object temp = oi.readObject();
	    		fi.close();
	    		oi.close();
	    		return temp;
	    	} 
	    	return null;
	    }

	    
	    /**
	     * Overwrites the current file with the new serialized Objects.
	     * 
	     * @param a - any object to be serialized
	     * @param filename - name of .ser file to output to
	     */
	    public static void updateData(Object a, String filename) throws Exception{
	    	FileOutputStream fop=new FileOutputStream(filename);
	    	ObjectOutputStream oos=new ObjectOutputStream(fop);
	    	oos.writeObject(a);
	    	fop.close();
	    	oos.close();
	    }

}
