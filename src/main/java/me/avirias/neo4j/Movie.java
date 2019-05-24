package me.avirias.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Movie {
    @Id
    @GeneratedValue
    private long ID;
    private String title;
    private int released;
    private String tagLine;

    @Relationship(type = "ACTED_IN",direction = Relationship.INCOMING)
    private List<Role> roles;

}
