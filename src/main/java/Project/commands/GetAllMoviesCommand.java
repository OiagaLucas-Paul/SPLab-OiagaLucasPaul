package Project.commands;

import Project.model.Movie;
import Project.service.MoviesService;

import java.util.List;

public class GetAllMoviesCommand implements Command<List<Movie>> {

    private final MoviesService moviesService;

    public GetAllMoviesCommand(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public List<Movie> execute() {
        return moviesService.getAll();
    }
}
