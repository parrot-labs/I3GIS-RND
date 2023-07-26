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

	WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Button_Organization'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
		
	if (WebUI.verifyTextPresent(input.getValue('name-organization', baris), false, FailureHandling.OPTIONAL) == true) {
		
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Button CreateOrganization'))
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/01-Organization/01-Create New Organization/Input Organization'), 0, FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/01-Organization/01-Create New Organization/Input Organization'), input.getValue('name-organization', baris))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Create New Organization/Button CreateOrganization'))
		WebUI.delay(1)
		WebUI.verifyTextPresent(input.getValue('alert', baris), false, FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Create New Organization/button Cancel'))
		WebUI.delay(1)
		
	}else {
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Button_Organization'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Button CreateOrganization'))
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/01-Organization/01-Create New Organization/Input Organization'), 0, FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/01-Organization/01-Create New Organization/Input Organization'), input.getValue('name-organization', baris))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Create New Organization/Button CreateOrganization'))
		WebUI.delay(1)
		WebUI.verifyTextPresent(input.getValue('alert', baris), false, FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/01-Organization/01-Create New Organization/button Cancel'))
		WebUI.delay(1)
	}
		
}