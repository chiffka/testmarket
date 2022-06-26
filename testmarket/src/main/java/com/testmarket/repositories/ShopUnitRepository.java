package com.testmarket.repositories;

import java.util.List;
import java.util.UUID;

import com.testmarket.entities.ShopUnitEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ShopUnitRepository extends Neo4jRepository<ShopUnitEntity, UUID> {

    ShopUnitEntity findByName(String name);
}