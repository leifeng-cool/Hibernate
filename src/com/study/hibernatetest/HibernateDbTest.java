package com.study.hibernatetest;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.study.entity.User;
import com.study.hibernateUtils.HibernateUtils;


public class HibernateDbTest {
	@Test
	public void testAdd(){
		//1.加载配置文件：classpath：hibernate.cfg.xml
		//Configuration config = new Configuration().configure();
		
		//2.创建链接工厂
		//SessionFactory sFactory = config.buildSessionFactory();
		//会话对象，表示与数据库的链接会话过程，相当于jdbc的connection链接对象
		
		//使用创建好的工具类获取SessionFactory
		
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		
		Session session = null;
		Transaction tx = null;
		try{
		//3.使用SessionFactory创建session对象，获取会话对象
		session = sFactory.openSession();
		
		//4.打开事务：hibernate默认数据操作是不提交事务的，所以要手动提交事务
		tx = session.beginTransaction();
		
		//5.写具体逻辑，进行CRUD操作
		User user = new User();
		user.setUsername("jack");
		user.setAge(22);
		user.setAddress("美国");
		session.save(user);
		//6.提交事务
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			//7.关闭资源
			if (session!=null) {
				session.close();
				sFactory.close();
			}
		}
	}
}

