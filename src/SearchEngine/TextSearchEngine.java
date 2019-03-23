package SearchEngine;

 import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
 
public class TextSearchEngine
{
    private static final String IndexDirectory = "test/temp/index";

   //creates documents to store in the indexWriter of the search engine
    public static void main(String[] args) throws Exception
    {
        IndexWriter writer = createWriter();
        List<Document> documents = new ArrayList<>();
         
        //used to drop the meme content into the search after parsing
        Document document1 = createDocument(1, "This is a test-meme", "google.com");
        documents.add(document1);
         
        Document document2 = createDocument(2, "Lorem ipsum dolor sit amet", "google.com");
        documents.add(document2);
        
        //clear the writer of all documents just for a test
        writer.deleteAll();
         
        //add them back
        writer.addDocuments(documents);
        writer.commit();
        writer.close();
    }

    //format of the document creation
    private static Document createDocument(Integer id, String textContent, String siteLink)
    {
        Document document = new Document();
        document.add(new StringField("id", id.toString() , Field.Store.YES));
        document.add(new TextField("content", textContent , Field.Store.YES));
        document.add(new TextField("site", siteLink , Field.Store.YES));
        return document;
    }

    //indexWriter configs
    private static IndexWriter createWriter() throws IOException
    {
        FSDirectory dir = FSDirectory.open(Paths.get(IndexDirectory));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(dir, config);
        return writer;
    }
}