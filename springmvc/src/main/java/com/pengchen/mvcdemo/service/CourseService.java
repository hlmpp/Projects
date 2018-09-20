package com.pengchen.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.pengchen.mvcdemo.model.Course;

@Service
public interface CourseService {

	Course getCoursebyId(Integer courseId);

}
