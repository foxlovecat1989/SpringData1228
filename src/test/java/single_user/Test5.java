package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    
    @Test
    public void t5(){
        ClassPathXmlApplicationContext ctx = 
            new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
         
        // WHERE name LIKE ?% AND id < ?
        // WHERE name LIKE 'S%' AND id < 100
        List<User> users = 
                userRepository.getByNameStartingWithAndIdLessThan("S", 100L);
        
        // WHERE name LIKE ?% AND id >= ?
        users = userRepository.getByNameStartingWithAndIdGreaterThanEqual("S", 100L);
        
        // WHERE id in (?, ?, ?) And birth < ?
        // WHERE id in (2, 4, 8, 16 ...) And birth <= '1984-10-31'
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            users = userRepository.getByIdInAndBirthLessThanEqual(Arrays.asList(1L, 2L, 3L, 4L), 
                    sdf.parse("1984-10-31"));
            users.stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Date Error");
        }
        
        // System.out.println(users);
    }
}
