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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.apache.poi.ss.usermodel.Sheet as Sheet
import org.apache.poi.ss.usermodel.Workbook as Workbook
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

TestData input = findTestData('null')

WebUI.click(findTestObject('Object Repository/03-SAST/Button SAST'))
WebUI.delay(1)

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	WebUI.click(findTestObject('Object Repository/03-SAST/Button Quality Code Filter'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Quality Code/Quality Code Filter/'+input.getValue('filter', baris)))
	WebUI.delay(1)
	if (WebUI.verifyTextPresent('Set as Priority', false, FailureHandling.OPTIONAL) == true) {
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Quality Code/Quality Code Filter/Button-SetasPriority'))
		WebUI.delay(1)
	}
	WebUI.click(findTestObject('Object Repository/03-SAST/button_Overview'))
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Overview/Button Rescan SAST'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Overview/button_Yes, Sure'))
	WebUI.delay(1)
	boolean step1 = true
	while (step1 == true) {
		step1 = WebUI.verifyTextPresent('Please waiting', false, FailureHandling.OPTIONAL)
	}
	boolean scanning = true
	while (scanning == true) {
		scanning = WebUI.verifyTextPresent('SAST TOOL RUNNING', false, FailureHandling.OPTIONAL)
	}
	WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-FINISH SCAN'))
	WebUI.delay(3)
	
	TestObject firsttext = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div[3]/div/div/div/div[2]/div/div/div/div/div[2]")
	text1 = WebUI.getText(firsttext)
	String text2 = text1.replace("\n", "")
	String text3 = text2.substring(0, 7);
	String finaltext= text3.replaceAll("[0-9]", "");
	println(finaltext)
	String Data = './excel/Quality-Code.xlsx'
	Workbook excel = ExcelKeywords.getWorkbook(Data)
	Sheet sheet = excel.getSheet('Sheet1')
	int col = 1
	if(finaltext == 'FAILED') {
		TestObject count = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div[3]/div/div/div/div[2]/div/div/div/div/div[2]")
		number = WebUI.getText(count)
		number = number.replaceAll("[^\\d.]", "");
		page = Integer.valueOf(number)
		
		for (int code = 1; code <= page; code++) {
			TestObject overalcode = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[$code]/li/div")
			text = WebUI.getText(overalcode)
			String text = text.replace("\n", " ")
			for (int kol = col+baris; kol <= col+baris; kol++) {
				ExcelKeywords.setValueToCellByIndex(sheet, code, kol, text)
				ExcelKeywords.saveWorkbook(Data, excel)
			}
		}
	}else {
		for (int kol = col+baris; kol <= col+baris; kol++) {
			ExcelKeywords.setValueToCellByIndex(sheet, baris, kol, finaltext)
			ExcelKeywords.saveWorkbook(Data, excel)
		}
	}
}