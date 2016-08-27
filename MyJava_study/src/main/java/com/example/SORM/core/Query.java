package com.example.SORM.core;

import java.util.List;

/**
 * 增删查改 的接口
 * Created by Administrator on 2016/8/24.
 */
public interface Query {

    public int executeDML(String SQL, Object[] parma);

    public void insert(Object o);

    public void delete(Class aClass, Object id);

    public void delete(Object o);

    public int update(Object o, String[] param);

    public List queryRows(String sql, Class aClass, Object[] param);

    public Object queryUniqueRows(String sql, Class aClass, Object[] param);

    public Object queryvalue(String sql, Object[] param);

    public Number queryNumber(String sql, Object[] param);


}
