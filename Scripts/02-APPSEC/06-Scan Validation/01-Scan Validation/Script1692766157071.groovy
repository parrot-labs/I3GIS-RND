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

TestData input = findTestData('Data Files/AppSec-scanvalidation')

WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Scan Validation'))
WebUI.delay(1)
WebUI.verifyTextPresent('Scan Validation', false, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)
WebUI.takeScreenshot()

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/SCA'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/SECRET CHECK'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Misconfiguration'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/SAST'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Profile Current'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/07-Scan Validation/Input-Name Profile'), input.getValue('profile-name', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Create'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Create new profile success', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Ceklis-Project 1'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('You enable project to use this profile', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Ceklis-Project 1'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('You disable project to use this profile', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Set as Priority'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Yes, Set as Priority'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Set priority to all project success', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Profile Current'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Profile-Default'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Set as Priority'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Yes, Set as Priority'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Set priority to all project success', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Profile Current'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Profile-testing'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Delete Profile'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-Scan Validation/Button-Yes, Delete'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Delete profile success', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.takeScreenshot()
}