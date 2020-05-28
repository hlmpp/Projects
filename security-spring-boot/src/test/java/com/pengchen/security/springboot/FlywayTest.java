package com.pengchen.security.springboot;

import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FlywayTest {

    @Test
    public void TestFlyway() {
        String url = "jdbc:mysql://192.168.99.100:3306/user_db?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&rewriteBatchedStatements=true&useSSL=false&serverTimezone=GMT%2B8";

        String user = "root";

        String password = "123456";

        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();


        // 创建 flyway_schema_history 表

//		flyway.baseline();


        // 删除 flyway_schema_history 表中失败的记录

//		flyway.repair();


        // 检查 sql 文件

//		flyway.validate();


        // 执行数据迁移

        flyway.migrate();


        // 删除当前 schema 下所有表

//		flyway.clean();
    }
}
