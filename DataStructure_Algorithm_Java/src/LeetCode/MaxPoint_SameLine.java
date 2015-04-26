package LeetCode;

import java.util.HashMap;

public class MaxPoint_SameLine {
	public static void main(String args[]){
		Point point_arr[] = new Point[10];
		int k =0;
		for(int i =1 ;i < 5; i++){
			point_arr[k++] = new Point(i,i);
			point_arr[k++] = new Point(1,i+1);
		}
		--k;
		
		
		point_arr[++k] = new Point(5,5);
		point_arr[++k] = new Point(6,6);
		System.out.println(k);
		
		int result = calPoints(point_arr,k);
		System.out.println(result);
	}
	
	public static int calPoints(Point [] point_arr, int num_point){
		HashMap<Double,Integer> point_map = new HashMap<Double,Integer>();
		boolean [] point_visited = new boolean[num_point+1];
		for(int i =0 ; i< num_point+1 ;i++){
			point_visited[i] = false;
		}
		
		for(int i =0 ; i< num_point;i++){
			for(int j = i+1; j <= num_point ;j++){
				int x1 = point_arr[i].x;
				int y1 = point_arr[i].y;
				int x2 = point_arr[j].x;
				int y2 = point_arr[j].y;
				double val;
				if(x2-x1 != 0)
					val =  ((y2-y1)/(x2-x1));
				else{
					val = 1000;
				}
				if(val == 0){
					System.out.println(y1+"  "+y2 );
				}
				if(val < 0)
					val = -1 * val;
				
				if(point_map.containsKey(val)){
					if(!point_visited[i]){
						point_map.put(val, point_map.get(val)+1);
						point_visited[i] = true;
					}
						
				}
				else{
					point_map.put(val,1);
				}
			}
		}
		int max = 0;
		double tan = 1;
		for(double d : point_map.keySet()){
			System.out.println(d);
			if(max<point_map.get(d)){
				max = point_map.get(d);
				tan = d;
			}
		}
		System.out.println(tan);
		
		return max;
		
	}

}

class Point{
	int x,y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
