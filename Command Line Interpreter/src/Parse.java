package CMD;

public class Parse {

	public String arguments;
	public String cmdName;
	public int NoOfCmds;
	public String twoArgs[] = new String[10];
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
		
		 if(cmdName.equals("date") ||  cmdName.equals("clear")  || cmdName.equals("help")|| cmdName.equals("pwd"))
		{
			Cheker = ZeroArgCmd(cmdName , arg.length);
		}
		else if(cmdName.equals("more") ||cmdName.equals("cd") || cmdName.equals("rm") || cmdName.equals("mkdir") || cmdName.equals("rmdir") || cmdName.equals("args"))
		{
			Cheker = OneArgCmd(cmdName , arg.length);
			arguments=arg[1];
		}
		else if(cmdName.equals("cp") || cmdName.equals("mv") )
		{
			Cheker = TwoArgCmd(cmdName , arg.length);
			twoArgs[0]=arg[1];
			twoArgs[1]=arg[2];
		}
		else if(cmdName.equals("ls")) {
			Cheker = true;
			int l=1;
			for(int i=0;i<(arg.length-1);i++) {
				twoArgs[i]=arg[l];
				l++;
			}
		}

		else if(cmdName.equals("cat"))
		{
			Cheker = true;
			int l=1;
			for(int i=0;i<(arg.length-1);i++) {
				twoArgs[i]=arg[l];
				l++;
			}
		}

		else
		{
			System.out.println("Invalid Command");
		}
		return  Cheker;
	}

}
