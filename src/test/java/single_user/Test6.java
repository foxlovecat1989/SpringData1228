package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test6 {
    
    @Test
    public void t6(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        List<User> users = userRepository.getByAgeGreaterThan(63);
        users.stream().forEach(System.out::println);
    }
}
