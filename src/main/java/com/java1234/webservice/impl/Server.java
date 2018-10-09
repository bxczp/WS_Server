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
		// Endpoint.publish(address, implementor); // jdkʵ�� ��¶webservice�ӿ�
		JaxWsServerFactoryBean factoryBean=new JaxWsServerFactoryBean();
		factoryBean.setAddress(address); // ���ñ�¶��ַ
		factoryBean.setServiceClass(HelloWorld.class); // �ӿ���
		factoryBean.setServiceBean(implementor); // ����ʵ����
		factoryBean.getInInterceptors().add(new LoggingInInterceptor()); // ���in������ ��־������
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor()); // ���out������ ��־������
		
		factoryBean.getInInterceptors().add(new MyInterceptor());
		factoryBean.create(); // ����webservice�ӿ�
		System.out.println("web service started");
	}
}
