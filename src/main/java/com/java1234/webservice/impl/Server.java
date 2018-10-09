package com.java1234.webservice.impl;



import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.java1234.interceptor.MyInterceptor;
import com.java1234.webservice.HelloWorld;

public class Server {

	public static void main(String[] args) {
		System.out.println("web service start");
		HelloWorld implementor=new HelloWorldImpl();
		String address="http://192.168.1.103/helloWorld";
		// Endpoint.publish(address, implementor); // jdk实现 暴露webservice接口
		JaxWsServerFactoryBean factoryBean=new JaxWsServerFactoryBean();
		factoryBean.setAddress(address); // 设置暴露地址
		factoryBean.setServiceClass(HelloWorld.class); // 接口类
		factoryBean.setServiceBean(implementor); // 设置实现类
		factoryBean.getInInterceptors().add(new LoggingInInterceptor()); // 添加in拦截器 日志拦截器
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor()); // 添加out拦截器 日志拦截器
		
		factoryBean.getInInterceptors().add(new MyInterceptor());
		factoryBean.create(); // 创建webservice接口
		System.out.println("web service started");
	}
}
