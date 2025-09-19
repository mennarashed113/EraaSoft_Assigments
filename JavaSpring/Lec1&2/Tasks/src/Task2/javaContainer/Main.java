package Task2.javaContainer;
import Task2.XmlWay.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // register component classes to avoid scanning issues with Java 19
        context.register(PersonService.class);
        context.register(AccountServiceImpl.class);
        context.refresh();

        AccountService accountService = context.getBean(AccountService.class);
        accountService.getPerson("john");

        context.close();
    }

}