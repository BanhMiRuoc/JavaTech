package org.example.DAO;

import java.util.List;

public interface Repository<P> {
    boolean add(P p);
    P get(int id);
    List<P> getAll();
    boolean remove(int id);
    boolean remove(P p);
    boolean update(P p);
}
