package me.dmizael.bubblesort.agent;

import javax.management.*;

import me.dmizael.bubblesort.mbean.*;

import java.lang.management.*;

public class BubbleAgent {
	
	private MBeanServer mbs = null;
		
	public BubbleAgent(){ 
		
		mbs = ManagementFactory.getPlatformMBeanServer();
		
		Bubble bubbleBean = new Bubble();
		ObjectName bubbleName = null;
		
		try{
			bubbleName = new ObjectName("me.dmizael.jmx:name=BubbleSort");
			mbs.registerMBean(bubbleBean, bubbleName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	   private void waitForEnterPressed() {
		      try {
		         System.out.println("Press  to continue...");
		         System.in.read();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		    }
	
	public static void main(String[] args) {
		BubbleAgent agent = new BubbleAgent();
		agent.waitForEnterPressed();
	}

}
