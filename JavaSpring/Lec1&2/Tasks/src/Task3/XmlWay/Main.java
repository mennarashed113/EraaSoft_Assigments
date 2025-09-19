package Task3.XmlWay;
import Task2.XmlWay.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("Task3/XmlWay/ApplicationContext.xml");

           UserService personService1 =(UserService) context.getBean("personService");
           UserService personService2 =(UserService) context.getBean("personService");


           personService1.save("Eraa");
           personService2.save("john");

           //to run destroy method in prototype bean
        ((PersonService) personService1).destroy();
        ((PersonService) personService2).destroy();


    }

}