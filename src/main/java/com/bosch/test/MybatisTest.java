package com.bosch.test;

import com.bosch.mapper.CategoryMapper;
import com.bosch.pojo.Category;
import com.bosch.pojo.OpcServerList;
import com.bosch.service.CategoryService;
import com.bosch.service.OPCImpl.OpcServerServiceImpl;
import org.jinterop.dcom.common.JIException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    CategoryService categoryService;

    //@Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            Category category = new Category();
            category.setName("new Category1226");
            categoryMapper.add(category);
        }

    }
    //@Test
    public void findall(){

        List<Category> cs= categoryService.list();
        for(Category c:cs){
            System.out.println(c.getName()+"  "+c.getId());
        }


    }
    @Test
    public void showopc() throws JIException, UnknownHostException {
        OpcServerServiceImpl opcServerService=new OpcServerServiceImpl();
        //192.168.0.100
        Map<Integer, OpcServerList> map=opcServerService.showAllServers("localhost",
                "Opcuser","123456","");

        for(Map.Entry<Integer, OpcServerList> entry:map.entrySet()){
            System.out.println("key="+entry.getKey()+" "
                    +"clid="+entry.getValue().getCLid()+" proid="+entry.getValue().getProID()
            );
        }
    }


}

