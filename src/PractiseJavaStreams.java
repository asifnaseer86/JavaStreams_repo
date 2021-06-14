

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PractiseJavaStreams {

	//@Test
	public void regular() 
	{
	
		ArrayList<String> names = new ArrayList<>();
		
		names.add("Asif");
		names.add("Adil");
		names.add("Azhar");
		names.add("Uzair");
		names.add("Bilal");
		
		int count = 0;
		for(int i=0; i<names.size(); i++) 
		{
			String actuall = names.get(i);
			if (actuall.startsWith("A")) 
			{
				count++;
			}
			
		}
		System.out.println(count);
		
		
	}

	//@Test
	public void streams() 
	{
		ArrayList<String> names = new ArrayList<>();
		
		names.add("Asif");
		names.add("Adil");
		names.add("Azhar");
		names.add("Uzair");
		names.add("Bilal");
		
		int check = (int) names.stream().filter(n->n.startsWith("A")).count();
		
		System.out.println(check);
		
		Long otherTest = Stream.of("Asif","dil","Azhar","Uzair","Bilal","Atif").filter(p->
		{
			p.startsWith("A");
			return true;
		}).count();
		
		System.out.println(otherTest);
		
		//print all names in arrayist which length is greater then 4
		names.stream().filter(p->p.length()>4).forEach(p->System.out.println(p));
		
		//limit names in arrayist which length is greater then 4
		names.stream().filter(p->p.length()>4).limit(1).forEach(p->System.out.println(p));
	}

	//@Test
	public void streamMaps() 
	{
		//print the name which end with L also with upper case
		Stream.of("Asif","Adil","Azhar","Uzair","Bilal","Atif").filter(p->p.endsWith("l")).map(p->p.toUpperCase())
		.forEach(s->System.out.println(s));
		System.out.println("--------------------------------------------");
		
		//print names which have first letter a with uper case and sorted
		List<String> names1 = Arrays.asList("Asif1","Adil1","Azhar1","Uzai1r","Bilal1","Atif1");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		System.out.println("--------------------------------------------");
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Asif");
		names.add("Adil");
		names.add("Azhar");
		names.add("Uzair");
		names.add("Bilal");
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		System.out.println("--------------------------------------------");
		//check any value present in list
		
		Stream<String> newStream1 = Stream.concat(names.stream(), names1.stream());
		boolean flag = newStream1.anyMatch(s->s.equalsIgnoreCase("Adil"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollectMethod() 
	{
		//list
		//do manupulation using streams
		//convert back to list
		List<String> ls = Stream.of("Asif","Adil","Azhar","Uzair","Bilal","Atif").filter(p->p.endsWith("l")).map(p->p.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		System.out.println("-------------------------");
		
		List<Integer> values = Arrays.asList(2,2,6,9,8,4,6,4,3,7,5,5,1);
		
		//print unique numbers
		values.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("-------------------------");
		
		//print sorted list give third index
		List<Integer> intLs = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(intLs.get(2));
		
		
	}
}
