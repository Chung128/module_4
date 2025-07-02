package com.example.thuc_hanh_quan_li_dien_thoai.controller;


import com.example.thuc_hanh_quan_li_dien_thoai.model.SmartPhone;
import com.example.thuc_hanh_quan_li_dien_thoai.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/version1/smartphones")
public class SmartPhoneController {
    private ISmartPhoneService smartPhoneService;
    @Autowired
    public SmartPhoneController(ISmartPhoneService smartPhoneService) {
        this.smartPhoneService = smartPhoneService;
    }

    @GetMapping
    public ResponseEntity<List<SmartPhone>> findAll(){
        List<SmartPhone> smartPhoneList=smartPhoneService.findAll();
        if (smartPhoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhoneList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> addNew(@RequestBody SmartPhone smartPhone){
       smartPhoneService.save(smartPhone);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SmartPhone> update(@PathVariable Long id,@RequestBody SmartPhone smartPhone){
        Optional<SmartPhone> smartPhoneOptional=smartPhoneService.findById(id);
        if (smartPhoneOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> delete(@PathVariable long id){
        Optional<SmartPhone> smartPhoneOptional =smartPhoneService.findById(id);
        if (smartPhoneOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
