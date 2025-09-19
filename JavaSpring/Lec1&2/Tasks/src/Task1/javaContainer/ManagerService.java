package Task1.javaContainer;

import Task1.XmlWay.UserService;
import org.springframework.stereotype.Component;

@Component
public class ManagerService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("ManagerService saving: " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("ManagerService updating: " + name);
    }
}
