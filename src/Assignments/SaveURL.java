package Assignments;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL; 
import java.util.Scanner;

/**
 * Saves HTML Data from URL to a file.
 * @author Tarek
 *
 */
public class SaveURL {
	
	private InputStream inStr = null;
	private OutputStream outStr = null;
	private URL url = null;
	
	
	/**
	 * Read URL Data and Saves it to a local file.
	 */
	public void SaveURLData() 
	{
		String urlStr = this.ReadString("Enter URL: ");
		String fileName = this.ReadString("Enter File Name: ");

		try 
		{
			url = new URL(urlStr);
			inStr = url.openStream();
			outStr = new FileOutputStream(fileName);
			SaveURL.copyStream(inStr, outStr);
			inStr.close();
			outStr.close();
			System.out.println("Data were saved Correctly.");
		}
		
		catch(MalformedURLException  e)
		{
			System.out.println("This is not a legal URL.");
		}
		
		catch(IOException e) 
		{
			System.out.println("There's no such website.");
		}
		

	}
	
	private static void copyStream(InputStream in, OutputStream out) 
			throws IOException {
		int oneByte = in.read();
		while (oneByte >= 0) { // negative value indicates end-of-stream
			out.write(oneByte);
			oneByte = in.read();
		}
	}
	
	
	private String ReadString(String str) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(str);
		
		String readStr = scanner.nextLine();
		
		return readStr;
	}
}
