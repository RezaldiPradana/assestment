package com.assestment.fruit.controller;

import com.assestment.fruit.model.Fruit;
import com.assestment.fruit.repository.FruitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CrudController {

    private final FruitRepository fruitRepository;

    @Autowired
    public CrudController(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @PostMapping("/insert-fruit")
    public String addFruit(@ModelAttribute Fruit fruit) {
        fruitRepository.insertFruit(fruit);
        return "insertData";
    }

    @PostMapping("/edit-fruit/{id}")
    public String editFruit(@PathVariable String id,@ModelAttribute Fruit fruit){
        Fruit fruitBySeqId = fruitRepository.findFruitBySeqId(id);
        fruitRepository.updateFruit(fruit);
        return "editData";
    }

    @PostMapping("/delete-fruit/{id}")
    public String deleteFruit(@PathVariable String id){
        fruitRepository.deleteFruit(id);
        return "deleteData";
    }
}
