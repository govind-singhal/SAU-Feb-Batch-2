package com.springcore;


import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingApp 
{
    public static void main( String[] args ) throws IOException
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Rectangle rectangle = context.getBean("rectangleObj", Rectangle.class);
        
        rectangle.draw();
        
        
    }
}
