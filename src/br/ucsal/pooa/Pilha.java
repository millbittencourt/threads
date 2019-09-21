package br.ucsal.pooa;

public class Pilha {

	private volatile char[] pilha = new char[6];
	private volatile int ponteiro = 0;

	public boolean hasNext() {
		if (ponteiro < 6)
			return true;
		return false;
	}

	public synchronized char pop() {
		try {
			while (hasNext())
				wait();
			pilha[ponteiro] = ' ';

			System.out.println(Thread.currentThread().getName() + ": POPED: " + ponteiro);
			ponteiro--;
			notifyAll();
			return pilha[ponteiro];
		} catch (InterruptedException iex) {
			return ' ';
		}
	}

	public synchronized boolean push(char value) {
		try {
			while (!hasNext())
				wait();

			pilha[ponteiro] = value;
			System.out.println(Thread.currentThread().getName() + ": PUSHED: " + value);
			ponteiro++;
			notifyAll();

			return true;
		} catch (InterruptedException iex) {
			return false;
		}
	}

}
