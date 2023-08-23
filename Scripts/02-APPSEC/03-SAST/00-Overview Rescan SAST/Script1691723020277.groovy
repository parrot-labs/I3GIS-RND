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

WebUI.click(findTestObject('Object Repository/Button Home'))
WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/Button SAST'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/button_Overview'))
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('Object Repository/03-SAST/03-Overview/Button Rescan SAST'), 0, FailureHandling.OPTIONAL)
WebUI.takeScreenshot()

TestData input = findTestData('null')

for (int baris = 1; baris <= 1; baris++) {
	
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Overview/Button Rescan SAST'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	if(input.getValue('rescan', baris) == 'No') {
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Overview/Rescan Cancel'))
		WebUI.delay(1)
	}else {
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Overview/Rescan Yes'))
		WebUI.delay(1)
		
		boolean scanning = true
		while (scanning == true) {
			scanning = WebUI.verifyTextPresent('scanning process', false, FailureHandling.OPTIONAL)
		}
		WebUI.takeScreenshot()
		boolean tool = true
		while (tool == true) {
			tool = WebUI.verifyTextPresent('SAST TOOL RUNNING', false, FailureHandling.OPTIONAL)
		}
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/03-SAST/03-Overview/Button See Result'))
		WebUI.delay(1)
		WebUI.waitForElementPresent(findTestObject('Object Repository/03-SAST/03-Overview/Button Rescan SAST'), 0, FailureHandling.OPTIONAL)
		WebUI.takeScreenshot()
	}
	
}