package com.xxl.dao.impl;

import com.xxl.dao.UserDao;
import com.xxl.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @类名： com.xxl.dao.impl.UserDaoImpl
 * @描述： <尽量简短的描述类的作用>
 * @创建人： xiao.xl
 * @创建时间： 2019/1/2 23:01
 * @修改人和其他信息：
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insertUser(Users users) {
        this.hibernateTemplate.save(users);
    }

    @Override
    public void updateUser(Users users) {
        this.hibernateTemplate.update(users);
    }

    @Override
    public void deleteUser(Users users) {
        this.hibernateTemplate.delete(users);
    }

    @Override
    public Users selectUserById(Integer userId) {
        return this.hibernateTemplate.get(Users.class,userId);
    }
}
