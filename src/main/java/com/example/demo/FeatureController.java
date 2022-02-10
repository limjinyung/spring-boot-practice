package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FeatureController {

    @Autowired
    FeatureRepository featureRepository;

    @RequestMapping(
            value = "/feature",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public ResponseEntity<String> postFeature(@RequestBody Feature feature) throws Exception {

        try{
            // using CrudRepository to save/update the data
            // the data won't persist upon restart since it's using spring CRUD
            featureRepository.save(new Feature(feature.getFeatureName(), feature.getEmail(), feature.getEnable()));
            return ResponseEntity.status(HttpStatus.OK).body("Feature Saved\n");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }

    }

    @RequestMapping(
            value = "/feature",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<Object> getFeature(@RequestParam String email, String featureName) throws Exception {

        // using CrudRepository to filter the data
        Feature findFeature = featureRepository.findByEmailAndFeatureName(email, featureName);

        // if null, return status not found
        if (findFeature == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }

        // map object to json and return
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("canAccess", findFeature.getEnable());
        return new ResponseEntity<Object>(map,HttpStatus.OK);

    }

}