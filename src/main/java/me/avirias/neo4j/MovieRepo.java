package me.avirias.neo4j;


import org.neo4j.driver.v1.StatementResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public interface MovieRepo extends Neo4jRepository<Movie, Long> {

    @Query("MATCH(a:Person) - [:ACTED_IN] -> (b:Movie) WHERE a.name = {name} RETURN b")
    Collection<Movie> getMovie(String name);

    @Query("MATCH (tom:Person {name:{name}})-[:ACTED_IN]->(m)<-[:ACTED_IN]-(coActors)," +
            "      (coActors)-[:ACTED_IN]->(m2)<-[:ACTED_IN]-(cocoActors)"+
            "WHERE NOT (tom)-[:ACTED_IN]->()<-[:ACTED_IN]-(cocoActors) AND tom <> cocoActors\n" +
            "RETURN m2")
    Collection<Movie> getRecommend(String name);
}
