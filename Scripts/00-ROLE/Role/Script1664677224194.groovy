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

TestData input = findTestData('Data Files/00-Role')

WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-Administration'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-TeamManagement'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-ROLE'))
WebUI.delay(1)
WebUI.takeScreenshot()

for (int row = 1; row <= 1; row++) {
	WebUI.click(findTestObject('Object Repository/ROLE/Create-newRole/Button-CreateNewRole'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/ROLE/Create-newRole/Input-NameRole'), input.getValue('name', row))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/ROLE/Create-newRole/Input-Deskription'), input.getValue('desc', row))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/Expand-i3gisGeneral'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/view-admin'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/Expand-i3gisGeneral'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/Create-newRole/Button-CreateRole'))
	WebUI.delay(1)
}

TestData input = findTestData('Data Files/00-Role')

for (int baris = 2; baris <= input.getRowNumbers(); baris++) {
	
	
}