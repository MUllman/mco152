package ullman.threads;

import java.math.BigInteger;

public class Factorial extends Thread {

	private final Long num;

	public Factorial(Long num) {
		this.num = num;
	}

	private BigInteger getFactorial() {
		BigInteger factorial = BigInteger.valueOf(num);
		for (long i = 1; i < num; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	@Override
	public void run() {
		super.run();

		System.out.println(getFactorial());

	}

}
