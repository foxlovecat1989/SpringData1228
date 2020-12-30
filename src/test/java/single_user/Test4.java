package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    
    @Test
    public void t4(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        User user = userRepository.getByName("Goodwin");
        System.out.println(user);
    }
}
