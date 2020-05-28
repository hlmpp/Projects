package org.javaboy.vhr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Role;

import java.util.List;

public class testForMe {

    public static void main(String[] args) throws JsonProcessingException {
        Hr hr = new Hr();
        hr.setId(1);
        hr.setAddress("123");
        hr.setEnabled(true);
        hr.setName("fasf");
        hr.setPassword("3423");
        hr.setPhone("134343");
        hr.setRemark("sdfs");
        RespBean ok = RespBean.ok("登录成功!", hr);
        String s = new ObjectMapper().writeValueAsString(ok);
        System.out.println(s);
    }
}
