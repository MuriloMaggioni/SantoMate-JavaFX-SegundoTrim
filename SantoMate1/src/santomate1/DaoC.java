/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santomate1;

import java.util.List;

/**
 *
 * @author Murilo
 */
public interface DaoC<E> {
    
    public boolean adiciona(E m);
    
    public List<E> pesquisaTodos();
}
