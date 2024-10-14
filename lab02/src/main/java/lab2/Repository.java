
package lab2;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T, K> {
    K add(T var1) throws SQLException;

    List<T> readAll();

    T read(K var1);

    boolean update(T var1);

    boolean delete(K var1);
}
