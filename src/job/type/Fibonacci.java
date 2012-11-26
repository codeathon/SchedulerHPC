/**
 * 
 */
package job.type;

/**
 * @author rohit
 *
 */
public class Fibonacci extends Job{
	private int fiboNumber;
	private int num=1000;
	
	public Fibonacci() {
		super(3);
	}
	
	public void execute() {
		this.fiboNumber = calculateFib(this.num);
	}

	private int calculateFib(int num2) {
		if(num2==0)
			return 0;
		if(num2==1)
			return 1;
		else 
			return (calculateFib(num2-1)+calculateFib(num2-2));
	}

	public int getFiboNumber() {
		return fiboNumber;
	}

	public void setFiboNumber(int fiboNumber) {
		this.fiboNumber = fiboNumber;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
