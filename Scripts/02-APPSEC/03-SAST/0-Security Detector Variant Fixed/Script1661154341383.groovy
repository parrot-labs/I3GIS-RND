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

TestObject object1 = findTestObject('Object Repository/03-SAST/03-Security Detector/Issue Category')
TestObject object2 = findTestObject('Object Repository/03-SAST/03-Security Detector/Review Priority')
String category = WebUI.getText(object1)
String priority = WebUI.getText(object2)

for (int baris = 1; baris <= 1; baris++) {
	
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Button Change Status'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Div Fixed'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/03-SAST/03-Security Detector/Input Comment'), input.getValue('comment1', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Button Change Status1'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Change Status/Button Continue reviewing Security Hotspot'))
	WebUI.delay(4)
}
WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Filter/Button Filter Review'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Security Detector/Filter/Div Reviewed Fixed'))
WebUI.delay(2)

TestObject object3 = findTestObject('Object Repository/03-SAST/03-Security Detector/Filter/Review Category')
TestObject object4 = findTestObject('Object Repository/03-SAST/03-Security Detector/Filter/Review Priority')
String category1 = WebUI.getText(object3)
String priority1 = WebUI.getText(object4)

WebUI.verifyEqual(category, category1, FailureHandling.OPTIONAL)
WebUI.verifyEqual(priority, priority1, FailureHandling.OPTIONAL)
println(category)
println(priority)
println(category1)
println(priority1)