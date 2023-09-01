package com.sts.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sts.entity.CitizenPlan;
import com.sts.repo.CitizenPlanRepository;

@Component
public class PdfGenerator {
	
	private CitizenPlanRepository planRepo;
	
	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File f) throws Exception {
		
        Document document=new Document(PageSize.A3);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		
		document.open();
		
		Font font=FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setSize(20);
		
		Paragraph p=new Paragraph("CITIZEN PLANS INFO", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table=new PdfPTable(8);
		table.setSpacingBefore(5);
		table.addCell("Id");
		table.addCell("Holder Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amt");
		
		
		for(CitizenPlan plan: plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(String.valueOf(plan.getCitizenName()));
			table.addCell(String.valueOf(plan.getGender()));
			table.addCell(String.valueOf(plan.getPlanName()));
			table.addCell(String.valueOf(plan.getPlanStatus()));
			table.addCell(String.valueOf(plan.getPlanStartDate()));
			table.addCell(String.valueOf(plan.getPlanEndDate()));
			table.addCell(String.valueOf(plan.getBenefitAmt()));
			
		}
		
		document.add(table);
		
		document.close();
		
		
	}

}
