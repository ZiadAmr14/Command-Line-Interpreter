import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
<<<<<<< HEAD
import java.io.PrintStream;
import java.io.Reader;
=======
import java.util.Vector;
>>>>>>> branch 'main' of https://github.com/ZiadAmr14/Command-Line-Interpreter.git

public class Terminal{
	static String CurrentDirectory = "C:/";
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

//	public void rm(String sourcePath); 
//	public void pwd(); //display current user directory
//	public void cat(String[] paths);  // print the file content & concatenate with other file(s) contents 
//  public void rmdir(String path); //remove directory
//	public void pipeOperator(function1,function2)// takes the output of the first command as a input for the second command
//	// Main implementation is up to you


    public void ChangeDirectory(String Copy_IntendedDirectory)
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

    public void List() throws IOException
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
    	
    public void Help()
	{
		System.out.println("Clear  ----> Clears Command Line Interpreter");
		System.out.println("cd Directory/File1/File2/..  ------------> Changes your Directory and points to your desired Directory");
		System.out.println("ls  ----> List All files in your Current Directory");
		System.out.println("pwd  ----------> Prints your Current Directory");
		System.out.println("date    ---------------> Prints Current Date");
		System.out.println("mkdir -p first/second/third  -----------> Makes a directory in your system with a parent file and children");
		System.out.println("Rmdir ------>delete a directory in specfic path, Takes 1 Arguments which is the new Path of the directory");
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
