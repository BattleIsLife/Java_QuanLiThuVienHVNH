package controller;


import java.util.ArrayList;

public interface BaseController<T> {
    public int Them(T t);

    public int Sua(T t);

    public int Xoa(T t);

    public ArrayList<T> selectAll();

    public T selectById(String Id);

    public ArrayList<T> selectByCondition(String condition);
}
