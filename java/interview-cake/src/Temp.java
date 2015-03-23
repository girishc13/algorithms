public class Temp {
	String name;

	public Temp(String personName) {
		name = personName;
	}

	public String greet(String yourName) {
		return String.format("Hi %s, my name is %s", name, yourName);
	}

	public static void main(String[] args) {
		Temp temp = new Temp("personName");
		String greet = temp.greet("name");
		System.out.println(greet);
	}

}
