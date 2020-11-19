package dk.gruppea3moro.moroa3.data;

import java.io.IOException;
import java.util.ArrayList;

import dk.gruppea3moro.moroa3.model.EventDTO;
import dk.gruppea3moro.moroa3.model.SearchCriteria;

public interface EventLoader {


    ArrayList<EventDTO> getAllEvents() throws IOException;
    ArrayList<EventDTO> searchEvent(SearchCriteria sc) throws IOException;
    ArrayList<EventDTO> getNextNEvents(int offset, int numberOfEvents, SearchCriteria sc) throws IOException;
    EventDTO getFeaturedEvent() throws IOException;
}
