/**
 * 
 */
package job.type;

/**
 * @author rohit
 *
 */
public class Matrix extends Job {
	
	int dimension;
	Double[][] matrixA;
	Double[][] matrixB;
	Double[][] matrixC;

	public Matrix(){
		super(1);
		this.dimension = 500;
		this.matrixA = new Double[dimension][dimension];
		this.matrixB = new Double[dimension][dimension];
		this.matrixC = new Double[dimension][dimension];
		initData();
	}

	public void execute() {
		multiplyMatrices();
	}

	private void multiplyMatrices() {
		for(int i=0;i<this.dimension;i++) {
			for(int j=0;j<this.dimension;j++) {
				for(int k=0;k<this.dimension;k++) {
					this.matrixC[i][j] += this.matrixA[i][k]*this.matrixB[k][j];
				}
			}
		}		
	}

	/**
	 * @return the dimension
	 */
	public int getDimension() {
		return dimension;
	}
	
	public void initData() {
		for(int i=0;i<this.dimension;i++) {
			for(int j=0;j<this.dimension;j++) {
				this.matrixA[i][j] = 1.0;
				this.matrixB[i][j] = 1.0;
				this.matrixC[i][j] = 0.0;
			}
		}
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}