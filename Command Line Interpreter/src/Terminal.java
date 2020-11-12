import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Terminal{ 
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
	public void ls(String currentDirectory) {
		
	}
//	public void pwd(); 
//	public void cat(String[] paths); // Add any other required command in the same structure…..
}
