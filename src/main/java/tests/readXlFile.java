package tests;

import com.flipkart.Utils.Xls_Reader;

public class readXlFile {

	
	
	
	public static Object[][] getData(String filePath, String SheetName){
		Xls_Reader xls = new Xls_Reader(filePath);
		int rows=xls.getRowCount(SheetName); 
		int cols= xls.getColumnCount(SheetName);
		Object[][] data= new Object[rows-1][cols];
		
		for(int i=0;i<rows-1; i++){ 
			for(int j=0;j<cols;j++){
				data[i][j]=xls.getCellData(SheetName, j, i+2);
			}
		}
		
		return data;
		
	}
	
	public static void main(String[] args) {

		
		
		Xls_Reader xls = new Xls_Reader("C:\\Dev_Tools\\workspace\\VNFramework_Jan2017\\src\\main\\java\\tests\\test.xlsx");
		
		int rows=xls.getRowCount("Login"); //14 , 13
		int cols= xls.getColumnCount("Login");
		
		
		System.out.println("--- " + xls.getCellData("Login", 1, 3));
		
		for(int i=0;i<rows-1; i++){ 
			for(int j=0;j<cols;j++){
				System.out.println(xls.getCellData("Login", j, i+2));
			}
		}
		
		Object[][] data= new Object[rows-1][cols];//13,2
		
		for(int i=0;i<rows-1; i++){ 
			for(int j=0;j<cols;j++){
				data[i][j]=xls.getCellData("Login", j, i+2);
			}
		}
		
		
		Object[][] regData=getData("C:\\Dev_Tools\\workspace\\VNFramework_Jan2017\\src\\main\\java\\tests\\test.xlsx", "RegistrationTest");
		
		
		for(int i=0;i<regData.length;i++){
			for(int j=0;j<regData[0].length;j++){
				System.out.println(regData[i][j]);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
