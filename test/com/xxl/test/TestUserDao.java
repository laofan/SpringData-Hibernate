package com.xxl.test;

import com.xxl.dao.UserDao;
import com.xxl.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @类名： com.xxl.test.TestUserDao
 * @描述： <尽量简短的描述类的作用>
 * @创建人： xiao.xl
 * @创建时间： 2019/1/2 23:15
 * @修改人和其他信息：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserDao {

    @Autowired
    private UserDao userDao;

    /**
     * @方法名： addUser
     * @描述：  测试添加
     * @参数： []
     * @返回值： void
     * @创建人： xiao.xl
     * @创建时间： 2019/1/2 23:21
     * @修改人和其他信息：  在测试类中使用Transactional开始事务，默认是事务回滚的，所以需要关闭事务回滚
     */
    @Test
    //在测试类中使用Transactional开始事务，默认是事务回滚的
    @Transactional
    //取消事务回滚
    @Rollback(value = false)
    public void addUser(){
        Users users = new Users();
        users.setUserName("张三");
        users.setUserAge(18);
        this.userDao.insertUser(users);
    }

}
