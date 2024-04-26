import java.util.Objects;


public class Document {

    private PaperSize paperSize;

    private DocumentType documentType;

    private int printDuration;

    private int sequence;

    public Document(PaperSize paperSize, DocumentType documentType, int printDuration, int sequence) {
        this.paperSize = paperSize;
        this.documentType = documentType;
        this.printDuration = printDuration;
        this.sequence = sequence;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public int getPrintDuration() {
        return printDuration;
    }

    public int getSequence() {
        return sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return printDuration == document.printDuration && sequence == document.sequence && paperSize == document.paperSize && documentType == document.documentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperSize, documentType, printDuration, sequence);
    }

    @Override
    public String toString() {
        return "Document{" +
                "paperSize=" + paperSize +
                ", documentType=" + documentType +
                ", printDuration=" + printDuration +
                ", sequence=" + sequence +
                '}';
    }
}
