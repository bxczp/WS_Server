package com.java1234.webservice;

public class Test {
	
	public static void main(String args[]){
		int sum=0;
		for(int i=1;i<=10;i++){
			int sum1=1;
			for(int j=1;j<=i;j++){
				sum1=sum1*j;				
			}
			System.out.println("sum1="+sum1);
			sum=sum+sum1;
		}
		System.out.println("1到10的阶乘之和为"+sum);
	}

}

