package Commvault;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Program to perform scanning of a directory and displaying its attributes in the order of descending size of the file
 * @author Anurag
 *	
 *
 */
public class Achoudhary_quiz {
	public static void main(String args[]){
		// if command line argument are greater then 1 or less then 1
		// return message;
		if(args.length != 1){
			System.out.println("Enter the correct number of command line arguments");
			return;
		}
			
		String fileDir = args[0];
		Long startTime = System.currentTimeMillis();
		// output map to get the file mapped with its basic file attributes
		Map<String, BasicFileAttributes > outputMap = new HashMap<>();
		// Comparator object to sort the map according to values of size in descending manner 
		ValueComparator valueComp =  new ValueComparator(outputMap);
		// sortedMap = TreeMap to store the sorted order output map
        Map<String,BasicFileAttributes> sortedMap = new TreeMap<String,BasicFileAttributes>(valueComp);
		File scanFile = new File(fileDir);
		
		// recursively traverse files and populate the map
		addFile(scanFile,outputMap);
		//addFile(scanFile,sortedMap);
		// add output maps value in TreeMap
		sortedMap.putAll(outputMap);
		
		displayMapInFile(sortedMap,startTime);
		
	}
	
	/**
	 * Method to display the entries in the TreeMap
	 * @param map
	 * @return void
	 */
	
	public static void displayMapInFile(Map<String,BasicFileAttributes> map , Long startTime){
		File f = new File("output.txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(f);
			
			for (Map.Entry<String, BasicFileAttributes> entry : map.entrySet()) {
			    //pw.print(entry.getKey()+ ","); 
				BasicFileAttributes attr = entry.getValue();
			    //pw.println(attr.size()+"," + attr.lastAccessTime());
			    System.out.print(entry.getKey()+ ",");
				System.out.println(attr.size()+"," + attr.lastAccessTime());
				
			    //System.out.println();
			}
			Long endTime = System.currentTimeMillis();
			/*pw.println(" ################################################################################## \n");
			pw.println("Total number of Files scanned "+ map.size());
			pw.println("Total Execution Time : " + (endTime - startTime) + " ms");*/
			
			System.out.println(" ################################################################################## \n");
			System.out.println("Total number of Files scanned "+ map.size());
			System.out.println("Total Execution Time : " + (endTime - startTime) + " ms");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pw.close();
		}
		
		
	}
	
	/**
	 * Method to traverse through the give path adn populate the underlying files in the map with their correspanding values 
	 * @param currentFile
	 * @param outputMap
	 * @return void
	 */
	
	
	 public static void addFile(File currentFile, Map<String,BasicFileAttributes> outputMap){
		 if (currentFile == null) {
		        return;
		 } 
		 else if (currentFile.isDirectory()) {
			 File[] filesToInclude = currentFile.listFiles();
		     for (int i = 0; i < filesToInclude.length; i++) {
		    	 	addFile(filesToInclude[i], outputMap);
		     }
		 } 
		 else if (currentFile.isFile()) {
			 try {
				BasicFileAttributes attr = Files.readAttributes(currentFile.toPath(), BasicFileAttributes.class);
				
				outputMap.put(currentFile.getAbsolutePath(), attr);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 }
		 
	}
}
/**
 * Comparator class to sort the elements of the entries of map in the descending order of their file size
 * @author Anurag
 *
 */

class ValueComparator implements Comparator<String> {

    Map<String, BasicFileAttributes> base;
    public ValueComparator(Map<String, BasicFileAttributes> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
    	if (base.get(a).size() >= base.get(b).size()) {
            return -1;
        } else {
            return 1;
        }
    }
}
