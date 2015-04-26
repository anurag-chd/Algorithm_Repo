package Commvault;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet_HashSet_Diff {
	 public static void main(String args[]) { 
		   int size = 8000000; 
		   useHashThenTreeSet(size);
		   useTreeSetOnly(size); 
		 } 
		   private static void useTreeSetOnly(int size) {
		      System.out.println("useTreeSetOnly: ");
		      long start = System.currentTimeMillis(); 
		      Set<String> sortedSet = new TreeSet<String>();
		      for (int i = 0; i < size; i++) {
		         sortedSet.add(i + ""); 
		      } 
		      //System.out.println(sortedSet);    
		      long end = System.currentTimeMillis();
		      System.out.println("useTreeSetOnly: " + (end - start)); 
		} 
		   private static void useHashThenTreeSet(int size) { 
		      System.out.println("useHashThenTreeSet: ");
		      long start = System.currentTimeMillis(); 
		      Set<String> set = new HashSet<String>();
		      for (int i = 0; i < size; i++) {
		         set.add(i + ""); 
		      } 
		      String str = new String();
		      
		      Set<String> sortedSet = new TreeSet<String>(set);
		      //System.out.println(sortedSet); 
		      long end = System.currentTimeMillis();
		      System.out.println("useHashThenTreeSet: " + (end - start)); 
		   } 

}
