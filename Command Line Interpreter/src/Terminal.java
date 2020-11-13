import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
public class Terminal{
	ArrayList<Commands> allCommands ;
	static String CurrentDirectory = "C:/";
	public Terminal() {
		allCommands= new ArrayList<Commands>();
		Commands c = new Commands("cp","arg1: SourcePath, arg2: DestinationPath");//
		allCommands.add(c);
		c=new Commands("ls","no args");
		allCommands.add(c);
		c=new Commands("more","arg1: SourceFile");
		allCommands.add(c);
		c=new Commands("mv","arg1: SourcePath, arg2: DestinationPath");
		allCommands.add(c);
		c=new Commands("mkdir","arg1: SourcePath");
		allCommands.add(c);
		c=new Commands("args","arg1: commandName");
		allCommands.add(c);
		c=new Commands("date","no args");
		allCommands.add(c);
		
	}
	/*
	 * cd
	 * cat
	 * Pipe Operator
	 * Redirect Operator <
	 * Redirect Operator <<
	 * rmdir
	 * rm
	 * help
	 * pwd
	 * clear
	 */
	/**
	 * 
	 * @param sourcePath of the file that will be copied
	 * @param destinationPath of the folder where the file will be copied
	 * @throws IOException
	 */
	public void cp(String sourcePath, String destinationPath ) throws IOException {
		
	    InputStream is = null;
	    OutputStream os = null;
	    File source = new File(sourcePath+".txt");//creating a reference to the copied file 
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
		FileInputStream fstream = new FileInputStream(sourceFile+".txt");
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
		
	    InputStream is = null;
	    OutputStream os = null;
	    File source = new File(sourcePath+".txt");//creating a reference to the cut file 
	    String sourceFileName = source.getName();//get the name of the cut file to create new 
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
        try{
            File file = new File(Copy_IntendedDirectory);

            if(file.isDirectory())
            {
                CurrentDirectory = Copy_IntendedDirectory;
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

    public void ls() throws IOException
    {
        try
        {
            File file = new File(CurrentDirectory);
            File[] arrayOfFiles = file.listFiles();
            for(File F : arrayOfFiles)
            {
                if(F.isDirectory() || F.isFile())
                {
                    System.out.println(F.getName());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void cat(String fileName,String fileName1) throws FileNotFoundException
    {
    	if(fileName1.equals("")) {
    		BufferedReader br=new BufferedReader(new FileReader(fileName));
    		try	 {
    			String line;
    			while((line=br.readLine())!=null) {
    				System.out.println(line);
    			}
    			br.close();
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			//System.out.println("file Name isn't correct");
			}
    		
    		}
    	else {
    		BufferedReader br=new BufferedReader(new FileReader(fileName));
    		try	 {
    			String line;
    			while((line=br.readLine())!=null) {
    				System.out.println(line);
    			}
    			br=new  BufferedReader(new FileReader(fileName1));
    			while((line=br.readLine())!=null) {
    				System.out.println(line);
    			}
    			br.close();
    		}
    		catch (Exception e) {
    			System.out.println("file Name isn't correct");
			}
        	
    	}
    }
    public void args(String commName) {
    	int commIndex=-1;
    	for (int i=0; i < allCommands.size(); i++) {
			if(allCommands.get(i).commandName.equals(commName)) {
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
    public void mkdir(String dirPath) {
        File newDir = new File(dirPath); 
  
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
    		
    		File file=new File(fileName);
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

	public static String ShortPath(String string1)
	{
		boolean Flag = true;
		String string2 = CurrentDirectory;
		for (int i=0;i<string1.length();i++)
		{
			if(string1.charAt(i)==':')
			{
				Flag = false;
				break;
			}
		}
		if(Flag == true)
		{
			string2 = CurrentDirectory +'/' + string1;
			return  string2;
		}
		else
		{
			return string1;
		}

	}
}