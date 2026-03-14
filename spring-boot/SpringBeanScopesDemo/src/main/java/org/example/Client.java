package org.example;

import bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {
        // Load Spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Singleton Example
        HelloWorld singleton1 = (HelloWorld) context.getBean("singletonBean");
        singleton1.setName("Singleton One");

        HelloWorld singleton2 = (HelloWorld) context.getBean("singletonBean");

        System.out.println("Singleton1 Name: " + singleton1.getName());
        System.out.println("Singleton2 Name: " + singleton2.getName());
        System.out.println("Are both singleton objects same? " + (singleton1 == singleton2));
        System.out.println("Address singleton1: " + singleton1);
        System.out.println("Address singleton2: " + singleton2);

        // Prototype Example
        HelloWorld prototype1 = (HelloWorld) context.getBean("prototypeBean");
        prototype1.setName("Prototype One");

        HelloWorld prototype2 = (HelloWorld) context.getBean("prototypeBean");

        System.out.println();
        System.out.println("Prototype1 Name: " + prototype1.getName());
        System.out.println("Prototype2 Name: " + prototype2.getName());
        System.out.println("Are both prototype objects same? " + (prototype1 == prototype2));
        System.out.println("Address prototype1: " + prototype1);
        System.out.println("Address prototype2: " + prototype2);
    }
}