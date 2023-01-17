package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (LazyInitializationLauncherApplication.class);){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("Initialization of context is completed");

            context.getBean(classB.class).doSomething();

        }

    }
}

@Component
class classA{

}

@Component
@Lazy
class classB{
    private classA classA;

    public classB(classA classA) {
        System.out.println("Some initialization logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do something");
    }
}
