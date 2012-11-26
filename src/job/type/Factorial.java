/**
 * 
 */
package job.type;

/**
 * @author rohit
 *
 */
public class Factorial extends Job {
	long number;
	long factorialOfNumber;

	public Factorial() {
		super(2);
		this.number=500;
	}
	
	public void execute(){
		this.factorialOfNumber=calculateFactorial(number);
	}

	private long calculateFactorial(long num) {
		if(num==0)
			return 1;
		else
			return(calculateFactorial(num-1)*calculateFactorial(num-2));			
	}
}
