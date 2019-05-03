package com.heima.DuotaiDemo1;

class Fu{
	static int num = 5;
	
	void method_1(){
		System.out.println("Fu method_1");
	}
	
	void method_2(){
		System.out.println("Fu method_2");
	}
	
	static void method_4(){
		System.out.println("Fu method_4");
	}
}

class Zi extends Fu
{
	
	static int num = 7;
	void method_1(){
		System.out.println("Zi method_1");
	}
	
	void method_2(){
		System.out.println("Zi method_2");
	}
	
	void method_3(){
		System.out.println("Zi method_3");
	}
	
	static void method_4(){
		System.out.println("Zi method_4");
	}
}

class DuoTaiDemo4
{
	public static void main(String[] args){
		/*
		Fu fu = new Fu();
		fu.method_1();
		
		Fu fu1 = new Zi();
		fu1.method_1();
		*/
		
		/*
		Fu fu = new Fu();
		fu.method_4();
		Fu fu1 = new Zi();
		fu1.method_4();
		*/
		
		/*
		Zi zi = new Zi();
		zi.method_4();
		*/
		
		Fu fu = new Fu();
		System.out.println(fu.num);
		Fu fu1 = new Zi();
		System.out.println(fu1.num);
		Zi zi = new Zi();
		System.out.println(zi.num);
		
	}
}