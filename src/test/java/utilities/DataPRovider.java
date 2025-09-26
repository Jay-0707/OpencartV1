package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataPRovider
{

	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\testdata.xlsx"; //taking xl from data base
		
		ExcelUtility xlutil =new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String loginData[][]=new String[totalrows][totalcols];//created for two dimensional array which can store
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);//1,0
			}
		}
		return loginData;
	}
}
