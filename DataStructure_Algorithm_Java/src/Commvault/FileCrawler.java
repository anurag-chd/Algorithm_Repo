package Commvault;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileCrawler implements Runnable {
    
    private final File root;
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public FileCrawler(File root) {
        this.root = root;
        
    }

    public void run() {
    	try {
			submitCrawlTask(root);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void submitCrawlTask(File f) throws InterruptedException, ExecutionException {
        CrawlTask crawlTask = new CrawlTask(f);
        Future<?> future = exec.submit(crawlTask);
        while(future.get() != null);
        	
        
    }

    private class CrawlTask implements Runnable {
        private final File file;
        
        public CrawlTask(File file) {
        	this.file= file;
        }

        public void run() {
        	if(Thread.currentThread().isInterrupted())
        		return;
        	File[] entries = file.listFiles();
        	if (entries != null) {
        		for (File entry : entries){
        			if (entry.isDirectory())
						try {
							submitCrawlTask(entry);
						} catch (InterruptedException | ExecutionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					else if (entry !=null){
        				try {
        					BasicFileAttributes attr = Files.readAttributes(entry.toPath(), BasicFileAttributes.class);
        					FileAttribs fileAttr = new FileAttribs(entry.getAbsolutePath(), attr.size(),attr.lastModifiedTime().toString());
        					Achoudhary_quiz_Threads.fileList.add(fileAttr);
        				} 
        				catch(Exception e){
        					e.printStackTrace();
        				}
        			}
        		}
        	}
        }
    }
}

