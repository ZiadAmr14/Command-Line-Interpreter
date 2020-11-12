import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

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
}
