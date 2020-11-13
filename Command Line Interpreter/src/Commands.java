
public class Commands {
	public String commandName ;
	public String arguments;
	
	public Commands() {
		commandName= new String("");
		arguments = new String ("");
	}
	public Commands(String cN, String args ) {
		commandName= cN;
		arguments = args;
	}
	public void getArguments() {
		System.out.println(arguments);
	}
	
}
