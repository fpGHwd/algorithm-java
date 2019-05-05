package com.itcast.object.p108;

class Outer{
	
	
	int x = 3;
	class Inner{
		
		void function()
		{
			System.out.println("inner : " + x);
		}
		
	}
	
	void method(){
		
		Inner in = new Inner();
		
		in.function();
	}
	
}


class InnerClassDemo{

	public static void main(String[] args)
	{
	
		Outer out = new Outer();
		out.method();
	}

}