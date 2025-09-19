package Task2.javaContainer;

import Task2.XmlWay.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    private UserService personService;

   @Autowired
    public void setPersonService(UserService personService) {
        this.personService = personService;
    }

    @Override
    public void getPerson(String name) {
       personService.save(name);
    }
}
