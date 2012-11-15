package com.tistory.devyongsik.handler;

import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;

import com.tistory.devyongsik.domain.CrescentCollectionField;

public interface Handler {

	List<Document> handledData(String jsonFormStr, Map<String, CrescentCollectionField> fieldsByName);
}
