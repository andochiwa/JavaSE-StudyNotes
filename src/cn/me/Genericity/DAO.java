package cn.me.Genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if(map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        // Collection<T> values = map.values();
        // return (List<T>) values;

        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        list.addAll(values);
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
