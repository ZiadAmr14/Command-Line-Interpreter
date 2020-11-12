import java.io.File;
import java.io.IOException;

public class Terminal{
//	public void cp(String sourcePath, String destinationPath ); 
//	public void mv(String sourcePath, String destinationPath); 
//	public void rm(String sourcePath); 
//	public void pwd(); //display current user directory
//	public void cat(String[] paths);  // print the file content & concatenate with other file(s) contents 
//  public void rmdir(String path); //remove directory
//	public void pipeOperator(function1,function2)// takes the output of the first command as a input for the second command
//	// Main implementation is up to you

    static String CurrentDirectory = "C:/";

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
}
