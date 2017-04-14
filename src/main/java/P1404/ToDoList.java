package P1404;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    int lengh = 0;

    ArrayList<Message> aList = new ArrayList<>();


    public  int add(String mes){
        int id = lengh++;
        aList.add(new Message(id, mes));
        return id;
    }
    public void delete(int id){
        for (Message message : aList) {
            if(message.id == id) {
                aList.remove(message);
                break;
            }
        }
    }

    public List<Message> view(){
        return aList;
    }
}
