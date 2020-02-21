package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// 完成数据库调用的 Bean标志，数据层，同时可以于此定义 Bean的名字，用于调用。
@Repository("Hibernate")
// 优先调用的标志
@Primary
// @Scope("prototype") : 产生多个实例
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select(){
        return "Hibernate.";
    }
}
