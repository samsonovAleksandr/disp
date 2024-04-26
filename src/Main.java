public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        Document doc1 = new Document(PaperSize.A1, DocumentType.ORDER, 5, 1);
        Document doc2 = new Document(PaperSize.A2, DocumentType.ORDER, 6, 2);
        Document doc3 = new Document(PaperSize.A3, DocumentType.AGREEMENT, 3, 3);
        Document doc4 = new Document(PaperSize.A3, DocumentType.DEED_OF_SALE, 10, 4);

        dispatcher.acceptTheDocument(doc1);
        dispatcher.acceptTheDocument(doc2);
        dispatcher.acceptTheDocument(doc3);
        dispatcher.acceptTheDocument(doc4);

        dispatcher.cancelPrinting(doc4);

        dispatcher.startPrinting();

        System.out.println(dispatcher.avgPrint());

        dispatcher.sortedLst(1);
        System.out.println(dispatcher.documentList);

        dispatcher.sortedLst(2);
        System.out.println(dispatcher.documentList);

        dispatcher.sortedLst(3);
        System.out.println(dispatcher.documentList);

        dispatcher.sortedLst(4);
        System.out.println(dispatcher.documentList);

    }
}