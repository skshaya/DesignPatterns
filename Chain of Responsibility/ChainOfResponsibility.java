package chain.of.responsibility;

public class ChainOfResponsibility {

    
    public static void main(String[] args) {
        Login login=new Login("kamal", "133");
        
        Handler1 handler1=new Handler1();
        Handler2 handler2=new Handler2();
        Handler3 handler3=new Handler3();
        
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        
        handler1.handle(login);
    
}

class Login{
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}

interface Handler{
    public abstract void setNext(Handler handler);
    public abstract void handle(Login login);
}

class Handler1 implements Handler{
    
    Handler handler;

    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void handle(Login login) {
        if (login.getPassword()!=null) {
            System.out.println("Error 1");
        }else{
            handler.handle(login);
        }
    }
}
class Handler2 implements Handler{
    
    Handler handler;

    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void handle(Login login) {
        if (login.getPassword().length()<=5) {
            System.out.println("Error 2");
        }else{
            handler.handle(login);
        }
    }
}
class Handler3 implements Handler{
    
    Handler handler;

    @Override
    public void setNext(Handler handler) {
        this.handler=handler;
    }

    @Override
    public void handle(Login login) {
        if (login.getPassword().matches("^[0-9]+$")) {
            System.out.println("Error 3");
        }else{
            System.out.println("Success");
        }
    }
}
