package me.dmizael.bubblesort.mbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.dmizael.bubblesort.logger.SimpleLogger;

public class Bubble implements BubbleMBean {

	private static final int LIST_SIZE = 10000;
	private static SimpleLogger logger;

	public Bubble() {
		logger = new SimpleLogger();
	}

	@Override
	public void startSort() {
		while (true) {
			List<Integer> numlist = generateList();
			logger.print("Sorting list...");
			sort(numlist);
			logger.print("Sorting ended.");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopSort() {
		logger.print("Stopping proccess");
		System.exit(0);
	}

	@Override
	public List<Integer> generateList() {

		List<Integer> list = new ArrayList<Integer>();

		Random random = new Random();
		logger.print("Generating a list with " + LIST_SIZE + " rows");
		for (int i = 0; i < LIST_SIZE; i++) {
			list.add(random.nextInt(1000));
		}
		return list;
	}

	@Override
	public List<Integer> sort(List<Integer> list) {

		for (int end = list.size() - 1; end > 0; --end) {
			for (int i = 0; i < end; ++i) {
				if (list.get(i) > list.get(i + 1)) {
					int aux = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, aux);
				}

			}
		}
		return list;
	}

}
