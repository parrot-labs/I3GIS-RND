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
	
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Quality Code/Quality Code Filter/Input new Filter'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/03-SAST/03-Quality Code/Quality Code Filter/Input new Filter'), input.getValue('filter-name', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Quality Code/Quality Code Filter/Button Create'))
	WebUI.delay(2)
	WebUI.verifyTextPresent(input.getValue('verify-normal', baris), false, FailureHandling.OPTIONAL)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Quality Code/Quality Code Filter/Filter testing 01'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Quality Code/Filter/Set as Default'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
}