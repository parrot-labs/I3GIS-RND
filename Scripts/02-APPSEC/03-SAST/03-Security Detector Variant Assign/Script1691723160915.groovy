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

TestData input = findTestData('Data Files/AppSec-Issuecode')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	TestObject asignee = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[3]/div/div[2]")
	String raw = WebUI.getText(asignee)
	String user = raw.replace(': ', '')
	
	if(user == 'Not Assigned') {
		
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Button-Assign'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Input-User'), input.getValue('assign', baris))
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/div-user'))
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.verifyTextPresent('Assign User Successfully', false, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		
	}else {
		
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Button-Assign'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Button-Not Assigned'))
		WebUI.delay(2)
		WebUI.takeScreenshot()
		WebUI.verifyTextPresent('Revoke User Successfully', false, FailureHandling.OPTIONAL)
		WebUI.delay(3)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Button-Assign'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Input-User'), input.getValue('assign', baris))
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/div-user'))
		WebUI.delay(1)
		WebUI.takeScreenshot()
		WebUI.verifyTextPresent('Assign User Successfully', false, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		
	}
	
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Button-ALL'))
	WebUI.delay(2)
	TestObject raw1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div[1]")
	String tittle = WebUI.getText(raw1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Assign/Button-My Issues'))
	WebUI.delay(2)
	WebUI.takeScreenshot()
	TestObject raw2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div[1]/div/div[4]/div/div[1]/ul/div/div[2]/div[2]/div/div/div/div/div/div[2]")
	String tittle1 = WebUI.getText(raw2)
	WebUI.verifyEqual(tittle, tittle1, FailureHandling.STOP_ON_FAILURE)
}