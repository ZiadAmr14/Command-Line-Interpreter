
public class Parse {

	public String arguments;
	public String cmdName;

	public Parse()
	{
		cmdName = new String("");
		arguments = new String("");
	}

	public Parse(String Copy_CommandName,String Copy_CommandArgument)
	{
		cmdName = Copy_CommandName;
		arguments = Copy_CommandArgument;
	}

	public void getArguments() {
		System.out.println(arguments);
	}
	// Will be filled by the command extracted by parse method
	/** * Return: true if it was able to parse user input correctly. Otherwise false 
	 * Parameter input: user command 
	 * In case of success, it should save the extracted command and arguments to args and cmd variables 
	 * It should also print error messages in case of too few arguments for a commands 
	 * eg. “cp requires 2 arguments” */ 
//	public boolean parse(String input); 
//	public String getCmd(); 
//	public String[] getArguments();
}
