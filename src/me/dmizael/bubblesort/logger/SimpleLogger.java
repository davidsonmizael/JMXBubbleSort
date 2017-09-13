package me.dmizael.bubblesort.logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleLogger {
	
	public void print(String arg){
		String timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timestamp + ": " + arg);
	}

}
