package me.dmizael.bubblesort.agent;

import javax.management.*;

import me.dmizael.bubblesort.mbean.*;

import java.lang.management.*;

public class BubbleAgent {
	
	private MBeanServer mbs = null;
	private Bubble bubbleBean;
	public BubbleAgent(){ 
		
		mbs = ManagementFactory.getPlatformMBeanServer();
		
		this.bubbleBean = new Bubble();
		ObjectName bubbleName = null;
		
		try{
			bubbleName = new ObjectName("me.dmizael.jmx:name=BubbleSort");
			mbs.registerMBean(this.bubbleBean, bubbleName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	   private void startBubble(){
		   this.bubbleBean.startSort();		   
	   }
	
	public static void main(String[] args) {
		BubbleAgent agent = new BubbleAgent();
		agent.startBubble();
	}

}