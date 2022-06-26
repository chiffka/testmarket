package com.testmarket.codegen.controllers;

import com.testmarket.codegen.model.ShopUnitImportRequest;


import com.testmarket.entities.ShopUnitEntity;
import com.testmarket.repositories.ShopUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-26T13:46:50.872481+04:00[Asia/Tbilisi]")
@Controller
@RequestMapping("${openapi.megaMarketOpen.base-path:}")
@RequiredArgsConstructor
public class ImportsApiController implements ImportsApi {

    private final ShopUnitRepository repository;

    @Override
    public ResponseEntity<Void> importsPost(ShopUnitImportRequest shopUnitImportRequest) {

        Map<UUID, ShopUnitEntity> entites = new HashMap<UUID, ShopUnitEntity>();
        for (var item : shopUnitImportRequest.getItems()) {

            ShopUnitEntity entity = getOrCreateEntity(entites, item.getId(), shopUnitImportRequest.getUpdateDate());

            entity.setName(item.getName());
            entity.setDate(shopUnitImportRequest.getUpdateDate());
            entity.setType(item.getType());
            entity.setPrice(item.getPrice() != null && item.getPrice().isPresent() ? item.getPrice().get() : null);

            if (item.getParentId() != null && item.getParentId().get() != null) {
                entity.setParentId(item.getParentId().get());
                ShopUnitEntity parent = getOrCreateEntity(entites, item.getParentId().get(), shopUnitImportRequest.getUpdateDate());
                parent.addChildren(entity);
                parent.setDate(shopUnitImportRequest.getUpdateDate());
                var p = parent.getParent();
                while( p != null) {
                    p.setDate(shopUnitImportRequest.getUpdateDate());
                    p = p.getParent();
                }
                entity.setParent(parent);
            } else {
                entity.setParentId(null);

                var parent = entity.getParent();
                if (parent != null){
                    parent.setDate(shopUnitImportRequest.getUpdateDate());
                    var p = parent.getParent();
                    while( p != null) {
                        p.setDate(shopUnitImportRequest.getUpdateDate());
                        p = p.getParent();
                    }

                    parent.removeChildren(entity);
                    entity.setParent(null);
                }
            }

        }
        repository.saveAll(entites.values());
        return null;
    }

    private ShopUnitEntity getOrCreateEntity(Map<UUID, ShopUnitEntity> entites, @NotNull @Valid UUID id, @Valid ZonedDateTime createAt) {
        ShopUnitEntity entity = entites.get(id);

        if (entity == null) {
            var result = repository.findById(id);
            if (result.isPresent()) {
                entity = result.get();
                entites.put(id, entity);
            }
        }
        if (entity == null) {
            entity = new ShopUnitEntity();
            entity.setId(id);
            entity.setCreatedAt(createAt);
            entites.put(id, entity);
        }
        return entity;
    }
}
