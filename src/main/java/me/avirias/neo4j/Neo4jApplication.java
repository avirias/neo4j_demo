package me.avirias.neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Collection;

@SpringBootApplication
@EnableNeo4jRepositories("me.avirias.neo4j")
public class Neo4jApplication implements CommandLineRunner {


    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private PersonRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Collection<Movie> movieList = movieRepo.getMovie("Tom Cruise");
        movieList.forEach(movie -> System.out.println(movie.getTitle()+" "+movie.getReleased()));
        movieRepo.getRecommend("Keanu Reeves").forEach(person -> System.out.println(person.getTitle()));
        repo.getPersonByMovie("Top Gun").forEach(person -> System.out.println(person.getName()));

    }
}
