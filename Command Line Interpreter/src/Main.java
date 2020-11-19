package CMD;

import java.io.IOException;
import java.util.Scanner;

public class Main {
//	System.out.println("Enter the name of the source file ");  
//	String source = in.next();
//	System.out.println("Enter the name of the destination folder ");
//	String dest = in.next();
//	t.mv(source, dest);
//	System.out.println("Done");
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner (System.in);
		Terminal t1 = new Terminal();
	    Parse p1 = new Parse();
		while (true)
		{
			String s = in.nextLine();
			if(s.equalsIgnoreCase("z")) {
				break;
			}
			else if(p1.parse(s))
			{
				if(p1.cmdName.equals("pwd"))
				{
					t1.pwd();
				}
				else if(p1.cmdName.equals("help"))
				{
					t1.help();
				}
				else if(p1.cmdName.equals("date"))
				{
					t1.date();
				}
				else if(p1.cmdName.equals("clear"))
				{
					t1.clear();
				}
				else if(p1.cmdName.equals("more"))
				{
					t1.more(p1.arguments);
				}
				else if(p1.cmdName.equals("cd"))
				{
					t1.cd(p1.arguments);
				}
				else if(p1.cmdName.equals("rm"))
				{
					t1.rm(p1.arguments);
				}
				else if(p1.cmdName.equals("ls"))
				{
					t1.ls(p1.twoArgs);
				}
				else if(p1.cmdName.equals("mkdir"))
				{
					t1.mkdir(p1.arguments);
				}
				else if(p1.cmdName.equals("rmdir"))
				{
					t1.rmdir(p1.arguments);
				}
				else if(p1.cmdName.equals("args"))
				{
					t1.args(p1.arguments);
				}
				else if(p1.cmdName.equals("cp"))
				{
					t1.cp(p1.twoArgs[0],p1.twoArgs[1]);
				}
				else if(p1.cmdName.equals("mv"))
				{
					t1.mv(p1.twoArgs[0],p1.twoArgs[1]);
				}
				else if(p1.cmdName.equals("cat"))
				{
					t1.cat(p1.twoArgs);
				}
		}

	}

	}
}
