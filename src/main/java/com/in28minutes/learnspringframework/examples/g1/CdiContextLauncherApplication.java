package com.in28minutes.learnspringframework.examples.g1;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (CdiContextLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());

        }
    }
}

//@Component

class BusinessService{
    private DataServiceClass dataService;

//    @Autowired

    public void setDataService(DataServiceClass dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }


    public DataServiceClass getDataService() {

        return dataService;
    }
}

@Component
class DataServiceClass{

}

