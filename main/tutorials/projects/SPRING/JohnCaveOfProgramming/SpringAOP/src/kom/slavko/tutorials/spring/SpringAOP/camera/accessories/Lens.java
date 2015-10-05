package kom.slavko.tutorials.spring.SpringAOP.camera.accessories;

import org.springframework.stereotype.Component;


public class Lens {
	public void zoom(int factor) {
		System.out.println("Zooming lens: " + factor);
	}
}
