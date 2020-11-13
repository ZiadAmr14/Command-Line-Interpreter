
public class Parse {

	public String arguments;
	public String cmdName;
	public int NoOfCmds;

	private String[] arg = new String[100] ;

	public Parse()
	{
		cmdName = new String("");
		arguments = new String("");
		NoOfCmds = 0;
	}

	public Parse(String Copy_CommandName,String Copy_CommandArgument,int Copy_NoOfCmds)
	{
		cmdName = Copy_CommandName;
		arguments = Copy_CommandArgument;
		NoOfCmds = Copy_NoOfCmds;
	}

	public void getArguments() {
		System.out.println(arguments);
	}

	public String getCommand ()
	{
		return cmdName;
	}

	public boolean ZeroArgCmd(String Copy_CommandName, int Copy_NoOfCmds)
	{
		if(Copy_NoOfCmds == 1)
		{
			return true;
		}
		else
		{
			System.out.println("This Command Takes No Arguments");
			return false;
		}
	}

	public boolean OneArgCmd(String Copy_CommandName,int Copy_NoOfCmds)
	{
		if(Copy_NoOfCmds == 2)
		{
			return true;
		}
		else
		{
			System.out.println("This Command Takes One Argument");
			return false;
		}
	}

	public boolean TwoArgCmd(String Copy_CommandName,int Copy_NoOfCmds)
	{
		if(Copy_NoOfCmds == 3)
		{
			return true;
		}
		else
		{
			System.out.println("This Command Takes Two Arguments");
			return false;
		}
	}

	public boolean parse(String InputCommand)
	{
		boolean Cheker = false;
		arg = InputCommand.split(" ");
		cmdName = arg[0];

		if(cmdName.equals("date") ||  cmdName.equals("clear")  || cmdName.equals("help"))
		{
			Cheker = ZeroArgCmd(cmdName , arg.length);
		}
		else if(cmdName.equals("more") ||cmdName.equals("rm") || cmdName.equals("mkdir") || cmdName.equals("rmdir") || cmdName.equals("args"))
		{
			Cheker = OneArgCmd(cmdName , arg.length);
		}
		else if(cmdName.equals("cb") || cmdName.equals("mv"))
		{
			Cheker = TwoArgCmd(cmdName , arg.length);
		}

		else if(cmdName.equals("cat"))
		{
			Cheker = true;
		}

		else
		{
			System.out.println("Invalid Command");
		}
		return  Cheker;
	}

}
