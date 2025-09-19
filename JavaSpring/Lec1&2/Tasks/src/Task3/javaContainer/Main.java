package Task3.javaContainer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

       // Manually register component classes to avoid scanning issues with Java 19
       context.register(PersonService.class);
       context.refresh();

       PersonService personService1 = context.getBean(PersonService.class);
       PersonService personService2 = context.getBean(PersonService.class);

       personService1.save("Eraa");
       personService2.save("john");

       // For prototype beans, @PreDestroy won't be called automatically

       personService1.destroy();
       personService2.destroy();

       context.close();
    }
}