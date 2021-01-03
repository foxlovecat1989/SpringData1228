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
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class Test10 {
    
    @Test
    public void t9(){
        ClassPathXmlApplicationContext ctx = 
                new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserViewRepository userViewRepository = ctx.getBean(UserViewRepository.class);
        
         // 分頁
        int pageNo = 3;
        int pageSize = 10;
        
        // 排序
        Order order1 = new Sort.Order(Sort.Direction.ASC, "name");
        Order order2 = new Sort.Order(Sort.Direction.DESC, "age");
        Sort sort = new Sort(order1, order2);
        
        // 分頁請求
        PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);
        Page<UserView> page = userViewRepository.findAll(pageRequest);
        
        page.getContent().stream().forEach(System.out::println); // 得到分頁內容
        
        System.out.println((pageNo+1) + " / " + page.getTotalPages()); // 顯示目前在第幾頁
    }
}
