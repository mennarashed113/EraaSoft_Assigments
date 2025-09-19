package Task3.XmlWay;

public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("PersonService saving: " + name);
    }


    public void init(){
        System.out.println("PersonService init method called");
    }
    public void destroy() {
        System.out.println("PersonService destroy method called");
    }
}
