package Project.commands;

import Project.service.MoviesService;

public class DeleteMovieCommand implements Command<Boolean> {

    private final MoviesService moviesService;
    private final int id;

    public DeleteMovieCommand(MoviesService moviesService, int id) {
        this.moviesService = moviesService;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return moviesService.delete(id);
    }
}
