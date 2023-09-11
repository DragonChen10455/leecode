import java.util.Date;

public class test {
    public static void main(String[] args) {
        Date now = new Date();
        Date end = new Date(now.getTime() - 1000000L * 60 * 1000);
        System.out.println(now);
        System.out.println(end);
    }
}
