package single_user;

import com.spring.mvc.single_user.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test7 {
    
    @Test
    public void t7(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        Long total = userRepository.getTotalCount();  
        System.out.println(total);
    }
}
