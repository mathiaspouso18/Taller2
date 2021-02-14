package monitor;

public class Monitor {
	private int cantLectores;
	private boolean escribiendo;
	
	public Monitor() {
		this.cantLectores = 0;
		this.escribiendo = false;
	}

	public synchronized void comienzoLectura() throws InterruptedException {
		while (escribiendo)
			wait();
		cantLectores++;
	}

	public synchronized void terminoLectura() {
		cantLectores--;
		notifyAll();
	}

	public synchronized void comienzoEscritura() throws InterruptedException {
		while (escribiendo || cantLectores > 0)
			wait();
		escribiendo = true;
	}

	public synchronized void terminoEscritura() {
		escribiendo = false;
		notifyAll();
	}
}
