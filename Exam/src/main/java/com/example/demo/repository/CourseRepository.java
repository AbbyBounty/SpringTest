package com.example.demo.repository;

import com.example.demo.model.Course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	


	@Query(value="select * from  course where name=:name",nativeQuery=true)
	Optional<Course> findByName(@Param("name")String name);

}
