package com.study.hibernateUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration config =null;
	private static SessionFactory sFactory =null;
	
	//使用静态代码块实现，在类加载的时候执行，并只执行一次
	static{
	//1.加载核心配置文件
	config = new Configuration().configure();
	//2.创建链接工厂
	sFactory = config.buildSessionFactory();
	}
	
	//创建一个方法返回SessionFactory对象
	public static SessionFactory getSessionFactory(){
		return sFactory;
	}
	
	public static void main(String[] args) {
		
	}
}
