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

TestData input = findTestData('null')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	//WebUI.scrollToElement(findTestObject('Object Repository/01-Organization/01-Delete Organization/button_Administration'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/01-Organization/01-Delete Organization/button_Administration'))
	WebUI.delay(1)
	WebUI.scrollToElement(findTestObject('Object Repository/01-Organization/01-Delete Organization/button_Organization'), 0)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/01-Organization/01-Delete Organization/button_Organization'))
	WebUI.delay(1)
	WebUI.scrollToElement(findTestObject('Object Repository/01-Organization/01-Delete Organization/Input Organization'), 0)
	WebUI.delay(1)
	
	String del = input.getValue('name-organization', baris)
	//String result = del.toLowerCase();
	//println(result)
	
	WebUI.setText(findTestObject('Object Repository/01-Organization/01-Delete Organization/Input Organization'), del)
	WebUI.delay(1)
	WebUI.verifyElementClickable(findTestObject('Object Repository/01-Organization/01-Delete Organization/button Delete'), FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/01-Organization/01-Delete Organization/button Delete'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/01-Organization/01-Delete Organization/Yes, keep delete it'))
	WebUI.verifyTextPresent(input.getValue('verify', baris), false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	
}