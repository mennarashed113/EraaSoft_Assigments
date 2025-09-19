package Task1.XmlWay;

public class ManagerService implements UserService{
    @Override
    public void save(String name) {
        System.out.println("ManagerService saving: " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("ManagerService updating: " + name);
    }
}
