package DAO;

import java.util.ArrayList;

public abstract class DAOInterface<T> {
    public abstract int insert(T t);
    public abstract int update(T t);
    public abstract int delete(T t);
    public abstract ArrayList<T> selectAll();
    public abstract T selectByTenRieng(T t, String n);
    public abstract T selectByKhuVuc(T t, String n);
    public abstract T selectByThoiGian(T t, String n, String m);
    public abstract ArrayList<T> selectByCondition(String condition);

    public abstract T selectByKieuThienTai(T t, String j);
}
