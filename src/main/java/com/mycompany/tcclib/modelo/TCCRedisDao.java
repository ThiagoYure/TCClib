/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.modelo;

import com.google.gson.Gson;
import com.mycompany.tcclib.factory.ConFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 *
 * @author Ricarte
 */
public class TCCRedisDao {
    
    public boolean insert(TCC tcc) {

        Jedis jedis = ConFactory.getConnectionRedis();

        Gson gson = new Gson();
        String json = gson.toJson(tcc);

        try {
            return jedis.set("1", json).equals("OK");
        } catch (JedisConnectionException j) {
            return false;
        }
        
    }
    
    public TCC read() {

        Jedis jedis = ConFactory.getConnectionRedis();

        Gson gson = new Gson();
 
        try {
            TCC t = gson.fromJson(jedis.get("1"), TCC.class);
            return t;
        } catch (JedisConnectionException j) {
            return null;
        }
        
    }
    
    public boolean delete(TCC tcc) {

        Jedis jedis = ConFactory.getConnectionRedis();

        Gson gson = new Gson();
        String json = gson.toJson(tcc);

        try {
            jedis.del("1");
            return true;
        } catch (JedisConnectionException j) {
            return false;
        }
        
    }
    
}
