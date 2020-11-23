package dk.gruppea3moro.moroa3.data;

import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import dk.gruppea3moro.moroa3.model.EventDTO;
import dk.gruppea3moro.moroa3.model.SearchCriteria;

public class DataController {


    private static DataController instance;
    private EventLoader eventLoader;


    public DataController(){
        eventLoader = new SheetReader();
    }

    public static DataController get(){
        if (instance==null){
            instance = new DataController();
        }
        return instance;
    }

    private EventLoader getEventLoader() {
        return eventLoader;
    }

    public ArrayList<EventDTO> getAllEvents()  {
        try {
            return getEventLoader().getAllEvents();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<EventDTO> searchEvents(SearchCriteria searchCriteria)  {
        try {
            return getEventLoader().searchEvents(searchCriteria);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<EventDTO> getNextNEvents(int offset, int numberOfEvents, SearchCriteria sc)  {
        try {
            return getEventLoader().getNextNEvents(offset,numberOfEvents,sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Drawable loadImageFromURL(EventDTO eventDTO) {
        try {
            InputStream is = (InputStream) new URL(eventDTO.getImageLink()).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

}
