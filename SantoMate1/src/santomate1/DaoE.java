package santomate1;

import java.util.List;

public interface DaoE<E> {

    public boolean adiciona(E m, int n);

    public List<E> PesquisaTodos();

}
