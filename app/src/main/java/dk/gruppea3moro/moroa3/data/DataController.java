package dk.gruppea3moro.moroa3.data;

public class DataController {


    private static DataController instance;
    private EventLoader eventLoader;


    public DataController(){
        eventLoader = new SheetReader();
    }

    public DataController get(){
        if (instance==null){
            instance = new DataController();
        }
        return instance;
    }

    public EventLoader getEventLoader() {
        return eventLoader;
    }
}
