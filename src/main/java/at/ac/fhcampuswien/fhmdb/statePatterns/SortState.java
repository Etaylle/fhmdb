package at.ac.fhcampuswien.fhmdb.statePatterns;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

public interface SortState {
    void sortMovies(MovieListController controller);
    void nextSortState(MovieListController controller);
}
