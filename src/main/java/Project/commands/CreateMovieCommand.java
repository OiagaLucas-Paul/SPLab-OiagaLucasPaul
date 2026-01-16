package Project.commands;

import Project.dto.MovieCreateRequest;
import Project.model.Movie;
import Project.service.MoviesService;

public class CreateMovieCommand implements Command<Movie> {

    private final MoviesService moviesService;
    private final MovieCreateRequest request;

    public CreateMovieCommand(MoviesService moviesService, MovieCreateRequest request) {
        this.moviesService = moviesService;
        this.request = request;
    }

    @Override
    public Movie execute() {
        return moviesService.create(request);
    }
}
