package CMD;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Terminal{
	ArrayList<Parse> allCommands ;
	static String CurrentDirectory = "C:/";
	public Terminal() {
		allCommands= new ArrayList<Parse>();
		Parse c = new Parse("cp","arg1: SourcePath, arg2: DestinationPath",2);//
		allCommands.add(c);
		c=new Parse("ls","no args",0);
		allCommands.add(c);
		c=new Parse("more","arg1: SourceFile",1);
		allCommands.add(c);
		c=new Parse("mv","arg1: SourcePath, arg2: DestinationPath",2);
		allCommands.add(c);
		c=new Parse("mkdir","arg1: SourcePath",1);
		allCommands.add(c);
		c=new Parse("args","arg1: commandName",1);
		allCommands.add(c);
		c=new Parse("date","no args",0);
		allCommands.add(c);
		c = new Parse("cd","arg1: IntendedDirectory",1);
		allCommands.add(c);
		c = new Parse("help","no args",0);
		allCommands.add(c);
		c = new Parse("clear","no args",0);
		allCommands.add(c);
	}

	/**
	 * 
	 * @param sourcePath of the file that will be copied
	 * @param destinationPath of the folder where the file will be copied
	 * @throws IOException
	 */
	public void cp(String sourcePath, String destinationPath ) throws IOException {
		ShortPath(sourcePath);
		InputStream is = null;
		OutputStream os = null;
		File source = new File(CurrentDirectory+".txt");//creating a reference to the copied file 
		String sourceFileName = source.getName();//get the name of the copied file to create new 
		//one in the destination path
		File dest = new File(destinationPath+"\\"+sourceFileName);
		//create the new file in the destination
		//with the same name

		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}
	public void more(String sourceFile) throws IOException {
		ShortPath(sourceFile);
		FileInputStream fstream = new FileInputStream(CurrentDirectory+".txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		Scanner in = new Scanner(System.in);
		String enterKey = "";
		while(enterKey.isEmpty()) {
			for(int i=0;i<10;++i) {
				if((strLine = br.readLine()) != null)   {
					System.out.println (strLine);
				}
			}
			enterKey = in.nextLine();
		}
		fstream.close();
		in.close();
	}

	/**
	 * 
	 * @param sourcePath of the file that will be cut
	 * @param destinationPath of the folder where the file will be cut
	 * @throws IOException
	 */
	public void mv(String sourcePath, String destinationPath)throws IOException {
		ShortPath(sourcePath);
		InputStream is = null;
		OutputStream os = null;
		File source = new File(CurrentDirectory+".txt");//creating a reference to the copied file 
		String sourceFileName = source.getName();//get the name of the copied file to create new 
		//one in the destination path
		File dest = new File(destinationPath+"\\"+sourceFileName);
		//create the new file in the destination
		//with the same name

		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
			source.delete();
		}

	}

	public void cd(String Copy_IntendedDirectory)
	{
		if(Copy_IntendedDirectory.equals("..")){
			File file = new File(CurrentDirectory);
			CurrentDirectory=file.getParentFile().getPath();
		}
		else
		{
			try{
				File file;
				if(isShortPath(Copy_IntendedDirectory)) {
					file = new File(CurrentDirectory+Copy_IntendedDirectory);
				}
				else {
					file = new File(Copy_IntendedDirectory);
				}

				if(file.exists()&&file.isDirectory())
				{
					ShortPath(Copy_IntendedDirectory);
				}
				else
				{
					System.out.println("Not A valid directory!");
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public void ls(String arg[])throws IOException
	{
		try
		{
			File file = new File(CurrentDirectory);

			if(arg[0]==null||arg[1]==null) 
			{
				File[] arrayOfFiles = file.listFiles();
				for(File F : arrayOfFiles)
				{

					System.out.println(F.getName());

				}
			}
			else
			{

				if(arg[0].equals(">>")) {
					File[] arrayOfFiles = file.listFiles();
					File f=new File(CurrentDirectory+"\\"+arg[1]);
					FileWriter fw=new FileWriter(f,true);
					BufferedWriter bw=new BufferedWriter(fw);
					for(File F : arrayOfFiles)
					{	

						bw.append(F.getName()+'\n');

					}
					bw.close();
					arg[0]=null;
					arg[1]=null;
				}       		
				else if(arg[0].equals(">")) {
					PrintWriter writer = new PrintWriter(CurrentDirectory+"\\"+arg[1]);
					writer.print("");
					writer.close();
					File[] arrayOfFiles = file.listFiles();
					BufferedWriter bw=new BufferedWriter(new FileWriter(CurrentDirectory+"\\"+arg[1]));
					for(File F : arrayOfFiles)
					{	

						bw.append(F.getName()+'\n');

					}
					bw.close();
					arg[0]=null;
					arg[1]=null;
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	public void rm(String filename) throws FileNotFoundException{
		ShortPath(filename);
		File file=new File(CurrentDirectory);
		file.delete();
	}
	public void cat(String[] filename) throws FileNotFoundException
	{
		try 
		{
			if(filename[1]==null){
				for(int i=0;i<filename.length;i++) {
					BufferedReader br=new BufferedReader(new FileReader(CurrentDirectory+'\\'+filename[i]));
					if(filename[i]!=null) {
						String line;
						while((line=br.readLine())!=null) {
							System.out.println(line);
						}
						br.close();
					}

					else
						break;
				}
			}





			else if(filename[1].equals(">>")) {
				Scanner in=new Scanner(System.in);
				File file = new File(CurrentDirectory+"\\"+filename[0]);
				FileWriter fw=new FileWriter(file,true);
				BufferedWriter bw=new BufferedWriter(fw);
				while(true) {
					String input=in.next();
					if(input.equalsIgnoreCase("z"))
					{
						break;
					}
					else {
						bw.write(input+"\n");
					}
				}
				bw.close();
				filename[0]=null;
				filename[1]=null;

			}

			else if(filename[1].equals(">")){
				Scanner in=new Scanner(System.in);
				File file = new File(CurrentDirectory+"\\"+filename[0]);
				FileWriter fw=new FileWriter(file,false);
				BufferedWriter bw=new BufferedWriter(fw);
				String input=null;
				while(true) {
					input=in.next();
					if(input.equalsIgnoreCase("z"))
					{
						break;
					}
					else {
						bw.write(input+"\n");
					}
				}
				bw.close();
				filename[0]=null;
				filename[1]=null;
			}


		}
		catch (Exception e) {

		}

	}

	public void args(String commName) {
		int commIndex=-1;
		for (int i=0; i < allCommands.size(); i++) {
			if(allCommands.get(i).cmdName.equals(commName)) {
				allCommands.get(i).getArguments();
				commIndex=i;
				break;
			}
		}
		if(commIndex==-1) {
			System.out.println("This command doesn't exist");
		}
		return;
	}
	public void mkdir(String dirname) {
		File newDir = new File(dirname); 

		if (newDir.mkdir()) { 

			// display that the directory is created 
			// as the function returned true 
			System.out.println("Directory is created"); 
		} 
		else { 
			// display that the directory cannot be created 
			// as the function returned false 
			System.out.println("Directory cannot be created"); 
		} 
	}

	public void rmdir(String fileName) throws FileNotFoundException
	{	
		try {
			File file=new File(CurrentDirectory+'\\'+fileName);
			if(file.length()==0) {
				file.delete();
				System.out.println("file deleted Successfully");
			}
			else {
				System.out.println("file isn't empty");
			}
		}
		catch(Exception e){
			System.out.println("file name isn't correct");
		}
	}
	public void pwd()
	{
		System.out.println(CurrentDirectory);
	}
	public void date() {
		Date date=java.util.Calendar.getInstance().getTime();  
		System.out.println(date);  
	}

	public void help()
	{
		System.out.println("Clear  ----> Clears Command Line Interpreter");
		System.out.println("cd Directory/File1/File2/..  ------------> Changes your Directory and points to your desired Directory");
		System.out.println("ls  ----> List All files in your Current Directory");
		System.out.println("pwd  ----------> Prints your Current Directory");
		System.out.println("date    ---------------> Prints Current Date");
		System.out.println("mkdir -p first/second/third  -----------> Makes a directory in your system with a parent file and children");
		System.out.println("Rmdir ------>delete a directory , Takes 1 Arguments which is the directory name and check if it empty and deletes it");
		System.out.println("Cat -----------------> Concatenate files and print on the standard output ");
		System.out.println("more ------------> display and scroll down the output in one direction only ");
		System.out.println("rm-------------> delete file , Takes 1 Arguments which is the Path of the file");
		System.out.println("cp---------->copy the file to new directory, using Source Path and destination path ");
		System.out.println("mv---------------> move the file to a new directory, using Source Path and destination Path");
	}

	public static void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void ShortPath(String string1)
	{
		boolean Flag = isShortPath(string1);
		if(Flag == true)
		{
			CurrentDirectory+= '\\' + string1;

		}
	}
	public boolean isShortPath(String string1) {
		boolean Flag = true;
		for (int i=0;i<string1.length();i++)
		{
			if(string1.charAt(i)==':')
			{
				Flag = false;
				CurrentDirectory=string1;
				break;
			}
		}
		return Flag;
	}
}