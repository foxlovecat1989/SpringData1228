package single_user;

import com.spring.mvc.single_user.entities.User;
import com.spring.mvc.single_user.entities.UserView;
import com.spring.mvc.single_user.repository.UserRepository;
import com.spring.mvc.single_user.repository.UserViewRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class Test9 {
    
    @Test
    public void t9(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserViewRepository userViewRepository = ctx.getBean(UserViewRepository.class);
        
         // 分頁
        int pageNo = 3;
        int pageSize = 10;
        // 分頁請求
        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
        Page<UserView> page = userViewRepository.findAll(pageRequest);
        
        page.getContent().stream().forEach(System.out::println); // 得到分頁內容
        
        System.out.println((pageNo+1) + " / " + page.getTotalPages()); // 顯示目前在第幾頁
    }
}
