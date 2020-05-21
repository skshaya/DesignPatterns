package Memento;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		Caretaker c = new Caretaker();
		
		User u1 = new User(1, "Amal", "Colombo");
		u1.saveMemento(c);
		u1.viewDetails();
		
		u1.setCity("Kandy");
		u1.saveMemento(c);
		u1.viewDetails();
		
		u1.setCity("Gampaha");
		u1.saveMemento(c);
		u1.viewDetails();
		
		u1.restoreMemento(c.getMemento(1));
		u1.viewDetails();
		
	}
}

class User {
	
	private int id;
	private String name;
	private String city;
	
	public User(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void viewDetails() {
		System.out.println(id + "," + name + "," + city);
	}
	
	public void saveMemento(Caretaker c) {
		Memento m = new Memento(id, name, city);
		c.addMemento(m);
	}
	
	public void restoreMemento(Memento m) {
		this.id = m.getId();
		this.name = m.getName();
		this.city = m.getCity();
	}
	
	static class Memento {
		
		
		private final int id;
		private final String name;
		private final String city;
		
		
		public Memento(int id, String name, String city) {
			this.id = id;
			this.name = name;
			this.city = city;
		}
		
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public String getCity() {
			return city;
		}
		
	}
}

class Caretaker {
	
	private final ArrayList<User.Memento> mementoes = new ArrayList<>();
	
	public void addMemento(User.Memento m) {
		this.mementoes.add(m);
	}
	
	public User.Memento getMemento(int index) {
		return this.mementoes.get(index);
	}
	
}
