package com.sts.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.sts.entity.CitizenPlan;
import com.sts.repo.CitizenPlanRepository;

@Component
public class ExcelGenerator {
	
	private CitizenPlanRepository planRepo;
	
	public void generate(HttpServletResponse response,List<CitizenPlan> records, File file) throws Exception{
		
		Workbook workbook= new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amt");
		
		
		
		int rowIndex=1;
		
		for(CitizenPlan plan: records) {
			Row row=sheet.createRow(rowIndex);
			row.createCell(0).setCellValue(plan.getCitizenId());
			row.createCell(1).setCellValue(plan.getCitizenName());
			row.createCell(2).setCellValue(plan.getGender());
			row.createCell(3).setCellValue(plan.getPlanName());
			row.createCell(4).setCellValue(plan.getPlanStatus());
			
			
			if(null != plan.getPlanStartDate()) {
				row.createCell(5).setCellValue(plan.getPlanStartDate()+"");
			}else {
				row.createCell(5).setCellValue("N/A");
			}
			
			if(null != plan.getPlanEndDate()) {
				row.createCell(6).setCellValue(plan.getPlanEndDate()+"");
			}else {
				row.createCell(6).setCellValue("N/A");
			}
			
			if(null != plan.getBenefitAmt()) {
				row.createCell(7).setCellValue(plan.getBenefitAmt());
			}else {
				row.createCell(7).setCellValue("N/A");
			}
			rowIndex++;
		}
	    
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		
		
		ServletOutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
		
	}
	

}
