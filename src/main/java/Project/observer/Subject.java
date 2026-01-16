package Project.observer;

import Project.model.Movie;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Movie movie);
}
