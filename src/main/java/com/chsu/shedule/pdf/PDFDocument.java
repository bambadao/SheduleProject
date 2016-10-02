package com.chsu.shedule.pdf;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFDocument extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Map rasps = (Map) map.get("raspMap");
        
        document.add(new Paragraph("Recommended books for Spring framework"));
    
    }

    
    
}
