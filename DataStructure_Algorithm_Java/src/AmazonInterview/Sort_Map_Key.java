package AmazonInterview;
import java.util.*;

public class Sort_Map_Key {
	public static void main(String args[]){
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"Froyo" );
		map.put(2,"abby" );
		map.put(3,"denver" );
		map.put(4,"frost" );
		map.put(5,"daisy" );
		LinkedHashMap<Integer,String> sortedMap = sortKeys(map);
		Set<Integer> s = sortedMap.keySet();
		for(int i : s){
			System.out.println(i+" "+ sortedMap.get(i));
		}
	}
	public static LinkedHashMap<Integer,String> sortKeys(HashMap<Integer, String> map){
		
		List mapKeys = new ArrayList(map.keySet());
		List<String> mapValues = new ArrayList<String>(map.values());
		Collections.sort(mapValues);
		for(String s : mapValues){
			System.out.println(s);
		}
		Collections.sort(mapKeys);
		LinkedHashMap<Integer,String> sortedMap = new LinkedHashMap<Integer,String>();
		Iterator itValues = mapValues.iterator();
		while(itValues.hasNext()){
			String comp1 = (String)itValues.next();
			Iterator itKeys = mapKeys.iterator();
			while(itKeys.hasNext()){
				int i = (Integer)itKeys.next();
				String comp2 = map.get(i);
				if(comp1.equals(comp2)){
					sortedMap.put(i, comp1);
					mapKeys.remove((Integer)i);
					map.remove((Integer)i);
					break;
					
				}
			}
		}
		return sortedMap;
	}
	
}
