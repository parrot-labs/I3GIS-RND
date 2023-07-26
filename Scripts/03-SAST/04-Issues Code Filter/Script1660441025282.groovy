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
WebUI.click(findTestObject('Object Repository/03-SAST/Button SAST'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/Button Issues Code'))
WebUI.delay(1)
WebUI.waitForElementPresent(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Show Filter'), 0, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Show Filter'))
WebUI.delay(1)
WebUI.takeScreenshot()

//TYPES
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Types/Types'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Types/Div Code Smell'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Types/Div Bug'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Types/Div Vulnerability'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
//SEVERITIES
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Severities/Severities'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Severities/Div Info'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Severities/Div Minor'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Severities/Div Major'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Severities/Div Critical'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Severities/Div Blocker'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
//SCOPES
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Scopes/Scopes'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Scopes/Div Test Code'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Scopes/Div Main Code'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
//RESOLUTIONS
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Resolutions/Resolutions'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Resolutions/Div Unresolved'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Resolutions/Div False Poitive'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Resolutions/Div Wont Fix'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Resolutions/Div Fixed'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Resolutions/Div Removed'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
//STATUSES
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Statuses'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Div Open'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Div Confirmed'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Div Reopened'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Div Resolved'))
WebUI.delay(2)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Div Closed'))
WebUI.delay(2)
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Hide Filter'))
WebUI.delay(1)
WebUI.takeScreenshot()