package Task1.javaContainer;

import Task1.XmlWay.UserService;
import org.springframework.stereotype.Component;

@Component
public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("PersonService saving: " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("PersonService updating: " + name);
    }
}
