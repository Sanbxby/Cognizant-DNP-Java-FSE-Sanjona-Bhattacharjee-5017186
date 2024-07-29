interface Document {
    void open();
    void edit();
    void save();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }

    @Override
    public void edit() {
        System.out.println("Editing Word document");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void edit() {
        System.out.println("Editing PDF document");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document");
    }

    @Override
    public void edit() {
        System.out.println("Editing Excel document");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document");
    }
}

abstract class DocumentFactory {
    abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();
        wordDocument.edit();
        wordDocument.save();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();
        pdfDocument.edit();
        pdfDocument.save();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
        excelDocument.edit();
        excelDocument.save();
    }
}
