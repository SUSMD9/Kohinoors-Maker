package Mainmsd;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;



public class FileDao {

	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int year  = localDate.getYear();
	int month = localDate.getMonthValue();
	
	int lastRowId;
	

	public void totalFileUpdate(double todaysAmount) throws IOException 
	{
		
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\MonthWise\\Y-"+year+".xlsx";
		File file = new File(path);
		file.createNewFile();
		FileInputStream f = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(f);
		Sheet s = w.getSheetAt(0);
		f.close();
		
		lastRowId=s.getLastRowNum();
		double totalMonthlyAmount=0000.0;
		
		//System.out.println(lastRowId+"uh");
		for(int index=1;index<=lastRowId;index++) {
			Row r = s.getRow(index);
			Cell monthCell = r.getCell(0);
			Cell yearCell  = r.getCell(1);
			int M = (int) monthCell.getNumericCellValue();
			int Y = (int) yearCell.getNumericCellValue();
			if(M==month && Y==year) {
				Cell amountCell = r.getCell(2);
				totalMonthlyAmount =amountCell.getNumericCellValue();
				totalMonthlyAmount=totalMonthlyAmount+todaysAmount;
				amountCell.setCellValue(totalMonthlyAmount);
			}
			
		}
		
		FileOutputStream fo = new FileOutputStream(path);
		w.write(fo);
		w.close();
		
	}
	
	public double getTotalPresentMonthAmount() throws IOException 
	{
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\MonthWise\\Y-"+year+".xlsx";
		File file = new File(path);
		FileInputStream fi = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheetAt(0);
		fi.close();
		
		double totalMonthlyAmount=0.0;
		int found=0;
		lastRowId=s.getLastRowNum();
		System.out.println(lastRowId+"yd");
		
		if(lastRowId==0)
		{
			Row r = s.createRow(lastRowId+1);
			Cell c1 = r.createCell(0);
			c1.setCellValue(month);
			Cell c2 = r.createCell(1);
			c2.setCellValue(year);
			Cell c3 = r.createCell(2);
			c3.setCellValue(0000.0);

			FileOutputStream fo = new FileOutputStream(path);
			w.write(fo);
			w.close();
			
			
		}
		else
		{

			for(int index=1;index<=lastRowId;index++)
			{
				Row r = s.getRow(index);
				Cell monthCell = r.getCell(0);
				Cell yearCell  = r.getCell(1);
				int M = (int) monthCell.getNumericCellValue();
				int Y = (int) yearCell.getNumericCellValue();
				if(M==month && Y==year) 
				{
					Cell amountCell = r.getCell(2);
					totalMonthlyAmount =amountCell.getNumericCellValue();
					found=1;
				}
				
			}
			
			if(found==0)
			{
				Row r = s.createRow(lastRowId+1);
				Cell c1 = r.createCell(0);
				c1.setCellValue(month);
				Cell c2 = r.createCell(1);
				c2.setCellValue(year);
				Cell c3 = r.createCell(2);
				c3.setCellValue(0000.0);

				FileOutputStream fo = new FileOutputStream(path);
				w.write(fo);
				
			    //last month total
				if(lastRowId>=1)
				{
				Row	lastMonthRow =s.getRow(lastRowId);
				Cell lastMonthTotalCell = lastMonthRow.getCell(2);
				double lastMonthAmount = lastMonthTotalCell.getNumericCellValue();
				System.out.println(lastMonthAmount);
				//new row(Month) added hence we need to update 'PreviousMonthTotal' variable into Book1 File
				//calling method to update 'PreviousMonthTotal' in Book1 File
				
				FileDao fileDaoObj = new FileDao();
				fileDaoObj.updatePreviousMonthTotal(lastMonthAmount);
				}
			}
			
			
		}
		
		
		w.close();
	
		return totalMonthlyAmount;
	}
	
	public String lastUpdateDetail() throws IOException
	{
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\OtherDetails\\Book1.xlsx";
		File file = new File(path);
		FileInputStream fi = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheetAt(0);
		fi.close();
		Row r = s.getRow(0);
		Cell c = r.getCell(1);
		String lastUpdateTimeStamp = c.getStringCellValue();
		w.close();
		return lastUpdateTimeStamp;
	}
	
	public void changeLastUpdateDetail(String timeStamp) throws IOException
	{
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\OtherDetails\\Book1.xlsx";
		File file = new File(path);
		FileInputStream fi = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheetAt(0);
		fi.close();
		Row r = s.getRow(0);
		Cell c = r.getCell(1);
		c.setCellValue(timeStamp);
		FileOutputStream fo = new FileOutputStream(path);
		w.write(fo);
		w.close();

		
		
	}
	
	public double getPreviousMonthTotal() throws IOException
	{
		double totalAmount;
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\OtherDetails\\Book1.xlsx";
		File file = new File(path);
		FileInputStream fi = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheetAt(0);
		fi.close();
		
		Row r = s.getRow(1);
		Cell c = r.getCell(1);
		
		totalAmount = c.getNumericCellValue();
		
		w.close();
		return totalAmount;
	}
	
	
	public void updatePreviousMonthTotal(double lastMonthAmount) throws IOException
	{
	
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\OtherDetails\\Book1.xlsx";
		File file = new File(path);
		FileInputStream fi = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheetAt(0);
		fi.close();
		
		Row r = s.getRow(1);
		Cell c = r.getCell(1);
		c.setCellValue(lastMonthAmount);
		FileOutputStream fo = new FileOutputStream(path);
		w.write(fo);
		w.close();

		
	}
	
	//Monthly file (daily details)
	public void editMonthlyFile(String timeStamp,int totalPiece,double totalAmount) throws IOException
	{
		String path = "C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\MonthlyFile\\"+month+","+year+".xlsx";
		File file = new File(path);
		
		if(! file.exists()) // checks if file path is present or not , returns false if not
		{
			//System.out.println("created");
			Workbook w = new XSSFWorkbook();
			Sheet s = w.createSheet(month+","+year);
			
			Row r = s.createRow(0);
			Cell dateCell = r.createCell(0);
			dateCell.setCellValue("Time-Stamp");
			
			Cell totalPiecesCell = r.createCell(1);
			totalPiecesCell.setCellValue("Total Piece");
			
			Cell dayAmountCell = r.createCell(2);
			dayAmountCell.setCellValue("Day Total");
				
			Cell totalAmountCell = r.createCell(3);
			totalAmountCell.setCellValue("Total Amount");
			
			//to add first day data 
			Row r1 = s.createRow(1);
			
			dateCell = r1.createCell(0);
			dateCell.setCellValue(timeStamp);
			
			totalPiecesCell = r1.createCell(1);
			totalPiecesCell.setCellValue(totalPiece);
			
			dayAmountCell = r1.createCell(2);
			dayAmountCell.setCellValue(totalAmount);
			
			totalAmountCell = r1.createCell(3);
			totalAmountCell.setCellValue(totalAmount); 
			
			//adjust width of cell 
			s.autoSizeColumn(0);
			s.autoSizeColumn(1);
			s.autoSizeColumn(2);
			s.autoSizeColumn(3);
			
			FileOutputStream fo = new FileOutputStream(path);
			w.write(fo);
			w.close();
		}
		else // edit in existing file only 
		{
			FileInputStream fi = new FileInputStream(file);
			Workbook w = new XSSFWorkbook(fi);
			Sheet s = w.getSheetAt(0);
			fi.close();
			
			lastRowId = s.getLastRowNum();
			Row r = s.createRow(lastRowId+1);
			
			Cell dateCell = r.createCell(0);
			dateCell.setCellValue(timeStamp);
			
			Cell totalPiecesCell = r.createCell(1);
			totalPiecesCell.setCellValue(totalPiece);
			
			Cell dayAmountCell = r.createCell(2);
			dayAmountCell.setCellValue(totalAmount);
			
			//get total from last day
			
			Row r1 = s.getRow(lastRowId);
			Cell lastTotalAmountCell = r1.getCell(3);
			
			double oldTotalAmount = lastTotalAmountCell.getNumericCellValue() ;
			totalAmount = totalAmount + oldTotalAmount;
			
			Cell totalAmountCell = r.createCell(3);
			totalAmountCell.setCellValue(totalAmount);
			
			FileOutputStream fo = new FileOutputStream(path);
			w.write(fo);
			w.close();
			
		}
	}
}
