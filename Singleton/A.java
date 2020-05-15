package Singleton;


public class A {

    static private String a;

    private A() {
    }

    public static  synchronized String getA() {
        if (a==null) {
			synchronized(A.class){
            	a = "Retuned A";
			}
        }
        return a;
    }
}

class C{
    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        
        t1.start();
        t2.start();
    }
}

class T extends Thread{
    @Override
    public void run(){
        System.out.println(A.getA());
    };
}
