package com.testmarket.codegen.controllers;

import com.testmarket.codegen.model.Error;
import com.testmarket.codegen.model.ShopUnit;

import java.util.*;


import com.testmarket.codegen.model.ShopUnitType;
import com.testmarket.entities.ShopUnitEntity;
import com.testmarket.repositories.ShopUnitRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-26T13:46:50.872481+04:00[Asia/Tbilisi]")
@Controller
@RequestMapping("${openapi.megaMarketOpen.base-path:}")
@RequiredArgsConstructor
public class NodesApiController implements NodesApi {

    private final ShopUnitRepository repository;

    @Override
    public ResponseEntity<Object> nodesIdGet(UUID id) {
        var result = repository.findById(id);
        if (result.isPresent()) {
            calcPrice(result.get());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Error(404, "Item not found"), HttpStatus.NOT_FOUND);
    }


    private Pair<Integer, Long> calcPrice(ShopUnitEntity entity) {
        if (entity.getType() == ShopUnitType.CATEGORY) {

            int count = 0;
            long sum = 0;

            for (var c : entity.getChildren()) {
                var value = calcPrice(c);
                sum += value.getRight();
                count += value.getLeft();
            }

            if (count == 0) {
                entity.setPrice(null);
            } else {
                entity.setPrice(sum / count);
            }

            if (entity.getChildren().isEmpty()) {
                entity.setChildren(null);
            }

            return Pair.of(count, sum);
        }
        entity.setChildren(null);
        return Pair.of(1, entity.getPrice());

    }

}
