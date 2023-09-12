package testdata;

import util.Xls_Reader;

public class DataFile {

	//GmailSignInTest Test
	 
	Xls_Reader d = new Xls_Reader("/Users/riddhi/Desktop/QA/Testing/TestData.xlsx");

	public String wrongEmail = d.getCellData("Data1", "Email", 2);
	public String wrongEmailErr = d.getCellData("Data1", "Error", 2);
	
	public String wrongPhoneNumber = d.getCellData("Data1", "Phone", 2);
	public String wrongPhoneErr = d.getCellData("Data1", "Error", 2);

	public String specialEmailChar = d.getCellData("Data1", "Email", 3);
	public String specialEmailCharErr = d.getCellData("Data1", "Error", 4);
	
	public String specialCharPhone = d.getCellData("Data1", "Phone", 3);
	public String specialCharPhoneErr = d.getCellData("Data1", "Error", 2);
	
	public String emptyEmailOrPhoneErr = d.getCellData("Data1", "Error", 5);
	
	
}
