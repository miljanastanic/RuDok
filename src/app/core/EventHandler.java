package app.core;


import app.eventHandler.Type;
import app.observer.IPublisher;

public interface EventHandler extends IPublisher {
    void generateError(Type errorType);
}

