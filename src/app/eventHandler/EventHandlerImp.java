package app.eventHandler;

import app.core.EventHandler;
import app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class EventHandlerImp implements EventHandler {

    private List<ISubscriber> subscribers;

    @Override
    public void generateError(Type errorType) {

        if(errorType == errorType.NE_MOZE_SE_OBRISATI){
            notifySubscriber(new Error(1, "Ne mozete obrisati Workspace",
                    "Greska prilikom brisanja"));
        }
        if(errorType == errorType.NIJE_NISTA_SELEKTOVANO){
            notifySubscriber(new Error(2, "Selektujte cvor",
                    "Nista nije selektovano"));
        }
        if(errorType == errorType.NEW_TAB_NIJE_DOKUMENT){
            notifySubscriber(new Error(3, "Pogresno ste selektovali cvor. " +
                    "Selektujte dokument.",
                    "New tab warning"));
        }
        if(errorType == errorType.NIJE_PROJEKAT){
            notifySubscriber(new Error(4,"Selektujte projekat koji zelite da sacuvate.","Warning"));
        }

        if(errorType == errorType.NIJE_SELEKTOVAN_SLOT){
            notifySubscriber(new Error(4,"Selektujte neki slot.","Warning"));
        }
        if(errorType == errorType.SACUVAJ_PROJEKAT){
            notifySubscriber(new Error(4,"Cuvanje workspace-a nije usepsno zato sto prethodno niste sacuvali projekte.","Warning"));
        }

    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(subscriber == null){
            return;
        }
        if(subscribers==null){
            subscribers = new ArrayList<ISubscriber>();
        }
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(subscriber!=null){
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscriber(Object notification) {
        if(subscribers == null || subscribers.isEmpty() || notification == null){
            return;
        }

        for (ISubscriber subscriber: subscribers) {
            subscriber.update(notification);
        }
    }
}
