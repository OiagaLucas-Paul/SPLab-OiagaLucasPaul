package Project.service;

import Project.dto.MovieCreateRequest;
import Project.dto.MovieUpdateRequest;
import Project.model.Movie;
import Project.observer.AllMoviesSubject;
import Project.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final MovieRepository movieRepository;
    private final AllMoviesSubject allMoviesSubject;

    public MoviesService(MovieRepository movieRepository, AllMoviesSubject allMoviesSubject) {
        this.movieRepository = movieRepository;
        this.allMoviesSubject = allMoviesSubject;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie create(MovieCreateRequest req) {
        Movie movie = new Movie(req.getTitle(), req.getYear());
        Movie saved = movieRepository.save(movie);

        // SSE notify
        allMoviesSubject.notifyObservers(saved);
        return saved;
    }

    public Movie update(int id, MovieUpdateRequest req) {
        Movie existing = movieRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(req.getTitle());
        existing.setReleaseYear(req.getYear());
        return movieRepository.save(existing);
    }

    public boolean delete(int id) {
        if (!movieRepository.existsById(id)) return false;
        movieRepository.deleteById(id);
        return true;
    }
}
