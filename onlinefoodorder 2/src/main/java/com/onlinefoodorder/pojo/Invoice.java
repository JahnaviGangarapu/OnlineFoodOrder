package com.onlinefoodorder.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class Invoice extends AbstractPdfView{
	
	
	List<String> orderList;

	public Invoice(List<String> orderList) {
		super();
		this.orderList = orderList;
	}










	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		for(String s : orderList) {
			System.out.println("s: " + s);
			Paragraph paragraph = new Paragraph(s);
			document.add(paragraph);
		}
		
        
        
        
		
		
	}

}
