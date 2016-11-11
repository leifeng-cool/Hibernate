package com.study.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.study.entity.User;
import com.study.hibernateUtils.HibernateUtils;


/*
 * hibernate的crud
 */
public class HibernateDbDemo {
	@Test
	public void Delete() {
		//1.获取SessionFactory对象
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		//2.获取Session对象
		Session session = sFactory.openSession();
		//3.开启事务
		Transaction tx = session.beginTransaction();
		
		//4.删除操作
		//第一种方式，根据id查询出对象类型
	 	/*
	 	 * User user = session.get(User.class, 3);
	 	   session.delete(user);
	 	 */
		
		//第二种方式
		User user = new User();
		user.setUid(4);
		session.delete(user);
		
		
		//5.提交事务
		tx.commit();
		//6.关闭资源
		session.close();
	}
	
	@Test
	public void Update() {
		//1.获取SessionFactory对象
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		//2.获取Session对象
		Session session = sFactory.openSession();
		//3.开启事务
		Transaction tx = session.beginTransaction();
		
		//4.修改操作
		//修改id值=2的username
		//4.1根据id查询需要修改的值
		User user = session.get(User.class, 3);
		//4.2向返回的user设置需要修改的值
		user.setUsername("jane");
		//4.3调用session中的update的方法
		session.update(user);
		
		//5.提交事务
		tx.commit();
		//6.关闭资源
		session.close();
	}
	
	@Test
	public void SelectById() {
		//1.获取SessionFactory对象
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		//2.获取Session对象
		Session session = sFactory.openSession();
		//3.开启事务
		Transaction tx = session.beginTransaction();
		
		//4.根据主键id查询
		//调用session里中的get方法,第一个参数，实体类的参数；第二个参数：id值
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		//5.提交事务
		tx.commit();
		//6.关闭资源
		session.close();
	}
}
