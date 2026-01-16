package Project.commands;

import Project.dto.MovieUpdateRequest;
import Project.model.Movie;
import Project.service.MoviesService;

public class UpdateMovieCommand implements Command<Movie> {

    private final MoviesService moviesService;
    private final int id;
    private final MovieUpdateRequest request;

    public UpdateMovieCommand(MoviesService moviesService, int id, MovieUpdateRequest request) {
        this.moviesService = moviesService;
        this.id = id;
        this.request = request;
    }

    @Override
    public Movie execute() {
        return moviesService.update(id, request);
    }
}
