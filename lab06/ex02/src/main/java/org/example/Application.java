package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class);

        Bean01 bean01 = context.getBean(Bean01.class);
        Bean01 bean11 = context.getBean(Bean01.class);

        System.out.println(bean01 == bean11);

        Bean02 bean02 = context.getBean(Bean02.class);
        Bean02 bean12 = context.getBean(Bean02.class);

        System.out.println(bean02 == bean12);
    }
}
