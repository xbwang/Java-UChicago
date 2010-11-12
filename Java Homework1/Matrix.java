import java.util.*;
import java.io.*;

class Matrix{
	private int row, col;
	private double[][] data;
	
	public Matrix(int row_in, int col_in){
		row = row_in;
		col = col_in;
		data = new double[row][col];
	}
	
	public static void main(String[] args){
		System.out.print(">>>>please input row-length range and column-length range\n");
		System.out.print(">>>>ie: 1-10 2-20\n");
		System.out.print(">>>>all values must be larger than zero\n");
		System.out.print(">>>>");
		String input = ParserUtils.getKeyInput();
		String[] inputToken = ParserUtils.getTokens(input);
		if(inputToken.length != 2){
			ErrorMsg("- error: too many/few input values");
		}
		for(int i = 0; i < 2; i++){
			if(!inputToken[i].matches("\\d+-\\d+")){
				ErrorMsg("- error: invalid inputs");
			}
		}
		String[] stringData;
		stringData = inputToken[0].split("-");
		int rowSttPoint = Integer.parseInt(stringData[0]);
		int rowEndPoint = Integer.parseInt(stringData[1]);
		stringData = inputToken[1].split("-");
		int colSttPoint = Integer.parseInt(stringData[0]);
		int colEndPoint = Integer.parseInt(stringData[1]);
		try{
			BufferedWriter outFile = new BufferedWriter(new FileWriter("ResultsByJava.txt"));
			outFile.write("Size\tElapsedTime(in Msec)\n");
			for(int i = rowSttPoint; i <= rowEndPoint; i++){
				for(int j = colSttPoint; j <= colEndPoint; j++){
					Matrix m = NewMatrix(i, j);
					Matrix n = NewMatrix(j, i);
					Matrix result = new Matrix(i, i);
					long start = System.currentTimeMillis();
					for(int p = 0; p < i; p++){
						for(int q = 0; q < i; q++){
							for(int r = 0; r < j; r++){
								result.data[p][q] += (m.data[p][r]*n.data[r][q]);
							}
						}
					}
					long end = System.currentTimeMillis();
					long elapsedTime = end - start;
					int size = i*j;
					outFile.write(Integer.toString(size));
					outFile.write("\t");
					outFile.write(Long.toString(elapsedTime));
					outFile.write("\n");
				}
			}
			outFile.close();
		}catch(IOException e){System.out.println("- error while writing file: "+e);}
	}
	
	private static void ErrorMsg(String msg){
		System.out.println(msg);
		System.exit(0);
	}
	
	public static Matrix NewMatrix(int row, int col){
		Matrix newM = new Matrix(row, col);
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++){
				Random randomGenerator = new Random();
				double ranData = randomGenerator.nextDouble()*100;
				newM.data[i][j] = ranData;
			}
		return newM;
	}
}