package com.chsu.shedule.pdf;

import com.chsu.shedule.domain.Rasp;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class PDFDocument extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Map rasps = (Map) map.get("msg");
//        Integer msg = (Integer) map.get("msg");
//        String msg = (String) map.get("msg");
//        rasps.size();
        document.add(new Paragraph("Recommended books for Spring framework " + rasps.size()));
//        for (Iterator<Map.Entry<String, ArrayList<Rasp>>> it = rasps.entrySet().iterator(); it.hasNext();) {
//            Map.Entry<String, ArrayList<Rasp>> temp = it.next();
//            document.add(new Paragraph("temp.getKey()"));
//        }
    
    }

    
    
}
