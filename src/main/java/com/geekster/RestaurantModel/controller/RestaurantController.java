package com.geekster.RestaurantModel.controller;

import com.geekster.RestaurantModel.model.Restaurant;
import com.geekster.RestaurantModel.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private
    RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllList();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id){
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return restaurant;
    }

    @PostMapping
    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);

    }

    @PutMapping("/{id}/{speciality}")
    public String updateSpeciality(@PathVariable int id ,@PathVariable String speciality){
        return restaurantService.updateSpecialityById(id,speciality);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurantById(@PathVariable int id){
       return restaurantService.deleteRestaurantById(id);
    }

}
