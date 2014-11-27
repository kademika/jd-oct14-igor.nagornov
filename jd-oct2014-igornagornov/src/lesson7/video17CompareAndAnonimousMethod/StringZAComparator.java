package lesson7.video17CompareAndAnonimousMethod;

import java.util.Comparator;

public class StringZAComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		int result = s1.compareToIgnoreCase(s2);
		if (result > 0)
			return -1;
		else if (result < 0)
			return 1;
		return 0;
	}

}
