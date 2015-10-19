package kom.slavko.designpatterns.customcolleciton;

import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		AlwaysSortedTalkingList<String> astl = new AlwaysSortedTalkingList<String>(
				new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						if (o1.length() == o2.length())
							return 0;
						if (o1.length() > o2.length())
							return 1;
						return -1;
					}

				});
		astl.add("Slavko");
		astl.add("Ana");
		astl.add("MilicaAAA");
		astl.add("Nevena");
		for (int i = 0; i < astl.size(); i++) {
			System.out.println(astl.get(i));
		}
	}
}
