package ReceiveFile1;
import java.io.*;
import java.net.*;
public class ReceiveFile1
{
	public byte[] ReceiveBytes(Socket s)
	{
		byte[] barray="".getBytes();
		try
		{
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			barray=(byte [])ois.readObject();

			System.out.println("Object recieved in byte form");
			return(barray);
		}
		catch (Exception ex)
		{
			System.err.println(ex);
		}
		return(barray);
	}
	public void ReceiveFile(Socket s,String filename)
	{
		try
		{
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			byte[] barray=(byte [])ois.readObject();

			System.out.println("Object recieved in byte form");
			File f=new File(filename);
			f.createNewFile();
			OutputStream file=new FileOutputStream(filename);
			DataOutputStream writer=new DataOutputStream(file);
			file.write(barray);
			file.flush();
			file.close();
			System.out.println("File accepted successfully");
			//return(barray);
		}
		catch (Exception ex)
		{
			System.err.println(ex);
		}
	}
	public String ReceiveMsg(Socket s)
	{
		String str="";
		try
		{
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			byte[] barray=(byte [])ois.readObject();

			System.out.println("Object recieved in byte form");
			str=new String(barray);
			return(str);
		}
		catch (Exception ex)
		{
			System.err.println(ex);
		}
		return(str);
	}


}
