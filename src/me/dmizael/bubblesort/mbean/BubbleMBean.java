package me.dmizael.bubblesort.mbean;

import java.util.List;

public interface BubbleMBean {
	
	public void startSort();
	
	public void stopSort();
	
	public List<Integer> generateList();
	
	public List<Integer> sort(List<Integer> list);

}
