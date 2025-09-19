package Task2.javaContainer;

import org.springframework.stereotype.Component;

@Component
public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("PersonService saving: " + name);
    }


}
