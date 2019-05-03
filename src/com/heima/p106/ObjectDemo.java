package com.heima.p106;

class Demo{
	
	private int num;
	Demo(int num){
		this.num = num;
	}
	
	
	public boolean equals(Object obj){
		
		if(!(obj instanceof Demo)){
			return false;
		}
		Demo d = (Demo)obj;
		return this.num == d.num;
	}
	
}


class Person{
	
	
}

class ObjectDemo{
	
		public static void main(String[] args){
			
			Demo d = new Demo(2);
			/*
			Demo d1 = new Demo(2);
			Demo d2 = new Demo(3);
			Person p = new Person();
			
			System.out.println(d.equals(d1));
			System.out.println(d.equals(d2));
			System.out.println(d.equals(p));
			*/
			Class c = d.getClass();
			System.out.println(c.toString()); // class demo
			for(int i = 0; i < c.getMethods().length; i++){
				System.out.println(c.getMethods()[i]);
			}
			// 反射 - 反编译

			System.out.println(d.toString());
			System.out.println(d.hashCode());
			System.out.println(Integer.toHexString(d.hashCode()));

		}

}