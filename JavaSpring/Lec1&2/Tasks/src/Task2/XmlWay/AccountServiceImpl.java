package Task2.XmlWay;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService{
    private UserService personService;


    public void setPersonService(UserService personService) {
        this.personService = personService;
    }

    @Override
    public void getPerson(String name) {
       personService.save(name);
    }
}
