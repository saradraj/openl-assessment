package com.ol.assessment.util;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class PDFUtil {

	public static String readPDF() {
		PDDocument document = null;
		PDDocumentInformation info = null;
		String title = null;
		try {
			document = PDDocument.load(new File(
					"C:\\personal\\ol\\Open Lending to Announce First Quarter 2021 Results on May 11, 2021.pdf"));
			info = document.getDocumentInformation();
			title = info.getTitle();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (document != null)
				try {
					document.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return title;
	}

}
