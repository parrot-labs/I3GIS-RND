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

WebUI.callTestCase(findTestCase('Test Cases/00-Login/00-Open-browser'), null)
//LOGIN
WebUI.setText(findTestObject('Object Repository/Login/Input Username'), GlobalVariable.admin[9])
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/Login/Input Password'), GlobalVariable.password)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Login/Div Remember me'))
WebUI.takeScreenshot()
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Login/Button Login'))
WebUI.waitForElementPresent(findTestObject('Object Repository/Login/Button Home'), 0, FailureHandling.OPTIONAL)
WebUI.verifyElementClickable(findTestObject('Object Repository/Login/Button Home'), FailureHandling.OPTIONAL)
//SELECT ORGANIZATION
WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Button_Organization'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.setText(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Input SearchOrganization'), 'Neeeell')
WebUI.delay(2)
WebUI.waitForElementClickable(findTestObject('Object Repository/01-Organization/01-Menu-Organization/div Organization'), 0, FailureHandling.OPTIONAL)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/div Organization'))
WebUI.delay(2)
//CREATTE NEW PROJECT
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Summary Project'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Button Project Current'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create New Project'))
WebUI.delay(1)
WebUI.waitForElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), 0, FailureHandling.OPTIONAL)
WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), 'Project-01')
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Description'), 'project-01')
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Repository Url'), 'https://github.com/ardionoroma/DVSA')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Repo Access'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Span-Public'))
WebUI.delay(1)
WebUI.verifyTextPresent('Your Repository is valid and connected', false)
WebUI.delay(1)
WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'), 0)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'))
WebUI.delay(5)
//SCAN PROJECT
WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/06-Scaning Project normal'), null)
WebUI.delay(1)