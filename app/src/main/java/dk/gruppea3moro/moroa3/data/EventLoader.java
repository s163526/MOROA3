package dk.gruppea3moro.moroa3.data;

import java.util.ArrayList;

import dk.gruppea3moro.moroa3.model.EventDTO;
import dk.gruppea3moro.moroa3.model.SearchCriteria;

public interface EventLoader {

    ArrayList<EventDTO> searchEvent(SearchCriteria sc);
    ArrayList<EventDTO> getNextNEvents(int offset, int numberOfEvents, SearchCriteria sc);
    EventDTO getFeaturedEvent();
}
