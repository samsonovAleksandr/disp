public class Main {
    public static void main(String[] args) throws InterruptedException {


        Document doc1 = new Document(PaperSize.A1, DocumentType.ORDER, 5);
        Document doc2 = new Document(PaperSize.A2, DocumentType.ORDER, 6);
        Document doc3 = new Document(PaperSize.A3, DocumentType.AGREEMENT, 3);
        Document doc4 = new Document(PaperSize.A3, DocumentType.DEED_OF_SALE, 10);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setDocument(doc1);
        Thread t = new Thread(dispatcher);
        t.start();
        Thread.sleep(500);


        dispatcher.setDocument(doc2);
        Thread t2 = new Thread(dispatcher);
        t2.start();
        Thread.sleep(500);

        dispatcher.setDocument(doc3);
        Thread t3 = new Thread(dispatcher);
        t3.start();
        Thread.sleep(500);

        dispatcher.setDocument(doc4);
        Thread t4 = new Thread(dispatcher);
        t4.start();
        Thread.sleep(500);


        dispatcher.cancelPrinting(doc4);

        dispatcher.startPrinting();
    }
}