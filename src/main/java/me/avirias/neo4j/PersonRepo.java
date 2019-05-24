package me.avirias.neo4j;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface PersonRepo extends Neo4jRepository<Person,Long> {

    @Query("MATCH(p:Person) - [:ACTED_IN] -> (m:Movie) WHERE m.title = {movie} RETURN p")
    Collection<Person> getPersonByMovie(String movie);
}
