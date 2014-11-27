package lesson7.video23HashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.RowFilter.Entry;

public class Person {

	String name;
	int age;
	int salary;
	Adress adress;

	private class Adress {

		private String city;
		private String street;
		private int house;

		public Adress(String city, String street, int house) {
			// TODO Auto-generated constructor stub
			if (city == null || street == null || house <= 0) {
				throw new IllegalArgumentException(
						"Illegal parametres in adress!");
			}
			this.city = city;
			this.street = street;
			this.house = house;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			int result = 25;
			result = 37 * result + city.hashCode();
			result = 37 * result + street.hashCode();
			result = 37 * result + house; // obshiy algoritm polucheniya hash
											// koda

			return result;
		}

		public boolean equals(Object obj) {
			// TODO Auto-generated method stub

			if (obj instanceof Adress) {
				Adress a = (Adress) obj;
				if (a.getCity().equals(city) && a.getStreet().equals(street)
						&& a.getHouse() == house) {
					return true;
				}
			}
			return false;
		}

		public String getCity() {
			return city;
		}

		public String getStreet() {
			return street;
		}

		public int getHouse() {
			return house;
		}

	}

	public Person(String name, int age, int salary, String city, String street,
			int house) {
		// TODO Auto-generated constructor stub

		this.name = name;
		this.age = age;
		this.salary = salary;
		this.adress = new Adress(city, street, house);

	}

	public int hashCode() {
		// TODO Auto-generated method stub

		int result = 25;
		result = 37 * result + name.hashCode();
		result = 37 * result + age;
		result = 37 * result + new Integer(salary).hashCode();
		if (adress != null) {
			result = 37 * result + adress.hashCode();
		}

		return result;

	}

	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

		if (obj instanceof Person) {
			Person p = (Person) obj;
			if (name != null && name.equals(p.name) && p.age == age
					&& p.salary == salary && p.adress.equals(adress)) {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person("Igor Sergeev", 26, 30000, "Nizhniy Novgorod",
				"Dvizhencev", 32);
		Person p2 = new Person("Igor Nagornov", 26, 40000, "Nizhniy Novgorod",
				"Dvizhencev", 32);
		Person p3 = new Person("Sergey Nagornov", 28, 35500, "Nizhniy Novgorod",
				"Dvizhencev", 32);
//
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.hashCode() + " " + p2.hashCode());
		
		Map<String, Person> hm = new HashMap<>(); // String - Key, Person - Value
		
		hm.put(p1.name, p1);		
		hm.put(p2.name, p2);
		hm.put(p3.name, p3);
		
		System.out.println(hm.containsValue(p3));
		System.out.println(hm.containsKey(p2.name));
		
		for (String key: hm.keySet()) {
		    System.out.println("key: " + key);		    
		    
		}
		
		for (Person value : hm.values()) {
		    System.out.println("Value: " + value.name + " " + value.age + " " + value.salary);
		}		
		
		for (Map.Entry<String, Person> me :  hm.entrySet()) {
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		
		
		
	}

}
