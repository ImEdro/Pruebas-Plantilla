
package DB;

import Modelo.Noticia;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Oscar
 */
public class Noticias implements IBaseDatos<Noticia>{
    
    private Tx<Noticia> tx;

    public Noticias() {
        this.tx = new Tx();
    }

    @Override
    public List<Noticia> findAll() {
        Noticia u = new Noticia(null, null, null,null);
        ArrayList<Noticia> est = tx.Select(u);
        return est;
    }

    @Override
    public boolean insert(Noticia a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(Noticia a) {
        boolean r = false;
        Noticia u = new Noticia(a.getId(), null, null,null);
        r = tx.update(a, u);
        return r;
    }

    @Override
    public boolean delete(Noticia t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    

    
}
