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
WebUI.click(findTestObject('Object Repository/03-SAST/Button Security Detector'))

boolean status = true
while (status == true) {
	
	WebUI.takeScreenshot()
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Button Change Status'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Div Fixed'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Button Change Status1'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Button Continue reviewing Security Hotspot'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.verifyTextPresent('Edit status security issue success', false, FailureHandling.OPTIONAL)
	WebUI.delay(3)
	
	status = WebUI.verifyTextPresent('There are no security detector to review', false, FailureHandling.OPTIONAL)

}