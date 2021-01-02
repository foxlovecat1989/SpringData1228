package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.entities.UserView;
import com.spring.mvc.single_user.repository.UserRepository;
import com.spring.mvc.single_user.repository.UserViewRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test8 {
    
    @Test
    public void t8(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserViewRepository userViewRepository = ctx.getBean(UserViewRepository.class);
        List<UserView> users = userViewRepository.findAll();
        users.stream().forEach(System.out::println);        
    }
}
