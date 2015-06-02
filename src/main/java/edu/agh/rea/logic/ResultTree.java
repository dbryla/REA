package edu.agh.rea.logic;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ResultTree {
	private HashMap<String, HashMap<Object, Integer>> map = new HashMap<String, HashMap<Object, Integer>>();

	public boolean contains(String key){
		return map.containsKey(key);
	}

	public void add(String key) {
		map.put(key, new HashMap<Object, Integer>());
	}

	public void addAttribute(String key, Object returnedValue) {
		HashMap<Object,Integer> hashMap = map.get(key);
		if(!hashMap.containsKey(returnedValue)){
			hashMap.put(returnedValue, 1);
		}else{
			hashMap.put(returnedValue, hashMap.get(returnedValue).intValue() + 1);
		}
	}

	public Set<Entry<String,HashMap<Object,Integer>>> entrySet() {
		return map.entrySet();
	}

}
