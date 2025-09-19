package Task1.XmlWay;

public class PersonService implements UserService{
    @Override
    public void save(String name) {
        System.out.println("PersonService saving: " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("PersonService updating: " + name);
    }
}
