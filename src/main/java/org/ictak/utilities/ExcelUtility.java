package org.ictak.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility
{
	public static XSSFWorkbook excelWbook;
	public static XSSFSheet excelSheet;

	public static String getCredential(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\Credentials.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(0);
		if(colNum == 1)
			return excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
		else
			return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	public static String getCourses(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DataSet.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(0);
		if(colNum == 2)
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
				else
					return "";
			else
				return "";

		}
		else
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();	
				else
					return "";
			else
				return "";
		}
	}

	public static String getEvents(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DataSet.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(1);
		if(colNum == 2)
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
				else
					return "";
			else
				return "";

		}
		else
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();	
				else
					return "";
			else
				return "";
		}
	}

	public static String getContactusdata(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DataSet.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(2);
		if (colNum==4)
		{
			return""+excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
		}
		else 
		{
			return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
	}

	public static String getAdminusers(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DashboardData.xlsx");	
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(1);
		if(colNum == 6 ||colNum == 7 || colNum == 8 || colNum == 9)
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
				else
					return "";
			else
				return "";

		}	
		else
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();	
				else
					return "";
			else
				return "";
		}
	}

	public static String getTestimonial(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DashboardData.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(0);
		if(colNum == 3)
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
				else
					return "";
			else
				return "";

		}
		else
		{
			if(excelSheet.getRow(rowNum) != null)
				if(excelSheet.getRow(rowNum).getCell(colNum) != null)
					return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();	
				else
					return "";
			else
				return "";
		}
	}

	public static String getDashBoardData(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DashboardData.xlsx");

		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(2);
		if (colNum==2)
			return""+excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
		else
			return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	public static String getStaffData(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DashboardData.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(3);
		if (colNum==2)

			return""+excelSheet.getRow(rowNum).getCell(colNum).getRawValue();
		else 
			return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}	

	public static String getCoursesData(int rowNum,int colNum) throws IOException
	{

		FileInputStream inp=new FileInputStream("C:\\Users\\91994\\Desktop\\ICTAK\\src\\main\\resources\\DashboardData.xlsx");
		excelWbook=new XSSFWorkbook(inp);
		excelSheet=excelWbook.getSheetAt(4);
		return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}	

}