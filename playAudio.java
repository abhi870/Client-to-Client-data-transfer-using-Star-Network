//package audioplay;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.*;
public class playAudio
{
	ByteArrayOutputStream out=new ByteArrayOutputStream();
	public playAudio(byte[] ap)
	{
	out.write(ap,0,ap.length);	
	}
		public void play()
			{
			AudioFormat Format= new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
				try
					{
					DataLine.Info info= new DataLine.Info(SourceDataLine.class,Format);
					final SourceDataLine sourceLine= (SourceDataLine)AudioSystem.getLine(info);
					sourceLine.open();
					sourceLine.start();
					System.out.println("started playback...");
					int p=0;
					while(p!=1)
					{
					sourceLine.write(out.toByteArray(),0,out.size());
					p++;
					}
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
	};
