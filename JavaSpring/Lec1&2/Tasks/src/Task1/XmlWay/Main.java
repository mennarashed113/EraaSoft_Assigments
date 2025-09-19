package Task1.XmlWay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("Task1/XmlWay/applicationContext.xml");

           UserService personService =(UserService) context.getBean("personService");
            personService.save("Eraa");
            personService.update("john");

            UserService managerService =(UserService) context.getBean("managerService");
            managerService.save("Eraa");
            managerService.update("john");
    }

}