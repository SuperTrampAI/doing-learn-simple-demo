package com.supertrampai.springbootsimplemongodb.action;

import com.supertrampai.springbootsimplemongodb.domain.User;
import com.supertrampai.springbootsimplemongodb.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/24 15:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllPets() {
        return userRepository.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getPetById(@PathVariable("id") ObjectId id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid
    @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createPet(@Valid @RequestBody User user) {
        user.setId(ObjectId.get());
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        userRepository.delete(userRepository.findById(id));
    }



}
