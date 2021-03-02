package com.springcore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	
	
	@Bean(name="pointObj1")
	public Point getPoint1() {
		return new Point(1,2);
	}
	
	@Bean(name="rectangleObj")
	public Rectangle getRectangle() {
		return new Rectangle(getPoint1(),getPoint1(),getPoint1(),getPoint1(),10,20);
	}

}
