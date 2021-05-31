package ch08;

public class CalculatorImpl extends CalculatorAbs implements Calculator{
	
	public long add(long n1, long n2) {
		return n1+n2;
	}
	public long substract(long n1, long n2) {
		return n1-n2;
	}
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	public long divide(long n1, long n2) {
		return n1 / n2;
	}

}
