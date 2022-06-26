package com.testmarket.codegen.controllers;

import com.testmarket.repositories.ShopUnitRepository;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.springframework.format.annotation.DateTimeFormat;
import com.testmarket.codegen.model.Error;
import java.time.OffsetDateTime;
import com.testmarket.codegen.model.ShopUnitStatisticResponse;


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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-26T13:46:50.872481+04:00[Asia/Tbilisi]")
@Controller
@RequestMapping("${openapi.megaMarketOpen.base-path:}")
@RequiredArgsConstructor
public class SalesApiController implements SalesApi {
    private final ShopUnitRepository repository;


    @Override
    public ResponseEntity<ShopUnitStatisticResponse> salesGet(OffsetDateTime date) {
        return null;
    }
}
