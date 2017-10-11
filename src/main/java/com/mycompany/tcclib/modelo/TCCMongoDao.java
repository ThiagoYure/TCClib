/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.modelo;

import com.mongodb.MongoTimeoutException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mycompany.tcclib.factory.ConFactory;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Ricarte
 */
public class TCCMongoDao {
    private MongoDatabase banco;
    private MongoCollection<Document> colecao;
    
    public TCCMongoDao(){
        banco = ConFactory.getConnectionMongo().getDatabase("Tcc");
        colecao = banco.getCollection("Tccs");
    }

    public boolean insert(Document d) {
        try {
            colecao.insertOne(d);
            ConFactory.getConnectionMongo().close();
            return true;
        } catch (MongoTimeoutException j) {
            ConFactory.getConnectionMongo().close();
            return false;
        }

    }
    
    public List<TCC> BuscaPorTexto(String query) {
        try {
            MongoCursor<Document> cursor = null;
            cursor = colecao.find(new Document("$text", new Document("$search", query))).
                    projection(Projections.metaTextScore("score")).
                    sort(Sorts.metaTextScore("score")).iterator();
            List<TCC> tccs = new ArrayList<>();

            while (cursor.hasNext()) {
                Document searchTCC = cursor.next();
                tccs.add(new TCC().fromDocument(searchTCC));
            }

            cursor.close();
            ConFactory.getConnectionMongo().close();
            return tccs;
        } catch (MongoTimeoutException j) {
            ConFactory.getConnectionMongo().close();
            return null;
        }

    }
}