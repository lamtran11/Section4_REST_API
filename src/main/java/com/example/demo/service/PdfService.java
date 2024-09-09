package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public class PdfService {

    public ByteArrayInputStream generateStudentPdf(Student student) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            // Load the custom font (Noto Sans or any Unicode font)
            File fontFile = new File("src/main/resources/fonts/NotoSansJP-Regular.otf");
            PDType0Font font = PDType0Font.load(document, fontFile);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(font, 18);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("Student Details");
            contentStream.newLine();
            contentStream.setFont(font, 12);
            contentStream.newLine();

            contentStream.showText("ID: " + student.getId());
            contentStream.newLine();
            contentStream.showText("First Name: " + student.getFirstName());
            contentStream.newLine();
            contentStream.showText("Last Name: " + student.getLastName());
            contentStream.newLine();
            contentStream.showText("Email: " + student.getEmail());
            contentStream.newLine();

            contentStream.endText();
            contentStream.close();

            document.save(out);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
