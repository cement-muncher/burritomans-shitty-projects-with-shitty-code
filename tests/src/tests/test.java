package tests;

public class test implements iface {
	public int sum(int a, int b ) throws Throwable {
l		if (a+b == 2) throw new Throwable("uh oh",new java.lang.AssertionError());
		return a+b;
	}
	
}
