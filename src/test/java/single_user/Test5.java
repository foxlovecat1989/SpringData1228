package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    
    @Test
    public void t5(){
        ClassPathXmlApplicationContext ctx = 
            new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        List<User> users = 
                userRepository.getByNameStartingWithAndIdLessThan("S", 100L);
        
        users = userRepository.getByNameStartingWithAndIdGreaterThanEqual("S", 100L);
        System.out.println(users);
    }
}
