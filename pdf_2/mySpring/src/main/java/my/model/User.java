package my.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vika on 20.01.17.
 */
public class User {
    private Map<String,String> myList;



    public User() {
        myList = new HashMap<String, String>();
        myList.put("Vika","Ibraimova");
        myList.put("Kot","Smirnov");
        this.myList = myList;
    }

    public Map<String, String> getMyList() {
        return myList;
    }
}
