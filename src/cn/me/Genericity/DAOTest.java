package cn.me.Genericity;

import java.util.List;

public class DAOTest {

    public static void main(String[] args){
        DAO<User> dao = new DAO<>();

        dao.save("1001", new User(1001, 34, "Tom"));
        dao.save("1002", new User(1002, 35, "Ton"));
        dao.save("1003", new User(1003, 32, "Tob"));
        dao.save("1004", new User(1004, 37, "Tov"));

        List<User> list = dao.list();
        for(var it = list.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        System.out.println();

        User user = dao.get("1001");
        System.out.println(user);
        System.out.println();

        dao.update("1001", new User(1005, 37, "TOC"));
        list = dao.list();
        for(var it = list.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        System.out.println();
        
        dao.delete("1003");
        list = dao.list();
        for(var it = list.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }



    }
}
