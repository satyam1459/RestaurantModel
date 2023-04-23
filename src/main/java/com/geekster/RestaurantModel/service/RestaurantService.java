package com.geekster.RestaurantModel.service;

import com.geekster.RestaurantModel.model.Restaurant;
import com.geekster.RestaurantModel.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantService {

  @Autowired
  private RestaurantDao restaurantDao;

    public List<Restaurant> getAllList() {
        return restaurantDao.getList();
    }

    public Restaurant getRestaurantById(int id) {
      Restaurant restaurant = null;
      boolean found = this.getAllList().stream().anyMatch(e->e.getId() == id);
      if(found) restaurant = this.getAllList().stream().filter(e->e.getId() == id).findFirst().get();
      else{
        System.out.println("No resturant with such id..!");
        return null;}
      return restaurant;
    }

  public String addRestaurant(Restaurant restaurant) {
        return restaurantDao.add(restaurant) ? "Restaurant added successfully" : "Error in adding";
    }

  public String updateSpecialityById(int id, String speciality) {
      List<Restaurant> currList = this.getAllList();
      for(Restaurant rest : currList){
        if(rest.getId()== id){
          restaurantDao.remove(rest);
          rest.setSpeciality(speciality);
          restaurantDao.add(rest);
          return "Updated successfully";
        }
      }
      return "No restaurant with this id found";
  }

    public String deleteRestaurantById(int id) {
      Restaurant restaurant = null;
      boolean found = this.getAllList().stream().anyMatch(e->e.getId() == id);
      if(found){
        restaurant = this.getAllList().stream().filter(e->e.getId() == id).findFirst().get();
        restaurantDao.remove(restaurant);
        return "Deleted successfully";
      }
      return "No such restaurant found to delete";
    }
}
