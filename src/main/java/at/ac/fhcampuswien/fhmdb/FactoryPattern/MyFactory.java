package at.ac.fhcampuswien.fhmdb.FactoryPattern;

import at.ac.fhcampuswien.fhmdb.controllers.MainController;
import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.controllers.WatchlistController;
import javafx.util.Callback;

public class MyFactory implements Callback<Class<?>, Object> {
    private MainController mainControllerInstance;
    private MovieListController movieListControllerInstance;
    private WatchlistController watchlistControllerInstance;

    @Override
    public Object call(Class<?> type) {
        if (type == MainController.class) {
            if (mainControllerInstance == null) {
                mainControllerInstance = MainController.getInstance();
            }
            return mainControllerInstance;
        } else if (type == MovieListController.class) {
            if (movieListControllerInstance == null) {
                movieListControllerInstance = MovieListController.getInstance();
            }
            return movieListControllerInstance;
        } else if (type == WatchlistController.class) {
            if (watchlistControllerInstance == null) {
                watchlistControllerInstance = WatchlistController.getInstance();
            }
            return watchlistControllerInstance;
        }
        throw new IllegalArgumentException("Unknown controller type: " + type);
    }
}
