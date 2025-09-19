package Task3.javaContainer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("PersonService saving: " + name);
    }

    @PostConstruct
    public void init(){
        System.out.println("PersonService init method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PersonService destroy method called");
    }
}
