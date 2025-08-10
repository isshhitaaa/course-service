package org.example.service;

import org.example.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
  private final List<Course> courses = new ArrayList<>();

  public void addCourse(Course x){
      courses.add(x);
  }

  public List<Course> getAllCourses(){
      return courses;
  }

  public Optional<Course> getCourseById(int id){
     return courses.stream().filter(x-> x.getId()==id).findFirst();
  }

  public boolean updateCourse(int id, Course c) {
    return   getCourseById(id).map(x ->
      {
          courses.remove(x);
          courses.add(c);
          return true;
      }).orElse( false);

  }
public boolean deleteCourse(int id){
     return getCourseById(id).map(x-> {
         courses.remove(x);
         return true;
     }  ).orElse(false);
}


}
