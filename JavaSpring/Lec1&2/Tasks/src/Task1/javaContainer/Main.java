package Task1.javaContainer;
import Task1.XmlWay.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();


        context.register(PersonService.class);
        context.register(ManagerService.class);
        context.refresh();

        PersonService personService = context.getBean(PersonService.class);
        personService.save("Eraa");
        personService.update("john");

        ManagerService managerService = context.getBean(ManagerService.class);
        managerService.save("Eraa");
        managerService.update("john");

        context.close();
    }

}