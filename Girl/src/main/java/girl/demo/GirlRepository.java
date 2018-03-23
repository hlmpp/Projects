package girl.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 添加查询接口，按年龄查询
    public List<Girl> findByAge(Integer age);
}
