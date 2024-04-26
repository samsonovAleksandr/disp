import java.util.*;

public class Dispatcher {

    Queue<Document> documents;
    List<Document> documentList;

    public Dispatcher() {
        documents = new PriorityQueue<>(Comparator.comparingInt(Document::getSequence));
        documentList = new ArrayList<>();
    }

    public List<Document> stop() {
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
        documents.offer(document);
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
        return time;
    }

    public void startPrinting() {
        while (!documents.isEmpty()) {
            Document document = documents.poll();
            System.out.println("Print doc " + document);
            documentList.add(document);
        }
    }


}
