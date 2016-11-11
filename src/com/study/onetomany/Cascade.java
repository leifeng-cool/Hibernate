package com.study.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.study.entity.User;
import com.study.hibernateUtils.HibernateUtils;

/*
 * 一对多的级联保存
 */
public class Cascade {
	@Test
	public void Save() {
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
		
		//添加一个代理商，为代理商添加一个客户
		//1.创建代理商和客户对象
		Customs customs = new Customs();
		customs.setcName("E");
		customs.setcGender("男");
		customs.setcLevel("c");
		customs.setcPhone("123213");
		
		Agents agents = new Agents();
		agents.setaName("大发");
		agents.setaPhone("110123");
		agents.setaGender("男");
		//2.在客户中表示代理商，在代理商中表示客户
		//建立客户对象与代理商对象的关系
		//2.1把客户放到代理商对象的set集合里
		agents.getsCustoms().add(customs);
		//2.2把代理商放到客户对象里
		customs.setAgents(agents);
		//3将两个对象保存到数据库
		session.save(customs);
		session.save(agents);
		
		//6.提交事务
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			//7.关闭资源
			if (session!=null) {
				session.close();
			}
		}
	}
	/*
	 * 在hibernate核心配置文件中的set中配置cascade属性save-update/all
	 */
	@Test
	public void SimpleSave() {
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
		
		//添加一个代理商，为代理商添加一个客户
		//1.创建代理商和客户对象
		Customs customs = new Customs();
		customs.setcName("F");
		customs.setcGender("女");
		customs.setcLevel("vip");
		customs.setcPhone("688666");
		
		Customs customs1 = new Customs();
		customs1.setcName("G");
		customs1.setcGender("女");
		customs1.setcLevel("c");
		customs1.setcPhone("999654");
		
		Agents agents = new Agents();
		agents.setaName("小胡");
		agents.setaPhone("125655");
		agents.setaGender("男");
		//2.在客户中表示代理商，在代理商中表示客户
		//建立客户对象与代理商对象的关系
		//2.1把客户放到代理商对象的set集合里
		agents.getsCustoms().add(customs);
		agents.getsCustoms().add(customs1);
		//3将两个对象保存到数据库
		session.save(agents);
		
		//6.提交事务
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			//7.关闭资源
			if (session!=null) {
				session.close();
			}
		}
	}
	@Test
	public void Delete() {
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
		//1.根据id查询要删除的对象
		Agents agents = session.get(Agents.class, 7);
		//Customs customs = session.get(Customs.class, 3);
		//2.调用方法删除
		session.delete(agents);
		
		//6.提交事务
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			//7.关闭资源
			if (session!=null) {
				session.close();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
