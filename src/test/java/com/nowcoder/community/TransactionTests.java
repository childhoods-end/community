package com.nowcoder.community;

import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class TransactionTests {

    /***
     * 并发异常：
     * 第一类丢失更新：
     *  一事务数据回滚导致另一数据错误
     * 第二类丢失更新：
     *  一事务数据提交导致另一数据错误
     * 脏读：
     *  一事务读取另一事务的未提交的值
     * 不可重复读：
     *  一事务读取到了另一事务修改前后的值
     * 幻读：
     *  一事务读取到了另一事务修改前后的行数
     *
     * 事务隔离：
     *  读取未提交的数据：
     *      会产生：所有并发异常
     *  读取提交的数据：
     *      会产生：第二类丢失更新，不可重复读，幻读
     *  重复读：
     *      会产生：幻读
     *  串行化：
     *      不会产生并发异常
     *
     * 实现机制：
     *  悲观锁：
     *      共享锁：事务只能共享，不能排他
     *      排他锁：数据只能由这个事务使用
     *  乐观锁：
     *      若版本号变化则不能更新数据
     *
     * Spring的事务管理：
     *  声明式事务：
     *      由XML或注解配置，作用于全局
     *  编程式事务：
     *      通过TransactionTemplate配置，作用于局部
     */


    @Autowired
    private AlphaService alphaService;

    /**@Test
    public void testSave1() {
        Object obj = alphaService.save1();
        System.out.println(obj);
    }

    @Test
    public void testSave2() {
        Object obj = alphaService.save2();
        System.out.println(obj);
    }
    */
}
