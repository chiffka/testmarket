package com.testmarket.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.testmarket.codegen.model.ShopUnitType;
import lombok.*;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class ShopUnitEntity {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Id @GeneratedValue private UUID id;

    @ToString.Include
    private String name;
    private UUID parentId;

    private ShopUnitType type;
    private Long price;
    @Index
    @Version
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime date;
    @JsonIgnore
    private ZonedDateTime createdAt;
    @JsonIgnore
    private ZonedDateTime updatedAt;

    @JsonIgnore
    @Relationship(type = "PARENT", direction = Relationship.Direction.OUTGOING)
    public ShopUnitEntity parent;

    @Relationship(type = "CHILDREN", direction = Relationship.Direction.OUTGOING)
    public Set<ShopUnitEntity> children;

    public void addChildren(ShopUnitEntity person) {
        if (children == null) {
            children = new HashSet<>();
        }
        children.add(person);
    }

    public void removeChildren(ShopUnitEntity person) {
        if (children == null) {
            children = new HashSet<>();
        }
        children.remove(person);
    }

}