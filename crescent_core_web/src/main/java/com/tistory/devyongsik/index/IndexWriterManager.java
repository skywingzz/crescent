package com.tistory.devyongsik.index;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.NRTManager.TrackingIndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tistory.devyongsik.analyzer.KoreanAnalyzer;
import com.tistory.devyongsik.config.CrescentCollectionHandler;
import com.tistory.devyongsik.domain.CrescentCollection;
import com.tistory.devyongsik.domain.CrescentCollections;

public class IndexWriterManager {

	private static IndexWriterManager indexWriterManager = new IndexWriterManager();
	private Map<String, TrackingIndexWriter> indexWritersByCollectionName = new ConcurrentHashMap<String, TrackingIndexWriter>();
	private Logger logger = LoggerFactory.getLogger(IndexWriterManager.class);
	
	private IndexWriterManager() {
		try {
			initIndexWriter();
		} catch (IOException e) {
			throw new IllegalStateException("IndexWriter 생성 실패");
		}
	}
	
	public static IndexWriterManager getIndexWriterManager() {
		return indexWriterManager;
	}
	
	private void initIndexWriter() throws IOException {
		CrescentCollections collections = CrescentCollectionHandler.getInstance().getCrescentCollections();
		
		
		
		for(CrescentCollection crescentCollection : collections.getCrescentCollections()) {
			
			logger.info("collection name {}", crescentCollection.getName());
			
			String indexDir = crescentCollection.getIndexingDirectory();
			
			logger.info("index file dir ; {}", indexDir);
			
			Directory dir = FSDirectory.open(new File(indexDir));
			
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_35, new KoreanAnalyzer(true));
			IndexWriter indexWriter = new IndexWriter(dir, conf);
			TrackingIndexWriter trackingIndexWriter = new TrackingIndexWriter(indexWriter);
			indexWritersByCollectionName.put(crescentCollection.getName(), trackingIndexWriter);
			
			logger.info("index writer for collection {} is initialized...", crescentCollection.getName());
		}
	}
	
	public TrackingIndexWriter getTrackingIndexWriterBy(String collectionName) {
		return indexWritersByCollectionName.get(collectionName);
	}
}
