package com.arek.documents.generators;

import java.io.File;
import java.util.Map;

public interface PdfGenerator {
    File generatePdf(final String templateName,
            final Map<String, Object> contentVariables) throws Exception;
}
