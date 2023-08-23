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

if(WebUI.verifyTextPresent('Result Secret', false, FailureHandling.OPTIONAL) == true) {
	WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Filter Scan Secret'))
	WebUI.delay(1)
}else {
	WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Secret Check'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Filter Scan Secret'))
	WebUI.delay(1)
}
WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null);
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Setting your plugin'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Span-Keyword Detector'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Saveplugin'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Results Secret'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-RESCAN SECRET CHECK'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Yes, Sure'))
WebUI.delay(1)
boolean step1 = true
while (step1 == true) {
	step1 = WebUI.verifyTextPresent('Please waiting', false, FailureHandling.OPTIONAL)
}
boolean scanning = true
while (scanning == true) {
	scanning = WebUI.verifyTextPresent('SECRET CHECK TOOL RUNNING', false, FailureHandling.OPTIONAL)
}
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-FINISH SCAN'))
WebUI.delay(3)
WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null);

String Data1 = './excel/secret-check.xlsx'
Workbook excel1 = ExcelKeywords.getWorkbook(Data1)
Sheet sheet1 = excel1.getSheet('Sheet1')

String text = WebUI.getText(findTestObject('Object Repository/example'))
String number = text.substring(text.length() - 1)
int end = Integer.valueOf(number)
println(end)

for (int page = 1; page <= end; page++) {
	WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null);
	TestObject filepath = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/text()[normalize-space(.)='File Path :']/parent::*")
	String path = WebUI.getText(filepath)
	String textfinal = path.replace("File Path : ", "")
	String Data = './excel/secret-check.xlsx'
	Workbook excel = ExcelKeywords.getWorkbook(Data)
	Sheet sheet = excel.getSheet('Sheet1')
	
	TestObject linenumber = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*/text()[normalize-space(.)='Line Number :']/parent::*")
	String textnumber = WebUI.getText(linenumber)
	String numberfinal = textnumber.replace("Line Number : ", "")

	for (int bar = page; bar <= page; bar++) {
		for (int kol = 11; kol <= 11; kol++) {
			ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, textfinal)
			ExcelKeywords.saveWorkbook(Data, excel1)
		}
		for (int kol = 12; kol <= 12; kol++) {
			ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, numberfinal)
			ExcelKeywords.saveWorkbook(Data1, excel1)
		}
	}
	WebUI.delay(1)
	int line = page+1
	if (line == end+1) {
		TestObject pagenumber = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div[3]/div/div/div/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div[1]")
		WebUI.click(pagenumber)
	}
	if (line < end+1) {
		TestObject pagenumber = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div[3]/div/div/div/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div[$line]")
		WebUI.click(pagenumber)
		WebUI.delay(1)
	}
}


for (int page = 1; page <= end; page++) {
	TestObject numberpage = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[3]/div/div/div/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div[$page]")
	color = WebUI.getCSSValue(numberpage, 'border')
	String randomElement = color.replace("1px solid ", "")
	println(randomElement)
	for (int bar1 = page; bar1 <= page; bar1++) {
		for (int kol1 = 13; kol1 <= 13; kol1++) {
			if (randomElement == 'rgb(87, 202, 34)'){
				randomElement = 'Yes'
			}
			if (randomElement == 'rgb(255, 145, 43)'){
				randomElement = 'Empty'
			}
			if (randomElement == 'rgb(255, 25, 67)'){
				randomElement = 'No'
			}
			if (randomElement == 'rgb(110, 117, 159)'){
				randomElement = 'Skip'
			}
			ExcelKeywords.setValueToCellByIndex(sheet1, bar1, kol1, randomElement)
			ExcelKeywords.saveWorkbook(Data1, excel1)
		}
	}
	z = input.getValue('choice', page)
	println(z)
	x = randomElement
	println(x)
	for (int kol1 = 14; kol1 <= 14; kol1++) {
		if(z == x) {
			ExcelKeywords.setValueToCellByIndex(sheet1, page, kol1, 'Pass')
			ExcelKeywords.saveWorkbook(Data1, excel1)
		}else {
			ExcelKeywords.setValueToCellByIndex(sheet1, page, kol1, 'Fail')
			ExcelKeywords.saveWorkbook(Data1, excel1)
		}
	}
}
//for (int page = 1; page <= end; page++) {
//	z = input.getValue('choice', page)
//	println(z)
//	x = input.getValue('choicefinal', page)
//	println(x)
//	for (int kol1 = 14; kol1 <= 14; kol1++) {
//		if(z == x) {
//			ExcelKeywords.setValueToCellByIndex(sheet1, page, kol1, 'Pass')
//			ExcelKeywords.saveWorkbook(Data1, excel1)
//		}else {
//			ExcelKeywords.setValueToCellByIndex(sheet1, page, kol1, 'Fail')
//			ExcelKeywords.saveWorkbook(Data1, excel1)
//		}
//	}
//}