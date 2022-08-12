package ar.edu.etec.programacion4.pdfsimplejava.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ar.edu.etec.programacion4.pdfsimplejava.model.Licencia;
import ar.edu.etec.programacion4.pdfsimplejava.repository.LicenciaRepository;

@Service
public class LicenciaService {

	@Autowired
	private LicenciaRepository licenciaRepository;

	public Licencia save(Licencia licencia) {
		return licenciaRepository.save(licencia);
	}

	public String generatePdf(Long legajoId) {
		String filename = "licencia." + legajoId + ".pdf";

		return makePdf(filename, legajoId);
	}

	@Transactional
	public String makePdf(String filename, Long legajoId) {

		Licencia licencia = licenciaRepository.findByLegajoId(legajoId);

		try {

			Document document = new Document(new Rectangle(PageSize.A4));
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.setMargins(20, 20, 20, 20);

			document.open();

			// Tabla Cliente
			float[] columnHeader = { 2, 3 };
			PdfPTable tableHeader = new PdfPTable(columnHeader);
			tableHeader.setWidthPercentage(100);

			Paragraph paragraph = new Paragraph("Aguas", new Font(Font.HELVETICA, 12, Font.BOLD));
			PdfPCell cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setLeading(0, 1.5f);
			tableHeader.addCell(cell);

			paragraph = new Paragraph(licencia.getLegajoId().toString(), new Font(Font.HELVETICA, 12, Font.BOLD));
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setLeading(0, 1.5f);
			tableHeader.addCell(cell);
			document.add(tableHeader);
			
			paragraph = new Paragraph(licencia.getApellido() + ", " + licencia.getNombre());
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
//
			//
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return filename;
	}

}
