package com.cidenet.hulkstore.controller.reports;

import com.cidenet.hulkstore.stores.StoreDto;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Reports Controller
 * 
 * Generate inventory control reports.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-14
 */
public class CReports implements IReports {

    @Override
    public void generateStoreReport(StoreDto[] stores, ArrayList<String> header) {
        JFileChooser save = new JFileChooser();
        
        save.setDialogTitle("Guardar Reporte PDF");
        FileFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf");
        save.setAcceptAllFileFilterUsed(false);
        save.setFileFilter(filter);
        
        int option=save.showSaveDialog(null);

        if(option==JFileChooser.APPROVE_OPTION)
        {
            try
            {
                Document document = new Document(PageSize.A4, 40, 40, 20, 20);
                String path = save.getSelectedFile().getAbsoluteFile() + "";
                
                if(!path.substring(path.length() - 3, path.length()).equals("pdf")) {
                    path = path + ".pdf";}
                                
                PdfWriter.getInstance(document, new FileOutputStream(path));
                
                document.open();               
               
                Paragraph endLine = new Paragraph("\n", FontFactory.getFont(FontFactory.COURIER_BOLD, 10, BaseColor.BLACK));
                
                // START OF REPORT                
                Paragraph paragraph = new Paragraph("TIENDAS\n\n", FontFactory.getFont(FontFactory.COURIER_BOLD, 14, BaseColor.BLACK));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                document.add(paragraph);
                
                PdfPTable pdfTable = new PdfPTable(1);
                pdfTable.setTotalWidth(PageSize.A4.getWidth() - 80);
                pdfTable.setLockedWidth(true);
                
                PdfPCell pdfCell = new PdfPCell(new Paragraph("REPORTE DE TIENDAS ACTIVAS", FontFactory.getFont(FontFactory.COURIER, 17, Font.BOLD, BaseColor.WHITE)));
                pdfCell.setFixedHeight(40);
                pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfCell.setBackgroundColor(BaseColor.BLACK);
                pdfTable.addCell(pdfCell);
                document.add(pdfTable);
                document.add(endLine);
                
                // DATA                
                pdfTable = new PdfPTable(1);
                pdfTable.setTotalWidth(PageSize.A4.getWidth() - 80);
                pdfTable.setLockedWidth(true);
                
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy 'a las' hh:mm a");
              
                pdfCell = new PdfPCell(new Paragraph("Sistema de Control de Inventarios Kardex - Reporte\nGenerado el " + format.format(calendar.getTime()), FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK)));
                pdfCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                pdfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfCell.setBackgroundColor(BaseColor.WHITE);
                pdfCell.setPadding(10);
                pdfTable.addCell(pdfCell);
                document.add(pdfTable);
                document.add(endLine);
                
                // TABLE HEADER
                pdfTable = new PdfPTable(header.size());
                pdfTable.setTotalWidth(PageSize.A4.getWidth() - 80);
                pdfTable.setLockedWidth(true);

                for (String column : header) {
                    pdfCell = new PdfPCell(new Paragraph(column, FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, BaseColor.WHITE)));
                    pdfCell.setFixedHeight(30);
                    pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pdfCell.setBackgroundColor(new BaseColor(51, 139, 204));
                    pdfCell.setBorderColor(BaseColor.WHITE);
                    pdfCell.setBorderWidth(1);
                    pdfTable.addCell(pdfCell);
                }
               
                // DATA TABLE
                for(int i = 0; i < stores.length; i++)
                {
                    for(int j = 0; j <= 2; j++)
                    {
                        String fact = "";
                        switch(j){
                            case 0:
                                fact = String.valueOf(stores[i].getStoreId());
                                break;
                            
                            case 1:
                                fact = stores[i].getStoreName();
                                break;
                                
                            case 2:
                                fact = stores[i].getAddress();
                                break;
                        }
                        
                        pdfCell = new PdfPCell(new Paragraph(fact, FontFactory.getFont(FontFactory.COURIER, 8, Font.BOLD, BaseColor.BLACK)));
                        pdfCell.setFixedHeight(20);
                        pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        
                        
                        if(i%2 == 0)
                        {
                            pdfCell.setBackgroundColor(BaseColor.WHITE);
                            pdfCell.setBorderColor(BaseColor.WHITE);
                        }
                        else
                        {
                            pdfCell.setBackgroundColor(new BaseColor(228, 239, 248));
                            pdfCell.setBorderColor(new BaseColor(228, 239, 248));
                        }
                        pdfTable.addCell(pdfCell);
                        
                    }
                }
                document.add(pdfTable);
                document.close();
                JOptionPane.showMessageDialog(null, "Se ha generado el reporte.", "REPORTE", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (DocumentException | IOException ex){}
        }
    }
    
}
