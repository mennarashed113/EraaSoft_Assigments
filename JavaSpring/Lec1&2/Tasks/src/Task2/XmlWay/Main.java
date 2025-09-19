package Task2.XmlWay;
import Task1.XmlWay.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("Task2/XmlWay/applicationContext.xml");
           context.getBean("accountService");
           AccountService accountService = (AccountService) context.getBean("accountService");
           accountService.getPerson("john");


    }

}