import SendFile1.*;
import ReceiveFile1.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;


class stat
{
static int count=0;
}
public class finalctcs
	{
	static String name;
	static String st1="";
	public static void main(String []args)
		{
		System.out.println("Listening....");
		ServerSocket ss=null;
		Socket[] s=new Socket[100];
		try{
		ss=new ServerSocket(1234);
			}
			catch(IOException e)
			{
			System.out.println(e.getMessage());
			}
			String[] namarr=new String[100];
		while(true)
			{
			try{
			s[stat.count]=ss.accept();
			System.out.println(s[stat.count].getInetAddress());
			System.out.println(s[stat.count].getPort());
			System.out.println("Connection Established...");
			
			ReceiveFile1 re = new ReceiveFile1();
			String str = re.ReceiveMsg(s[stat.count]);
			
			System.out.println(str);
			
			ServerThread st=new ServerThread(s,namarr);
			st.setName(str);
			namarr[stat.count]=str;
			stat.count++;
			st.start();
				}
				catch(IOException e){System.out.println(e.getMessage());}
			}
			
			
		}
	}
class ServerThread extends Thread
{
String st1="",s2="",st3="";
Socket[] s=null;
String[] namarr=null;
String key = "";
String temp ="";
Socket sp = null;
ServerThread(Socket s[],String[] namarr)
	{
	this.s=s;
	this.namarr=namarr;
	
	}
public void run() 
	{
		int i;
		ReceiveFile1 re = new ReceiveFile1();
		SendFile1 se = new SendFile1();
		
		Socket  konakadun = s[stat.count-1];
		temp =  re.ReceiveMsg(konakadun);
		System.out.println(temp);
		String kk = namarr[stat.count-1];
		for(i=0;i<stat.count;i++)
		{			System.out.println(namarr[i]+ "      " + temp);
			
			if(temp.equals(namarr[i]))
				break;
		}
		sp = s[i];
		while(true)
		{
			
			st3 =re.ReceiveMsg(konakadun);
			System.out.println(st3);
						
			se.SendMessege(sp, st3);
			//se.SendMessege(sp, kk);
			if(st3.equals("2"))
				se.SendMessege(sp, re.ReceiveMsg(konakadun));
			
			byte[] str = re.ReceiveBytes(konakadun);

			se.SendBytes(sp,str);
			
		}
		
	}

}
