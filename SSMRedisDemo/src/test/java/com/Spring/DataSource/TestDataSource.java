package com.Spring.DataSource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {



@SuppressWarnings("resource")
@Test
public void testDataSources() throws SQLException{
ApplicationContext ac = null;
{
ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
}
DataSource dataSource=ac.getBean(DataSource.class);
System.out.println(dataSource.getConnection());
}
}

