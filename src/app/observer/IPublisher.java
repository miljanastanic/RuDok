package app.observer;

public interface IPublisher {

    void addSubscriber(ISubscriber subscriber);
    void removeSubscriber(ISubscriber subscriber);
    void notifySubscriber(Object notification);

}
