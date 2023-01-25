package practice;

public class GenericMethods {
	//caller
public static void main(String[] args) {
	add(10,20);
	add(20,30);
	int c=add(67,40);
	System.out.println(c);
	int c1=sub(100, 30);
	System.out.println(c1);
	int c2=multi(105, 10);
	System.out.println(c2);
}
//called
public static int add(int a,int b) {
	int c=a+b;
	return c;
}	
	
//called
public static int sub(int a,int b) {
	int c=a-b;
	return c;
	
}
	
public static int multi(int a,int b) {
	int c=a*b;
	return c;
}
}

