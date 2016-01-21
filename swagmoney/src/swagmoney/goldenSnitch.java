package swagmoney;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class goldenSnitch {

	public static ArrayList<String> fileIn = new ArrayList<>();
	public static ArrayList<Integer[]> coordinates = new ArrayList<>();
	
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("lol.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		String line;
		
		while ((line = br.readLine()) != null){
			fileIn.add(line);
		}
		
		kek();
	}
	
	public static void kek (){
		int currentLine = 1;
		while (currentLine < fileIn.size()){
			int lines = Integer.parseInt(fileIn.get(currentLine));
			currentLine++;
			for (int i = currentLine; i < lines + currentLine; i++){
				String coor = fileIn.get(i);
				Integer [] coo = new Integer[2];
				int index = 0;
				while (coor.charAt(index) != ' ')
					index++;
				coo[0] = Integer.parseInt(coor.substring(0, index));
				coo[1] = Integer.parseInt(coor.substring(index + 1, coor.length()));
				coordinates.add(coo);
			}
			ayylmao();
			currentLine += lines;
		}
	}
	
	public static void ayylmao(){
		
		double[][] poleCoor = new double[coordinates.size()][2];
		double[][] rectCoor = new double[coordinates.size()][2];
		
		double angle = 0.006283185;
		double currAngle = 0;
		
		for (int i = 0; i < coordinates.size(); i++){
			rectCoor[i][0] = coordinates.get(i)[0];
			rectCoor[i][1] = coordinates.get(i)[1];
		}
		for (int i = 0; i < coordinates.size(); i++){
			poleCoor[i][0] = Math.hypot(rectCoor[i][0], rectCoor[i][1]);
			poleCoor[i][1] = Math.atan2(rectCoor[i][0], rectCoor[i][1]);
		}
		
		double squareSide = 1000.0;
		
		while (currAngle < 2 * Math.PI){
			double maxX = 0;
			double maxY = 0;
			double minX = 0;
			double minY = 0;
			
			for (int i = 0; i < poleCoor.length; i++){
				if (rectCoor[i][0] > maxX)
					maxX = rectCoor[i][0];
				if (rectCoor[i][1] > maxY)
					maxY = rectCoor[i][1];
				
				if (rectCoor[i][0] < minX)
					minX = rectCoor[i][0];
				if (rectCoor[i][1] < minY)
					minY = rectCoor[i][1];
				
			}
			
			//System.out.println(maxX - minX);

			//System.out.println(maxY - minY);
			
			
			if (maxX - minX > maxY - minY && maxX - minX < squareSide)
				squareSide = maxX - minX;
			if (maxY - minY > maxX - minX && maxY - minY < squareSide)
				squareSide = maxY - minY;
			
			//System.out.println(squareSide);
			
			for (int i = 0; i < poleCoor.length; i++){
				poleCoor[i][1] += angle;
				
				rectCoor[i][0] = poleCoor[i][0] * Math.cos(poleCoor[i][1]);
				rectCoor[i][1] = poleCoor[i][0] * Math.sin(poleCoor[i][1]);
			}
			
			currAngle += angle;
		}
		
		double area = Math.pow(squareSide, 2);
		
		String swagmoney = area + "";
		
		System.out.println(truncate(swagmoney));
		
		coordinates = new ArrayList<Integer[]>();
	}
	
	public static String truncate(String lmao){
		int index = 0;
		
		for (int i = 0; i < lmao.length(); i++){
			if (lmao.charAt(i) == '.')
				index = i;
		}
		
		index += 3;
		
		String kek = lmao.substring(0, index);
		return kek;
	}
	
	public static void print(){
		for (int i = 0; i < coordinates.size(); i++){
			Integer [] coo = coordinates.get(i);
			System.out.print(coo[1] + " " + coo[2]);
		}
	}
	
	public static void print(double[][] lmao){
		for (int i = 0; i < lmao.length; i++){
			for (int j = 0; j < lmao[0].length; j++)
				System.out.print(lmao[i][j] + " ");
			System.out.println("");
		}
	}
}
