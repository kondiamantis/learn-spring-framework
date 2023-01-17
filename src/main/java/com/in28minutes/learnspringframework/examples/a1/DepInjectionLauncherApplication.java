package com.in28minutes.learnspringframework.examples.a1;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    //YourBusinessClass
    @Component
    class YourBusinessClass{

        dependency1 dependency1;

        dependency2 dependency2;

        @Autowired
        public YourBusinessClass(DepInjectionLauncherApplication.dependency1 dependency1, DepInjectionLauncherApplication.dependency2 dependency2) {
            System.out.println("Construction Injection - YourBusinessClass");
            this.dependency1 = dependency1;
            this.dependency2 = dependency2;
        }

        public String toString(){
            return "Using " +dependency1 +" and " + dependency2;
        }

//        @Autowired
//        public void setDependency1(dependency1 dependency1) {
//            System.out.println("Setter Injection - setDependency1 ");
//            this.dependency1 = dependency1;
//        }
//
//        @Autowired
//        public void setDependency2(dependency2 dependency2) {
//            System.out.println("Setter Injection - setDependency2 ");
//            this.dependency2 = dependency2;
//        }
    }
    //Dependency1
    @Component
    class dependency1{

    }
    //Dependency2
    @Component
    class dependency2{

    }



    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (DepInjectionLauncherApplication.class);){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));

        }


    }
}
