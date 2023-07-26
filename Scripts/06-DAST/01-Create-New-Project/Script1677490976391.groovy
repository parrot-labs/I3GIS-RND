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
import com.kms.katalon.core.configuration.RunConfiguration as RunCofiguration

String userDir = RunCofiguration.getProjectDir()
TestData input = findTestData('Data Files/DAST')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Button-DAST'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/Button-SiteScan'))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), Keys.chord(Keys.BACK_SPACE))
	if(input.getValue('site-type', baris)== 'API') {
		WebUI.setText(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), input.getValue('site-name-api', baris))
		WebUI.delay(1)
	}else {
		WebUI.setText(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), input.getValue('site-name', baris))
		WebUI.delay(1)
	}
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/07-DAST/Sites/div-Sites'), 0, FailureHandling.OPTIONAL) == true) {
		WebUI.callTestCase(findTestCase('Test Cases/06-DAST/03-Delete-project'), [:], FailureHandling.STOP_ON_FAILURE)
	}
	WebUI.waitForElementClickable(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Button-CreateSites'), 0)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Button-CreateSites'))
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-SitesName'), 0)
	WebUI.takeScreenshot()
	if(input.getValue('site-type', baris)== 'API') {
		WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-SitesName'), input.getValue('site-name-api', baris))
		WebUI.delay(1)
	}else {
		WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-SitesName'), input.getValue('site-name', baris))
		WebUI.delay(1)
	}
	WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-Description'), input.getValue('desc', baris))
	WebUI.delay(1)
	if(input.getValue('site-type', baris)== 'API') {
		WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-URL'), input.getValue('url-api', baris))
	WebUI.delay(1)
	}else {
		WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-URL'), input.getValue('url', baris))
		WebUI.delay(1)
	}
	WebUI.takeScreenshot()
	WebUI.scrollToElement(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Env-Site'), 0)
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-User'), input.getValue('users', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Select-User'))
	WebUI.setText(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Input-Group'), input.getValue('group-users', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Select-Group'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Env-Site'))
	WebUI.click(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/div-'+input.getValue('env-site', baris)))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Button-NextStep'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/07-DAST/ConfigureSites/Input-SiteType'), 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/Input-SiteType'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/div-'+input.getValue('site-type', baris)))
	WebUI.delay(1)
	if(input.getValue('site-type', baris)== 'API') {
		WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/API/Input-APIType'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/API/div-'+input.getValue('api-type', baris)))
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/07-DAST/Button-CreateSiteandNext'))
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/07-DAST/UploadCollection/Upload-Collection'), 0)
		WebUI.delay(1)
		WebUI.uploadFile(findTestObject('Object Repository/07-DAST/UploadCollection/Upload-Collection'), userDir + input.getValue('location-collection', baris))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/07-DAST/Button-UploadAndScan'))
		WebUI.delay(4)
		WebUI.waitForElementPresent(findTestObject('Object Repository/07-DAST/Button-AbortScan'), 0)
		boolean scanning = true
		while (scanning == true) {
			scanning = WebUI.verifyTextPresent('Starting instance for scanning your site...', false, FailureHandling.OPTIONAL)
		}
	}else {
		WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/div-'+input.getValue('scan-option', baris)))
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Auth-'+input.getValue('auth', baris)))
		WebUI.takeScreenshot()
		WebUI.scrollToElement(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-UsernameField'), 0)
		WebUI.setText(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-LoginURL'), input.getValue('url', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-Username'), input.getValue('username', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-Password'), input.getValue('password', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-UsernameField'), input.getValue('username-field', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-PasswordField'), input.getValue('password-field', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Input-SubmitField'), input.getValue('submit', baris))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/07-DAST/ConfigureSites/DynamicWebsite/Button-CreateSiteandScanSite'))
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/07-DAST/Button-AbortScan'), 0)
		WebUI.delay(2)
		boolean scanning = true
		while (scanning == true) {
			scanning = WebUI.verifyTextPresent('Preparing for scanning your site...', false, FailureHandling.OPTIONAL)
	}
	}
}