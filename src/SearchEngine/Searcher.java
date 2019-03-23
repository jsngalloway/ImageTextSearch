package SearchEngine;

import java.io.IOException;
import java.nio.file.Paths;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
 
public class Searcher
{
    private static final String IndexDirectory = "test/temp/index";
    
    //searches through the engine for cataloged items
    public static void main(String[] args) throws Exception
    {
        IndexSearcher memeSearcher = createSearcher();
         
        //Search by meme content
        TopDocs foundMemes = searchByTextContent("placeholder", memeSearcher);
         
        System.out.println("Results: " + foundMemes.totalHits);
         
        for (ScoreDoc sd : foundMemes.scoreDocs)
        {
            Document d = memeSearcher.doc(sd.doc);
            System.out.println(String.format(d.get("id")));
        }
    }
    
    //launch query on text input
    private static TopDocs searchByTextContent(String searchItems, IndexSearcher searcher) throws Exception
    {
        QueryParser qp = new QueryParser("Text Search", new StandardAnalyzer());
        Query textContentQuery = qp.parse(searchItems);
        TopDocs hits = searcher.search(textContentQuery, 10);
        return hits;
    }
    
    //
    private static IndexSearcher createSearcher() throws IOException {
        Directory dir = FSDirectory.open(Paths.get(IndexDirectory));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }
}