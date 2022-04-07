package assignments;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class readexcel {

	public static String[][] getdata(String excelfilepath) throws IOException {
		// TODO Auto-generated method stub
XSSFWorkbook book= new XSSFWorkbook(excelfilepath);
XSSFSheet sheet= book.getSheetAt(0);
int rowcount=sheet.getLastRowNum();
System.out.println("row count:"+rowcount);
int column=sheet.getRow(0).getLastCellNum();
System.out.println("columns:"+column);
String[][] data=new String[rowcount][column];
for(int i=1;i<=rowcount;i++)
{
	XSSFRow eachrow=sheet.getRow(i);
for(int j=0;i<column;j++)
	{
		XSSFCell eachcell = eachrow.getCell(j);
		String value = eachcell.getStringCellValue();
		data[i-1][j]=value;
		System.out.println(value);
	}	
	}
book.close();
return data;
}

}
