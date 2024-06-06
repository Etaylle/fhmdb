package at.ac.fhcampuswien.fhmdb.statePatterns;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Comparator;

public class DescendingState implements SortState {
    @Override
    public void sortMovies(MovieListController controller) {
        controller.getObservableMovies().sort(Comparator.comparing(Movie::getTitle).reversed());
    }

    @Override
    public void nextSortState(MovieListController controller) {
        controller.setSortState(new AscendingState());
    }
}
