import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import org.apache.poi.ss.usermodel.Sheet as Sheet
import org.apache.poi.ss.usermodel.Workbook as Workbook

TestData input = findTestData('null')

TestObject text = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div/div[2]/div[3]")
String result = WebUI.getText(text)
String output = result.count('found')
int x = Integer.valueOf(output)


for(int baris = x - 1; baris >= 1; baris--) {
	TestObject page1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div[3]/div/div/div/div[2]/div[3]/div/div/div[2]/ul/div[$baris]/div/span")
	String head = WebUI.getText(page1)
	String resulthead = head.substring(head.indexOf("in")+3)
	String clear = head.replace("secrets in $resulthead", "")
	String total= clear.replaceAll("[^0-9]", "");
	String name = 'found'+' '+total+' '+'secrets'+' '+'in'+' '+resulthead
	TestObject title = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$name'])[1]/following::*[name()='svg'][1]")
	WebUI.click(title)
	WebUI.delay(1)
	WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null);
	
	point = input.getRowNumbers()
	end1 = Integer.valueOf(total)
	end2 = point -	end1
	end3 = point - end2
	end = 0
	if(end3 == 2) {
		end = 8
	}else {
		end = 6
	}
	if (end2 == 2) {
		end2 = 1
	}
	println(end)
	println(end2)
	println(end3)
	
	for(int baris2 = end; baris2 >= end2; baris2--) {
		for (int baris3 = 1; baris3 <= end3; baris3++) {
			TestObject linenumber = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[$baris3]/li")
			String textnumber = WebUI.getText(linenumber)
			String result1 = textnumber.substring(textnumber.indexOf("mbe")+5)
			String w= result1.replaceAll("[^0-9]", "");
			String xx= result1.replaceAll("[0-9]", "");
			String y= xx.replaceAll("Source Code", "");
			String z= y.replaceAll("\n", "");
			
			String Data = './excel/secret-check.xlsx'
			Workbook excel = ExcelKeywords.getWorkbook(Data)
			Sheet sheet = excel.getSheet('Sheet1')
			
			if(end == 8) {
				for (int bar = baris3 + end - 2 ; bar <= baris3 + end - 2; bar++) {
					for (int kol = 3; kol <= 3; kol++) {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, w)
						ExcelKeywords.saveWorkbook(Data, excel)
					}
					for (int kol = 4; kol <= 4; kol++) {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, z)
						ExcelKeywords.saveWorkbook(Data, excel)
					}
					if(z == 'Safe') {
						z = 'Yes'
					}else if(z == 'Skipped') {
						z = 'Skip'
					}else if(z == 'Need fix this!') {
						z = 'No'
					}
					for (int kol = 5; kol <= 5; kol++) {
						if((z == input.getValue('choice', bar)) && (w == input.getValue('linenumberfirst', bar))) {
							ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Pass')
							ExcelKeywords.saveWorkbook(Data, excel)
						}else {
								ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Fail')
								ExcelKeywords.saveWorkbook(Data, excel)
						}
					}
				}
			}else {
				for (int bar = baris3 ; bar <= baris3; bar++) {
					for (int kol = 3; kol <= 3; kol++) {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, w)
						ExcelKeywords.saveWorkbook(Data, excel)
					}
					for (int kol = 4; kol <= 4; kol++) {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, z)
						ExcelKeywords.saveWorkbook(Data, excel)
					}
				}
				if(z == 'Safe') {
					z = 'Yes'
				}else if(z == 'Skipped') {
					z = 'Skip'
				}else if(z == 'Need fix this!') {
					z = 'No'
				}
				for (int bar = baris3 ; bar <= baris3; bar++) {
					for (int kol = 5; kol <= 5; kol++) {
						if(z == input.getValue('choice', baris3) && w == input.getValue('linenumberfirst', baris3)) {
							ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Pass')
							ExcelKeywords.saveWorkbook(Data, excel)
						}else {
								ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'fail')
								ExcelKeywords.saveWorkbook(Data, excel)
						}
					}
				}
			}
		}
	}
}