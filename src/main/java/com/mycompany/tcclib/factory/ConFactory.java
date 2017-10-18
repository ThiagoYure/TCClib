/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.factory;

import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import redis.clients.jedis.Jedis;

/**
 *
 * @author ThigoYure
 */
public class ConFactory {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/TCCLib";
        String usuario = "postgres";
        String senha = "kabuto123456";

        return DriverManager.getConnection(url, usuario, senha);
    }

    public static MongoClient getConnectionMongo() {
        return new MongoClient("127.0.0.1", 27017);
    }

    public static Session getConnectionNeo4j() {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "siegfried"));
        return driver.session();
    }

    public static Jedis getConnectionRedis() {
        return new Jedis("127.0.0.1", 6379);
    }
}
