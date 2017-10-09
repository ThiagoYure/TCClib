package com.mycompany.tcclib.modelo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;


public class LeitorPDF {

    private final BodyContentHandler handler;
    private final Metadata metadata;
    private final FileInputStream inputStream;
    private final ParseContext parseContext;
    
    public LeitorPDF(String path) throws FileNotFoundException{
        handler = new BodyContentHandler(-1);
        metadata = new Metadata();
        inputStream = new FileInputStream(new File(path));
        parseContext = new ParseContext();
    } 
    
    public String getText() throws IOException, SAXException, TikaException{
        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(inputStream, handler, metadata, parseContext);
        return handler.toString();
    }
    
    
    
}
