import java.util.*;

public class Dispatcher implements Runnable {

    int count = 1;

    volatile Document document;

    Queue<Document> documents;
    List<Document> documentList;

    public Dispatcher() {
        documents = new PriorityQueue<>(Comparator.comparingInt(Document::getSequence));
        documentList = new ArrayList<>();
    }

    @Override
    public void run() {
        acceptTheDocument(document);
    }

    public List<Document> stopPrint() {
        if (documents.isEmpty()) {
            return List.of();
        } else {
            List<Document> list = new ArrayList<>();

            while (documents.peek() != null) {
                list.add(documents.poll());
            }
            return list;
        }
    }

    public void acceptTheDocument(Document document) {
        document.setSequence(count);
        documents.offer(document);
        ++count;
    }

    public void cancelPrinting(Document document) {
        documents.remove(document);
    }

    public List<Document> sortedLst(int sortingType) {
        switch (sortingType) {
            case (1):
                documentList.sort(Comparator.comparingInt(Document::getPrintDuration));
                return documentList;
            case (2):
                documentList.sort(Comparator.comparing(Document::getDocumentType));
                return documentList;
            case (3):
                documentList.sort(Comparator.comparing(Document::getPaperSize));
                return documentList;
            case (4):
                documentList.sort(Comparator.comparingInt(Document::getSequence));
                return documentList;
            default:
                return List.of();
        }
    }

    public double avgPrint() {
        double time = 0.0;

        for (Document d : documentList) {
            time = d.getPrintDuration() + time;
        }
        time = time / documentList.size();
        return time;
    }

    public void startPrinting() {
        while (!documents.isEmpty()) {
            Document document = documents.poll();
            System.out.println("Print doc " + document);
            System.out.println(documentList.add(document));
        }
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
