package Commvault;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;

public class Achoudhary_quiz2 {
	public static void main(String args[]){
		// if command line argument are greater then 1 or less then 1
		// return message;
		if(args.length != 1){
			System.out.println("Enter the correct number of command line arguments");
			return;
		}
			
		String fileDir = args[0];
		Long startTime = System.currentTimeMillis();
		
		ArrayList<FileAttribs> list = new ArrayList<>();
		
		File scanFile = new File(fileDir);
		
		// recursively traverse files and populate the map
		addFile(scanFile,list);
		
		Collections.sort(list);
		
		displayListInFile(list,startTime);
		
		
		
	}
	
	/**
	 * Method to display the entries in the TreeMap
	 * @param map
	 * @return void
	 */
	
	public static void displayListInFile(ArrayList<FileAttribs> list , Long startTime){
		File f = new File("output1.txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(f);
			
			for (FileAttribs fAttrib : list) {
				pw.println(fAttrib);
		    }
			Long endTime = System.currentTimeMillis();
			pw.println(" ################################################################################## \n");
			pw.println("Total number of Files scanned "+ list.size());
			pw.println("Total Execution Time : " + (endTime - startTime) + " ms");
						
		} 
		catch (IOException e) {
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
	
	
	 public static void addFile(File currentFile, ArrayList<FileAttribs> list){
		 if (currentFile == null) {
		        return;
		 } 
		 else if (currentFile.isDirectory()) {
			 File[] filesToInclude = currentFile.listFiles();
			 if(filesToInclude != null){
				 for (int i = 0; i < filesToInclude.length; i++) {
			    	 	addFile(filesToInclude[i], list);
			     }
			 }
		 } 
		 else if (currentFile.isFile()) {
			 try {
				BasicFileAttributes attr = Files.readAttributes(currentFile.toPath(), BasicFileAttributes.class);
				FileAttribs fileAttr = new FileAttribs(currentFile.getAbsolutePath(), attr.size(),attr.lastModifiedTime().toString());
				list.add(fileAttr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 }
	}
}


