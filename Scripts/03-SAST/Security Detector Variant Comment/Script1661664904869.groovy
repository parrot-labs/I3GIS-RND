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
	
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Add Comment'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Input Comment'), input.getValue('comment1', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Button Comment'))
	WebUI.delay(1)
	WebUI.scrollToPosition(0, 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Add Comment'))
	WebUI.delay(1)
	WebUI.verifyTextPresent(input.getValue('comment1', baris), false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Edit Comment'))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Re edit Comment'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Re edit Comment'), Keys.chord(Keys.BACK_SPACE))
	WebUI.delay(1) 
	WebUI.setText(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Re edit Comment'), input.getValue('comment2', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Button save Comment'))
	WebUI.delay(1)
	WebUI.verifyTextPresent(input.getValue('comment2', baris), false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Comment/Delete Comment'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.scrollToPosition(0, 0)
}