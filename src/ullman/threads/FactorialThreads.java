package ullman.threads;

public class FactorialThreads {

	public static void main(String[] args) {
		Thread t1 = new Factorial(4L);
		Thread t2 = new Factorial(5L);

		t1.start();
		t2.start();
	}

}
