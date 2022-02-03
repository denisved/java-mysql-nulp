import org.hibernate.Session;
import com.vedernikov.util.HibernateUtil;
import com.vedernikov.view.View;

public class Main {
    public static void main(String[] args) {
        try (Session SESSION = HibernateUtil.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}
