package com.heima.p104;
/*

class MainBoard
{
	public void run(){
		System.out.println("main board runs");
		//useNetCard(new NetCard());
	}
	
	public void useNetCard(NetCard nc){
		nc.open();
		nc.close();
	}
}

class NetCard{
	public void open(){
		
		System.out.println("netcard open");
	}
	
	public void close(){
		
		System.out.println("netcard close");
	}
}

*/

interface PCI{
	
	public void open();
	public void close();
	
}

// 不是主板实现PCI
class MainBoard{
	public void run(){
		System.out.println("mainboard runs");
	}
	
	public void usePCI(PCI pci){
		// check pci
	if(pci != null){
		pci.open();
		pci.close();
	}
	}
	
}

class NetCard implements PCI{
	public void open(){
		
		System.out.println("netcard open");
	}
	
	public void close(){
		
		System.out.println("netcard close");
	}
}

class DuoTaiDemo5
{
	public static void main(String[] args){
		// System.out.println("");
		MainBoard mb = new MainBoard();
		mb.run();
		PCI p = new NetCard();
		mb.usePCI(p);
		/*
		NetCard nc = new NetCard();
		mb.useNetCard(nc);
		*/
		
		
	}
}