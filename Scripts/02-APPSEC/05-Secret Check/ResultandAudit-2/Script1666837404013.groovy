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

if(WebUI.verifyTextPresent('Results Secret', false) == true) {
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

	def choice = Arrays.asList("Yes", "No", "Skip")
	Random rand = new Random()
	String randomElement = choice.get(rand.nextInt(choice.size()))
	
	for (int bar = page; bar <= page; bar++) {
		for (int kol = 9; kol <= 9; kol++) {
			ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, randomElement)
			ExcelKeywords.saveWorkbook(Data, excel)
		}
		for (int kol = 7; kol <= 7; kol++) {
			ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, textfinal)
			ExcelKeywords.saveWorkbook(Data, excel)
		}
		for (int kol = 8; kol <= 8; kol++) {
			ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, numberfinal)
			ExcelKeywords.saveWorkbook(Data, excel)
		}
	}
	WebUI.click(findTestObject('Object Repository/05-Secret Check/Radio-'+randomElement))
	WebUI.delay(1)
	int line = page+1
	if (line < end+1) {
		TestObject pagenumber = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div[3]/div/div/div/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div[$line]")
		WebUI.click(pagenumber)
		WebUI.delay(1)
	}
}
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-SubmitAudit'))
WebUI.delay(5)