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

TestData input = findTestData('Data Files/Login')

for (int baris = 1; baris <= 1; baris++) {
	
	WebUI.setText(findTestObject('Object Repository/Login/Input Username'), input.getValue('username', baris))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Login/Input Password'), input.getValue('', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Login/Div Remember me'))
	WebUI.takeScreenshot()
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Login/Button Login'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/Login/Button Home'), 0, FailureHandling.OPTIONAL)
	WebUI.verifyElementClickable(findTestObject('Object Repository/Login/Button Home'), FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	
	boolean scanning = true
	while (scanning == true) {
		WebUI.delay(60)
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Summary Project'))
		WebUI.delay(60)
		WebUI.click(findTestObject('Object Repository/03-SAST/Button SAST'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/03-SAST/button_Overview'))
		WebUI.delay(60)
		WebUI.refresh()
		WebUI.delay(60)
		WebUI.click(findTestObject('Object Repository/04-SCA/Button-SCA'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/04-SCA/Button-Filter Scan Vuln'))
		WebUI.delay(60)
		WebUI.refresh()
		scanning = WebUI.verifyElementClickable(findTestObject('Object Repository/Login/Button Home'), FailureHandling.OPTIONAL)
	}
}