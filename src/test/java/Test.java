import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

public class Test {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        System.out.println(antPathMatcher.match("/a/css/**","/a/css/asd.css"));
    }
}
