package ch08;

public abstract class Calculator_Abs extends Calculator_Impl implements Calculator {


	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	public long divide(long n1, long n2) {
		return n1 / n2;
	}
}
