package Mainmsd;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class BackUpDao {

	public void backUpFolders() throws IOException
	{
		File srcDir = new File("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\MonthlyFile");
		File destDir = new File("C:\\Users\\mehul s dholiya\\Desktop\\Kohinoor\\BackUp");
		FileUtils.copyDirectory(srcDir, destDir);
	}
	
	public void reset() throws IOException
	{
		//backup all data before resting
		File srcDir = new File("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\RecordFiles\\MonthlyFile");
		File destDir = new File("C:\\Users\\mehul s dholiya\\Desktop\\Kohinoor\\BackUp");
		FileUtils.copyDirectory(srcDir, destDir);
		
		//deleting all old files
		FileUtils.deleteDirectory(new File("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\copyRecordFiles"));
		
		//copying new files
		srcDir = new File("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\copyRecordFileConfig");
		destDir = new File("C:\\Users\\mehul s dholiya\\eclipse-workspace\\Diamond\\copyRecordFiles");
		FileUtils.copyDirectory(srcDir, destDir);
	}
}
