//package audioip;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.*;
public class audT extends Thread
	{
	private boolean running=true;
	final ByteArrayOutputStream out= new ByteArrayOutputStream();
	public void run()
		{
		AudioFormat format=new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
		try{
		DataLine.Info info=new DataLine.Info(TargetDataLine.class,format);
		final TargetDataLine targetline=(TargetDataLine)AudioSystem.getLine(info);
		targetline.open();
		targetline.start();
		
		byte[] data=new byte[targetline.getBufferSize()/5];
		int readbytes;
		 	 while(running)
			  	{
			  	readbytes=targetline.read(data,0,data.length);
			  	out.write(data,0,readbytes);
		  		}
		 	 targetline.close();
		 	 
		   }
		   catch(Exception e){System.out.println(e.getMessage());}
		}
		public byte[] shutdown()
		{
		running =false;
		byte[] b=out.toByteArray();
		return(b);
		}
	}
