package com.spring.mvc.single_user.entities;

import com.google.errorprone.annotations.Immutable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity
@Immutable // 只供查詢
@Synchronize(value = "T_USER") // 查詢的資料與T_User實體資料同步
// @Synchronize({"T_User"})
//@Subselect("SELECT u.id, u.name, u.email, u.birth, "
//        + "(YEAR(CURRENT_DATE)-YEAR(u.birth)) as age "
//        + "FROM T_User u "
//        + "ORDER BY age DESC") // 按照 age 排序 DESC(大->小) ASC(小->大)
@Subselect("SELECT u.id, u.name, u.email, u.birth, "
        + "(YEAR(CURRENT_DATE)-YEAR(u.birth)) as age "
        + "FROM T_User u ")
public class UserView {
    
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date birth;
    
    @Column
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserView{" + "id=" + id + ", name=" + name + ", email=" + email + ", birth=" + birth + ", age=" + age + '}';
    }
    
    
    
}
