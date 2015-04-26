package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public static void main(String args[]){
		List<Interval> intervalList = new ArrayList<>();
		intervalList.add(new Interval(1,2));
		intervalList.add(new Interval(3,5));
		intervalList.add(new Interval(6,7));
		intervalList.add(new Interval(8,10));
		intervalList.add(new Interval(12,16));
		//intervalList.add(new Interval(15,18));
		
		Interval add = new Interval(4,9);
		//Collections.sort(intervalList);
		//System.out.println(intervalList);
		// merge Interval (ProgramCreek)
		System.out.println(mergeIntervals(intervalList, add));
		
		// insert and Merge interval(ProgramCreek)
		//insert_MergeInterval(intervalList, new Interval(4,9));
		
		//System.out.println(intervalList);
		
		
	}
	
	public static List<Interval> mergeIntervals(List<Interval> intervalList,Interval newInterval){
		int i =1;
		intervalList.add(newInterval);
		IntervalComparator ic = new IntervalComparator();
		Collections.sort(intervalList,ic);
		while(i<intervalList.size()){
			if(intervalList.get(i).start <= intervalList.get(i-1).end){
				intervalList.get(i-1).end = intervalList.get(i).end < intervalList.get(i-1).end ? intervalList.get(i-1).end :intervalList.get(i).end;
				intervalList.remove(i);
			}
			else
				i++;
		}
		return intervalList;
	}
}

class Interval implements Comparable<Interval>{
	int start;
	int end;
	public Interval(){
		this.start = 0;
		this.end = 0;
	}
	
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}

	
	public int compareTo(Interval i) {
		
		return this.start> i.start ? 1 : this.start< i.start? -1:0;
	}
	
	public String toString(){
		String str = new String();
		
		return "["+this.start+" ,"+this.end+"]" ;
	}

	
}

class IntervalComparator implements Comparator<Interval>{

	@Override
	public int compare(Interval arg0, Interval arg1) {
		// TODO Auto-generated method stub
		return arg0.start> arg1.start ? 1 : arg0.start< arg1.start? -1:0;
	}
	
}