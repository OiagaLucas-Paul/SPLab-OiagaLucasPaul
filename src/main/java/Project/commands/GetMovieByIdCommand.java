package Project.commands;

import Project.model.Movie;
import Project.service.MoviesService;

public class GetMovieByIdCommand implements Command<Movie> {

    private final MoviesService moviesService;
    private final int id;

    public GetMovieByIdCommand(MoviesService moviesService, int id) {
        this.moviesService = moviesService;
        this.id = id;
    }

    @Override
    public Movie execute() {
        return moviesService.getById(id);
    }
}
