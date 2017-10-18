/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import com.mycompany.tcclib.modelo.TCC;
import com.mycompany.tcclib.modelo.TCCMongoDao;
import com.mycompany.tcclib.modelo.TCCNeo4jDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ThigoYure
 */
public class BuscaTcc extends SimpleTagSupport {

    private int id;

    @Override
    public void  doTag() {
        TCCNeo4jDao tccneo4jDao = new TCCNeo4jDao();
        TCCMongoDao tccMongoDao = new TCCMongoDao();
        TCC tcc = tccMongoDao.read(id);
        List<Integer> lista = tccneo4jDao.sugerir(tcc);
        ArrayList<TCC> sugestoes = new ArrayList<>();
        for(int i=0; i<lista.size();i++){
            TCC t = tccMongoDao.read(lista.get(i));
            sugestoes.add(t);
        }
        getJspContext().setAttribute("pdf", tcc);   
        getJspContext().setAttribute("TCCS", sugestoes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
