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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import org.apache.poi.ss.usermodel.Sheet as Sheet
import org.apache.poi.ss.usermodel.Workbook as Workbook

TestData input = findTestData('Data Files/ROLE/00-Role')

for (int baris = 2; baris <= input.getRowNumbers(); baris++) {
	if (input.getValue('101', baris) || input.getValue('102', baris) || input.getValue('201', baris) || input.getValue('202', baris) == 'yes') {
		
		WebUI.callTestCase(findTestCase('Test Cases/00-Login/01-Login-sukses'), null)
		WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/ROLE-EXTEND/101'), null)
		WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-ROLE'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/ROLE/Role-Management/Input-SearchRoleName'), 'role-custom')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/ROLE/Role-Management/Setting-role'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/ROLE/Role-Management/Button-EditRole'))
		WebUI.delay(2)
		for (int custom = 3; custom <= 5; custom++) {
			TestObject checkbox = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//input[@type='checkbox'])[$custom]")
			if (WebUI.verifyElementChecked(checkbox, 0, FailureHandling.OPTIONAL)) {
				WebUI.click(checkbox)
			} else {
				WebUI.click(checkbox)
				WebUI.click(checkbox)
			}
		}
		if (input.getValue('101', baris) && input.getValue('102', baris) == 'yes') {
			WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/prefix-1'))
			WebUI.delay(1)
		}else {
			WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/Expand-i3gisGeneral'))
			WebUI.delay(1)
			if (input.getValue('101', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/view-admin'))
				WebUI.delay(1)
			}else if (input.getValue('102', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/manage-admin'))
				WebUI.delay(1)
			}
			WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/Expand-i3gisGeneral'))
			WebUI.delay(1)
		}
		if (input.getValue('201', baris) && input.getValue('202', baris) && input.getValue('203', baris) == 'yes') {
			WebUI.click(findTestObject('Object Repository/ROLE/report-Security/prefix-2'))
			WebUI.delay(1)
		}else {
			WebUI.click(findTestObject('Object Repository/ROLE/report-Security/Expand-report-security'))
			WebUI.delay(1)
			if(input.getValue('201', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/report-Security/manage-audit-log'))
				WebUI.delay(1)
			}else if (input.getValue('202', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/report-Security/manage-application-report'))
				WebUI.delay(1)
			}else if (input.getValue('203', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/report-Security/manage-dynamic-report'))
				WebUI.delay(1)
			}
			WebUI.click(findTestObject('Object Repository/ROLE/report-Security/Expand-report-security'))
			WebUI.delay(1)
		}
		if (input.getValue('301', baris) && input.getValue('302', baris) && input.getValue('303', baris) && input.getValue('304', baris) && input.getValue('305', baris) && input.getValue('306', baris) && input.getValue('307', baris) && input.getValue('308', baris) && input.getValue('309', baris) && input.getValue('310', baris) && input.getValue('311', baris) == 'yes') {
			WebUI.click(findTestObject('Object Repository/ROLE/application-security/prefix-3'))
			WebUI.delay(1)
		}else {
			WebUI.click(findTestObject('Object Repository/ROLE/application-security/Expand-application-security'))
			WebUI.delay(1)
			if (input.getValue('301', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-project'))
				WebUI.delay(1)
			}else if  (input.getValue('302', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-project'))
				WebUI.delay(1)
			}else if  (input.getValue('303', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/run-application-scan'))
				WebUI.delay(1)
			}else if  (input.getValue('304', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-sast'))
				WebUI.delay(1)
			}else if  (input.getValue('305', baris) == 'yes') {
				WebUI.scrollToElement(findTestObject('Object Repository/ROLE/application-security/view-sast'), 0)
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-sast'))
				WebUI.delay(1)
			}else if  (input.getValue('306', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-secret-check'))
				WebUI.delay(1)
			}else if  (input.getValue('307', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-secret-check'))
				WebUI.delay(1)
			}else if  (input.getValue('308', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-sca'))
				WebUI.delay(1)
			}else if  (input.getValue('309', baris) == 'yes') {
				WebUI.scrollToElement(findTestObject('Object Repository/ROLE/application-security/view-misconf'), 0)
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-sca'))
				WebUI.delay(1)
			}else if  (input.getValue('310', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-misconf'))
				WebUI.delay(1)
			}else if  (input.getValue('311', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-misconf'))
				WebUI.delay(1)
			}
			WebUI.scrollToElement(findTestObject('Object Repository/ROLE/application-security/Expand-application-security'), 0)
			WebUI.click(findTestObject('Object Repository/ROLE/application-security/Expand-application-security'))
			WebUI.delay(1)
		}
		WebUI.click(findTestObject('Object Repository/ROLE/Role-Management/Button-Saverole'))
		WebUI.delay(2)
		WebUI.callTestCase(findTestCase('Test Cases/00-Logout/00-Logout-sukses'), null)
		WebUI.callTestCase(findTestCase('Test Cases/00-Login/01-Login-sukses-admin'), null)
		WebUI.delay(2)
		if (input.getValue('101', baris) == 'yes') {
			WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/ROLE-EXTEND/101'), null)
			TestObject group = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div/div/div[2]/div/button[2]")
			WebUI.click(group)
			WebUI.delay(1)
			for (int row = 3; row <= 3; row++) {
				TestObject team_management = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[$row]")
				WebUI.click(team_management)
				WebUI.delay(1)
			}
			WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-USER'))
			WebUI.delay(1)
			
			team_manage = WebUI.verifyElementClickable(findTestObject('Object Repository/ROLE/Menu/Administration/Button-TeamManagement'))
			if(team_manage == true) {
				WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-TeamManagement'))
				WebUI.delay(1)
			}
			manage_org = WebUI.verifyElementClickable(findTestObject('Object Repository/ROLE/Menu/Administration/BButton-ManageOrganization'))
			if(manage_org == true) {
				WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/BButton-ManageOrganization'))
				WebUI.delay(1)
			}
			notif = WebUI.verifyElementClickable(findTestObject('Object Repository/ROLE/Menu/Administration/Button-Notification'))
			if(notif == true) {
				WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-Notification'))
				WebUI.delay(1)
			}
			WebUI.delay(1)
			String Data = './excel/role.xlsx'
			Workbook excel = ExcelKeywords.getWorkbook(Data)
			Sheet sheet = excel.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 20; kol <= 20; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data, excel)
					if (team_manage && manage_org && notif) {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data, excel)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data, excel)
					}
				}
			}
			WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-Administration'))
			WebUI.delay(1)
			if (input.getValue('102', baris) == 'yes') {
				for (int row1 = 48; row1 <= 50; row1++) {
					WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/ROLE-EXTEND/101'), null)
					TestObject cek_manage = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[51]")
					TestObject admis = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[$row1]")
					admis1 = WebUI.verifyElementClickable(admis)
					if(admis1 == true) {
						WebUI.click(admis)
						WebUI.delay(1)
					}
					cek_manage1 = WebUI.verifyElementClickable(cek_manage)
					if(cek_manage1 == true) {
					WebUI.click(cek_manage)
					WebUI.delay(1)
					switch (row1) {
						case '48':
						WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/00-Create-user'), null)
							break
						case '49':
						WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/00-Create-group'), null)
							break
						case '50':
						WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/00-Create-role'), null)
								break
					}
					WebUI.refresh()
					}
					String Data1 = './excel/role.xlsx'
					Workbook excel1 = ExcelKeywords.getWorkbook(Data1)
					Sheet sheet1 = excel1.getSheet('Sheet1')
					for (int bar = baris; bar <= baris; bar++) {
						for (int kol = 21; kol <= 21; kol++) {
							ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, null)
							ExcelKeywords.saveWorkbook(Data1, excel1)
							if (admis1 && cek_manage1) {
								ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, 'Pass')
								ExcelKeywords.saveWorkbook(Data1, excel1)
							} else {
								ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, 'Fail')
								ExcelKeywords.saveWorkbook(Data1, excel1)
							}
						}
					}
				}
			}
		}
		
		if (input.getValue('201', baris) == 'yes') {
			auditlog = WebUI.verifyElementClickable(findTestObject('Object Repository/ROLE/Menu/Report-Security/Button-AuditLog'))
			if(auditlog == true) {
				WebUI.click(findTestObject('Object Repository/ROLE/Menu/Report-Security/Button-AuditLog'))
				WebUI.delay(1)
				String name_audit = WebUI.getText(findTestObject('Object Repository/ROLE/Menu/Report-Security/name-audit'))
				WebUI.setText(findTestObject('Object Repository/ROLE/Menu/Report-Security/input-authorAudit'), name_audit)
				WebUI.delay(1)
				WebUI.sendKeys(findTestObject('Object Repository/ROLE/Menu/Report-Security/input-authorAudit'), Keys.chord(Keys.ENTER))
				WebUI.delay(1)
			}
			
			String Data2 = './excel/role.xlsx'
			Workbook excel2 = ExcelKeywords.getWorkbook(Data2)
			Sheet sheet2 = excel2.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 22; kol <= 22; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet2, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data2, excel2)
					if (auditlog) {
						ExcelKeywords.setValueToCellByIndex(sheet2, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data2, excel2)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet2, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data2, excel2)
					}
				}
			}
		}
		
		if (input.getValue('202', baris) == 'yes') {
			WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/ROLE-EXTEND/202'), null)
			generate = WebUI.verifyElementClickable(findTestObject('Object Repository/ROLE/Menu/Report-Security/Button-Generate Report'))
			if(generate == true) {
				WebUI.click(findTestObject('Object Repository/ROLE/Menu/Report-Security/Button-Generate Report'))
				WebUI.delay(6)
				WebUI.click(findTestObject('Object Repository/ROLE/Menu/Report-Security/dashboard'))
				WebUI.delay(3)
				WebUI.refresh()
				WebUI.delay(3)
			}
			String Data3 = './excel/role.xlsx'
			Workbook excel3 = ExcelKeywords.getWorkbook(Data3)
			Sheet sheet3 = excel3.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 23; kol <= 23; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet3, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data3, excel3)
					if (generate) {
						ExcelKeywords.setValueToCellByIndex(sheet3, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data3, excel3)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet3, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data3, excel3)
					}
				}
			}
		}

		WebUI.callTestCase(findTestCase('Test Cases/00-Logout/00-Logout-sukses'), null)
		
	}
}