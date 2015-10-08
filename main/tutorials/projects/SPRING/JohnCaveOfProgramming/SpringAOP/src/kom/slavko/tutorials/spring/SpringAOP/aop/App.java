package kom.slavko.tutorials.spring.SpringAOP.aop;

import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

		
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"kom/slavko/tutorials/spring/SpringAOP/aop/beans.xml");

		Object cameraObj = context.getBean("camera");
		System.out.println(cameraObj.getClass());
		Camera camera = (Camera) context.getBean("camera");
		((ILungs)camera).breathe();// Made possible by Introductions(or mixins) in Logger aspect defined in beans.xml

		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println("Caught exception " + e.getMessage());
		}

		context.close();
	}

}
