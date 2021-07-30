package com.wuzhao.test;

import com.wuzhao.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @auther legionwu
 * @create 2021-04-22 7:59
 */
public class JdbcUtilsTest {
    @Test
    public void JdbcUtilsTest(){
        //连接后要及时关闭（释放），否则只能连接配置文件规定的最大连接数
/*        for(int i=0;i<100;i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }*/
    }
}
