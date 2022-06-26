/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.testmarket.codegen.controllers;

import com.testmarket.codegen.model.Error;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-26T13:46:50.872481+04:00[Asia/Tbilisi]")
@Validated
@Tag(name = "delete", description = "the delete API")
public interface DeleteApi {

    /**
     * DELETE /delete/{id}
     * Удалить элемент по идентификатору. При удалении категории удаляются все дочерние элементы. Доступ к статистике (истории обновлений) удаленного элемента невозможен.  Так как время удаления не передается, при удалении элемента время обновления родителя изменять не нужно.  **Обратите, пожалуйста, внимание на этот обработчик. При его некорректной работе тестирование может быть невозможно.** 
     *
     * @param id Идентификатор (required)
     * @return Удаление прошло успешно. (status code 200)
     *         or Невалидная схема документа или входные данные не верны. (status code 400)
     *         or Категория/товар не найден. (status code 404)
     */
    @Operation(
        operationId = "deleteIdDelete",
        tags = { "Базовые задачи" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Удаление прошло успешно."),
            @ApiResponse(responseCode = "400", description = "Невалидная схема документа или входные данные не верны.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "Категория/товар не найден.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/delete/{id}",
        produces = { "application/json" }
    )
    ResponseEntity<Object> deleteIdDelete(
        @Parameter(name = "id", description = "Идентификатор", required = true) @PathVariable("id") UUID id
    );

}
