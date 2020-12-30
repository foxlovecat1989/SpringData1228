package single_user;

import com.github.javafaker.Faker;
import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    
    @Test
    public void t2(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository userRepository = ctx.getBean(UserRepository.class);
            
        Faker faker = new Faker();
        for(int i = 0; i < 169; i++){
            User user = new User();
            user.setName(faker.name().lastName());
            user.setBirth(faker.date().birthday());
            user.setEmail(faker.internet().emailAddress());
            userRepository.saveAndFlush(user);
        }
    }    
        
}