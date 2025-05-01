package com.poketeam.api.controller;

import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.model.ErrorResponse;
import com.poketeam.api.model.mapper.UsersMapper;
import com.poketeam.api.model.request.NewUserRORequest;
import com.poketeam.api.model.response.ApiResponseWrapper;
import com.poketeam.api.model.response.CreateUserResponse;
import com.poketeam.api.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersMapper usersMapper;
    private final UsersService usersService;

    @Operation(summary = "Create a new user", description = "Registers a user with all required details")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(schema = @Schema(implementation = CreateUserResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(schema = @Schema(implementation = ErrorResponse.class))), @ApiResponse(responseCode = "409", description = "User already exists", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    @PostMapping
    public Mono<ApiResponseWrapper<CreateUserResponse>> createUser(@Valid @RequestBody NewUserRORequest newUserRORequest) {
        return usersService.createUser(newUserRORequest);
    }

//    @PostMapping()
//    public Mono<UserRO> createUser(@RequestBody NewUserRO newUserRO) {
//        return usersService.createUser(usersMapper.mapToUser(newUserRO)).map(usersMapper::mapToUserRO);
//    }

    @GetMapping("/{id}")
    public Mono<UserRO> getUserById(@PathVariable("id") Long id) {
        return usersService.getUserById(id).map(usersMapper::mapToUserRO);
    }

    @GetMapping(params = "username")
    public Mono<UserRO> getUserByUsername(@RequestParam("username") String username) {
        return usersService.getUserByUsername(username).map(usersMapper::mapToUserRO);
    }

    @GetMapping()
    public Flux<UserRO> getAllUsers() {
        return usersService.getAllUsers().map(usersMapper::mapToUserRO);
    }
}
