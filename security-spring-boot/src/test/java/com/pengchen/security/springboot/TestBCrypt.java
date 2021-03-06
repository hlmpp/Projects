package com.pengchen.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void test1() {
        //对原始密码加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        // 这是盐
        System.out.println(hashpw);

        //校验原始密码和BCrypt密码是否一致
        boolean checkpw = BCrypt.checkpw("123",
                "$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm");
        System.out.println(checkpw);


        //对原始密码加密
        hashpw = BCrypt.hashpw("456", BCrypt.gensalt());
        // 这是盐
        System.out.println(hashpw);

        //校验原始密码和BCrypt密码是否一致
        checkpw = BCrypt.checkpw("456",
                "$2a$10$jKb/5EUit2Oqrt6WLlbZRuSJGpvZq6zwEzip2ZKR2mloHjkkW1Xz2");
        System.out.println(checkpw);
    }
}
