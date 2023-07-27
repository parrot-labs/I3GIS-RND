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
import groovy.ui.SystemOutputInterceptor as SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.awt.Robot as Robot
import java.awt.event.KeyEvent

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

import org.apache.poi.ss.usermodel.Sheet as Sheet
import org.apache.poi.ss.usermodel.Workbook as Workbook
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunCofiguration

//import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

//String kalimat = 'Aku suka dia, dia nya engga'
//int panjang = kalimat.length();
//println(panjang)
//boolean scanning = true
//while (scanning == true) {
//	scanning = WebUI.verifyTextPresent('Starting instance', false, FailureHandling.OPTIONAL)
//}
//WebUI.openBrowser('https://www.facebook.com/BRIofficialpage')
//
//WebUI.maximizeWindow()

//try {
//	long lastHeight=((Number) WebUI.executeJavaScript("return document.body.scrollHeight", null)).longValue();
//  
//	while (true) {
//	  WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null);
//	  Thread.sleep(2000);
//	  long newHeight = ((Number)WebUI.executeJavaScript("return document.body.scrollHeight", null)).longValue();
//	  if (newHeight == lastHeight) {
//		break;
//	  }
//	  lastHeight = newHeight;
//	}
//  } catch (InterruptedException e) {
//   e.printStackTrace();
//  }

  
//  long lastHeight=((Number) WebUI.executeJavaScript("return document.body.scrollHeight", null)).longValue();
//  int height = lastHeight
//  println(height)
//  WebUI.scrollToPosition(height, height)
//TestData input = findTestData('Data Files/project')
//
//for (int baris = 1; baris <= 1; baris++) {
//	//WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-'+input.getValue('branch', baris)))
//	//WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Group User'), 0, FailureHandling.OPTIONAL)
//	
//	TestObject data = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[5]/div/div/div/div[3]/div/div[1]/div/div/div/div[2]/div/div[1]/div/div[3]/div[2]/div[2]")
//	String repoaccess = WebUI.getText(data)
//	println(repoaccess)
//	String nama = input.getValue('access', baris)
//	String repo = nama.toUpperCase();
//	println(repo)
//	
//	
//}

//String userDir = RunCofiguration.getProjectDir()
//TestData input = findTestData('Data Files/DAST')
//
//for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
////	WebUI.click(findTestObject('Object Repository/07-DAST/Edit-project/General-Setting/Button-Setting'))
////	WebUI.delay(1)
////	WebUI.scrollToElement(findTestObject('Object Repository/07-DAST/Edit-project/Delete-site/Input-sitename'), 0, FailureHandling.OPTIONAL)
//	if(input.getValue('site-type', baris)== 'API') {
//		WebUI.setText(findTestObject('Object Repository/07-DAST/Edit-project/Delete-site/Input-sitename'), input.getValue('site-name-api', baris))
//		WebUI.delay(1)
//	}else {
//		WebUI.setText(findTestObject('Object Repository/07-DAST/Edit-project/Delete-site/Input-sitename'), input.getValue('site-name', baris))
//		WebUI.delay(1)
//	}
//}


//for (int div = 1; div <= 10; div++) {
//	isbreak = false
//	TestObject url = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[3]/div[1]/table/tbody/tr[$div]/td[2]/div")
//	String urlpars = WebUI.getText(url)
//	println(urlpars)
//	if(urlpars == 'https://opensource-demo.orangehrmlive.com/') {
//		TestObject button = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[3]/div[1]/table/tbody/tr[$div]/td[3]/button")
//		WebUI.click(button)
//		isbreak = true
//		break;
//	}
//}

String text = WebUI.getText(findTestObject('Object Repository/07-DAST/Issue-Context/See-Detail/Verify-Status'))
println(text)