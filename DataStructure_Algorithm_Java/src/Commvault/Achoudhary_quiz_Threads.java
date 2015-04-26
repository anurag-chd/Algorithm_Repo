package Commvault;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;


public class Achoudhary_quiz_Threads {
	public static CopyOnWriteArrayList<FileAttribs> fileList = new CopyOnWriteArrayList<>();
	public static void main(String args[]) throws InterruptedException{
		if(args.length != 1){
			System.out.println("Enter the correct number of command line arguments");
			return;
		}
			
		String fileDir = args[0];
		Long startTime = System.currentTimeMillis();
		
		File scanFile = new File(fileDir);
		FileCrawler fileCrawler = new FileCrawler(scanFile);
		Thread fileThread = new Thread(fileCrawler);
		fileThread.start();
		
		fileThread.join();
		Collections.sort(fileList);
		
		displayListInFile(startTime);
		System.out.println("Exit");
		System.exit(0);
		
		
		
		
	}
	
	public static void displayListInFile(Long startTime){
		File f = new File("output2.txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(f);
			
			for (FileAttribs fAttrib : fileList) {
				pw.println(fAttrib);
				
			}
			Long endTime = System.currentTimeMillis();
			pw.println(" ################################################################################## \n");
			pw.println("Total number of Files scanned "+ fileList.size());
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

}


