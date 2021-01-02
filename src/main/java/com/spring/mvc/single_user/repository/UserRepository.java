package com.spring.mvc.single_user.repository;

import com.spring.mvc.single_user.entities.User;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/*
只需定義 interface 的規格, 實作內容是由 SpringData 幫你做
<User, Long> -> User 指的是Entity的類別名, Long 指的是 @Id 的資料型別
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    // 根據 name來取得
    User getByName(String name); 
    
    // WHERE name LIKE ?% AND id < ?
    // WHERE name LIKE 'S%' AND id < 100
    List<User> getByNameStartingWithAndIdLessThan(String name, Long id);
    
    // WHERE name LIKE ?% AND id >= ?
    List<User> getByNameStartingWithAndIdGreaterThanEqual(String name, Long id);
    
    // WHERE id in (?, ?, ?) OR birth < ?
    // WHERE id in (2, 4, 8, 16 ...) OR birth <= '2000/12/31'
    List<User> getByIdInAndBirthLessThanEqual(List<Long> ids, Date date);
    
    // 查詢 User + age < ? (但是 age 並不是 User 的屬性)
    @Query("SELECT u FROM User u WHERE (YEAR(current_date) - YEAR(u.birth)) > :age")
    // Error
    // @Query("SELECT * FROM User u WHERE (YEAR(current_date) - YEAR(u.birth)) > :age")
    List<User> getByAgeGreaterThan(Integer age);
    
    // 查詢資料筆數
    @Query(value = "SELECT count(id) FROM T_USER", nativeQuery = true)
    Long getTotalCount();
}
