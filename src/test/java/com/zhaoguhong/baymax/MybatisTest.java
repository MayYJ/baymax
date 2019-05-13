package com.zhaoguhong.baymax;

import com.zhaoguhong.baymax.demo.dao.DemoMapper;
import com.zhaoguhong.baymax.demo.entity.Demo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisTest {

    @Autowired
    private DemoMapper demoMapper;

    /**
     * 测试 通用mapper
     */
    @Test
    public void testMyBatis() {
        log.info("测试注解查询：{}",demoMapper.findByUserName("baymax"));
        log.info("测试xml查询：{}",demoMapper.getDemos());
    }

    /**
     * 测试 通用mapper
     */
    @Test
    public void testMappper() {
        Demo demo = new Demo();
        demo.setUserName("baymax");
        demo.setAge(11);
        demoMapper.saveEntity(demo);
        log.info("测试通用mapper,根据主键查询：{}",demoMapper.selectByPrimaryKey(1L));
    }

}