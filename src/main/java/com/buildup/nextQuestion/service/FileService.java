package com.buildup.nextQuestion.service;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class FileService {

    public String extractTextFromPDF(MultipartFile file) throws IOException {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            return pdfTextStripper.getText(document);
        }
    }

    public void validateFile(MultipartFile file){
        if (file == null) {
            throw new IllegalArgumentException("PDF file is required.");
        }

        // 파일 형식이 PDF가 아닌 경우
        if (!file.getOriginalFilename().endsWith(".pdf")) {
            throw new IllegalArgumentException("Only PDF files are allowed.");
        }
    }

}
