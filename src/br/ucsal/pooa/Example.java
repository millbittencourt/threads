package br.ucsal.pooa;

public class Example {

	public static void main(String[] args) {

		SharedObject so = new SharedObject();

		String[] names = { "C1", "C2", "P1", "P2" };
		Thread[] threads = { new Thread(new Consumer(so)), new Thread(new Consumer(so)), new Thread(new Producer(so)),
				new Thread(new Producer(so)) };

		for (int i = 0; i < threads.length; i++) {
			threads[i].setName(names[i]);
			threads[i].start();
		}

		System.out.println("Main DONE.");

		/*
		 * Pilha pi = new Pilha();
		 * 
		 * String[] names = { "C1", "C2", "P1", "P2" }; Thread[] threads = { new
		 * Thread(new Consumer(pi)), new Thread(new Consumer(pi)), new Thread(new
		 * Producer(pi)), new Thread(new Producer(pi)) };
		 * 
		 * for (int i = 0; i < threads.length; i++) { threads[i].setName(names[i]);
		 * threads[i].start(); }
		 * 
		 * System.out.println("Main DONE.");
		 * 
		 * }
		 */
	}
}
