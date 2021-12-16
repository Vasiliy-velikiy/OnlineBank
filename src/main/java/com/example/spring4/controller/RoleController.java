package com.example.spring4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkotov
 * @since 16.12.2021
 */
//path = http://localhost:8080/api/v1.0/users/{userId}/roles
@RestController
@RequestMapping(path = "users/{userId}/roles")
public class RoleController {
}
