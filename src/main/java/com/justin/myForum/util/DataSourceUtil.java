package com.justin.myForum.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * 数据库连接池DBCP 封装DataSourceUtil
 */
public class DataSourceUtil {
    private static DataSource dataSource;
    static{
        try{
            InputStream in = DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");
            Properties p = new Properties();
            p.load(in);
            dataSource = BasicDataSourceFactory.createDataSource(p);

        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化DBCP失败");
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }



}
