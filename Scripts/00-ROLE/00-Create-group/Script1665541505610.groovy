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

TestData input = findTestData('Data Files/ROLE/00-Create-group')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.setText(findTestObject('Object Repository/ROLE/Create-Group/input-NameGroup'), input.getValue('name', baris))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/ROLE/Create-Group/Input-Desc'), input.getValue('desc', baris))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/ROLE/Create-Group/Input-role'), input.getValue('roles', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/Create-userRole/div-role'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/ROLE/Create-Group/Button-CreateGroup'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('Object Repository/ROLE/Create-userRole/Input'), input.getValue('name', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/Create-Group/Button-Setting'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/Create-Group/Button-Delete'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/ROLE/Create-userRole/Button-Yes, Delete it'))
	WebUI.delay(2)
	
}