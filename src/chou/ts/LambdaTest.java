package chou.ts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * ½m²ßlambda»yªk
 * */
public class LambdaTest {

	List<Integer> ls;
	Map<String, String> mp;
	
	LambdaTest(){
		ls = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			ls.add(i);
		}
		
		mp = new HashMap<String,String>();
		mp.put("A", "aaa");
		mp.put("B", "bbb");
		mp.put("C", "ccc");
		
	}
	
	public static void main(String[] args) {
		LambdaTest lt = new LambdaTest();
		lt.ls.forEach((c)->System.out.print(c + " "));
		System.out.println();
		lt.ls.stream().filter(c->c%2==0).forEach((c)->System.out.print(c + " "));
		List newls = lt.ls.stream().filter(c->c%3==0).collect(Collectors.toList());
		System.out.println();
		System.out.print(newls);
		System.out.println();
		List newls2 = (List) newls.stream().map(c->c.toString()+'A').collect(Collectors.toList());
		System.out.println(newls2);
		System.out.println();
		String newls3 = (String) newls.stream().map(c->c.toString()).collect(Collectors.joining(",", "|:", ":|"));
		System.out.println(newls3);
		
		System.out.println();
		lt.mp.forEach((k, v)->System.out.print(k + " : " + v + "  "));
	}
	
}
