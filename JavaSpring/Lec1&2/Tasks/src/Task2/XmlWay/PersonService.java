package Task2.XmlWay;

public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("PersonService saving: " + name);
    }


}
