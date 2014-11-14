package lesson7.video17CompareAndAnonimousMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = new ArrayList<>();
		names.add("Pavel");
		names.add("Igor");
		names.add("Raisa");
		names.add("Sergey");
		names.add("Mariya");
		names.add("Lyudmila");
		names.add("Viktoriya");
		names.add("Mark");
		names.add("Nadezhda");
		names.add("Galina");
		names.add("Dmitriy");
		names.add("Evgeniy");

		Collections.sort(names);		

		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();		
		
		Collections.sort(names, new Comparator<String>() {

			public int compare(String s1, String s2) {
				int result = s1.compareToIgnoreCase(s2);
				if (result > 0)
					return -1;
				else if (result < 0)
					return 1;
				return 0;

			}

		});
		
		System.out.println(names.toString());		

	}

}
