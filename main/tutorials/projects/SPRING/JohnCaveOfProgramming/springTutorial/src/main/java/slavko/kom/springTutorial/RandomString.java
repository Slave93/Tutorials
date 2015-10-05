package slavko.kom.springTutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomString {
	private String str1;
	private String str2;
	private String str3;
	private List<String> strList = new ArrayList<String>();
	
	public RandomString(){
		str1 = "Leg's thay bro!";
		str2 = "Can't miss a legs day!";
		str3 = "Shut up and squat!!!";		
		strList.add(str1);
		strList.add(str2);
		strList.add(str3);
	}
	
	public String getString(){		
		return strList.get(new Random().nextInt(strList.size()));
	}
}
