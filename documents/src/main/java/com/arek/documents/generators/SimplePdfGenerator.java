package com.arek.documents.generators;


import com.arek.files.resource.DirectoryResource;
import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public final class SimplePdfGenerator implements PdfGenerator {

    private static final String PDF = ".pdf";

    private final TemplateEngine templateEngine;
    private final DirectoryResource directoryResource;

    @Override
    public File generatePdf(final String templateFileName,
            final Map<String, Object> contentVariables) throws Exception {
        Objects.requireNonNull(templateFileName, "templateFileName can't be null");
        Objects.requireNonNull(contentVariables, "contentVariables can't be null");

        final String pdfContent = generateContent(templateFileName, contentVariables);
        return generateFile(templateFileName, pdfContent);
    }

    private String generateContent(final String templateFileName,
            final Map<String, Object> contentVariables) {

        final Context context = new Context(Locale.getDefault(), contentVariables);
        return templateEngine.process(templateFileName, context);
    }

    private File generateFile(final String filename, final String pdfContent)
            throws IOException, DocumentException {
        final File pdf = prepareFile(filename);
        try (FileOutputStream fileOutputStream = new FileOutputStream(pdf)) {
            final ITextRenderer pdfRenderer = new ITextRenderer();
            pdfRenderer.setDocumentFromString(pdfContent);
            pdfRenderer.layout();
            pdfRenderer.createPDF(fileOutputStream);
        }
        return pdf;
    }

    private File prepareFile(final String filename) {
        final Path directory = Paths.get(directoryResource.getTmpPath());
        final Path filePath = directory.resolve(filename + PDF);
        return filePath.toFile();
    }
}
