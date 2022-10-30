package app.observer;

import java.util.ArrayList;
import java.util.List;

public class IPublisherImp implements IPublisher{

    private List<ISubscriber> subscribers;

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
