package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Component
@Service
@Configurable
public interface FeatureRepository extends CrudRepository<Feature, Long> {
    Feature findByEmailAndFeatureName(String email, String feature);
}
