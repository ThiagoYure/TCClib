/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcclib.modelo;

import com.mycompany.tcclib.factory.ConFactory;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

/**
 *
 * @author Ricarte
 */
public class TCCNeo4jDao {

    private Session session;

    public TCCNeo4jDao() {
        session = ConFactory.getConnectionNeo4j();
    }

    public void insertNode(TCC tcc) {
        if (!nodeTccExists(tcc.getId())) {
            session.run("CREATE (:Tcc{id: $id})",
                    Values.parameters("id", tcc.getId()));
        }
        if (!nodeAreaExists(tcc.getArea())) {
            session.run("CREATE (:Area{area: $area})",
                    Values.parameters("area", tcc.getArea()));
        }
        if (!nodeOrientadorExists(tcc.getOrientador())) {
            session.run("CREATE (:Orientador{nome: $nome})",
                    Values.parameters("nome", tcc.getOrientador()));
        }
    }

    public boolean nodeTccExists(int id) {
        boolean retorno = false;
        StatementResult result = session.run("MATCH (t:Tcc) "
                + "WHERE t.id = $id "
                + "RETURN DISTINCT true as retorno",
                Values.parameters("id", id));

        if (result.hasNext()) {
            retorno = Boolean.parseBoolean(result.next().get("retorno").toString());
        }
        return retorno;
    }

    public boolean nodeAreaExists(String area) {
        boolean retorno = false;
        StatementResult result = session.run("MATCH (a:Area) "
                + "WHERE a.area = $area "
                + "RETURN DISTINCT true as retorno",
                Values.parameters("area", area));

        if (result.hasNext()) {
            retorno = Boolean.parseBoolean(result.next().get("retorno").toString());
        }
        return retorno;
    }

    public boolean nodeOrientadorExists(String nome) {
        boolean retorno = false;
        StatementResult result = session.run("MATCH (o:Orientador) "
                + "WHERE o.nome = $nome "
                + "RETURN DISTINCT true as retorno",
                Values.parameters("nome", nome));

        if (result.hasNext()) {
            retorno = Boolean.parseBoolean(result.next().get("retorno").toString());
        }
        return retorno;
    }

    public void sessionClose() {
        session.close();
    }

    public void createRelationship(TCC tcc) {
        session.run("MATCH (t:Tcc{id:$id}), (a:Area{area:$area}), (o:Orientador{nome:$nome}) "
                + "CREATE (t)-[r:PERTENCE]->(a), (t)-[r1:ORIENTADO_POR]->(o)",
                Values.parameters("id", tcc.getId(), "area", tcc.getArea(),
                        "nome", tcc.getOrientador()));
    }

    public List<Integer> sugerir(TCC tcc) {
        StatementResult result = session.run("MATCH (t:Tcc),(a:Area), (tc:Tcc) "
                + "WHERE (t:Tcc{id:$id})-[:PERTENCE]->(a:Area) AND (tc:Tcc)-[:PERTENCE]->(a:Area) AND (tc.id <> t.id) RETURN tc.id as tccs",
                Values.parameters("id", tcc.getId()));
        List<Integer> sugestoes = new ArrayList<>();
        while (result.hasNext()) {
            sugestoes.add(result.next().get("tccs").asInt());
        }
        return sugestoes;
    }
}
