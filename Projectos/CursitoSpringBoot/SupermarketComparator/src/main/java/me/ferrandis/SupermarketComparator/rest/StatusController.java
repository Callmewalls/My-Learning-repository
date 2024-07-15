package me.ferrandis.SupermarketComparator.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(value = "/status/info")
    @Operation(summary = "Obtiene el estado del servidor.")
    @ApiResponse(responseCode = "200" , description = "Estado del servidor obtenido")
    public boolean status() {
        return true;
    }
}
