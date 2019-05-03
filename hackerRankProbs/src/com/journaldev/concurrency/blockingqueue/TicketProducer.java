package com.journaldev.concurrency.blockingqueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketProducer implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private boolean running;

	public TicketProducer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
		running = true;
	}

	// We need to check if the producer thread is
	// Still running, and this method will return
	// the state (running/stopped).
	public boolean isRunning() {
		return running;
	}

	@Override
	public void run() {

		// We are adding tickets using put() which waits
		// until it can actually insert elements if there is
		// not space in the queue.
		for (int i = 0; i < 15; i++) {
			String element = "Ticket" + i;

			try {
				queue.put(element);
				System.out.println("Ticket added: " + element);
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("TicketProducer Completed.");
		running = false;
	}

}