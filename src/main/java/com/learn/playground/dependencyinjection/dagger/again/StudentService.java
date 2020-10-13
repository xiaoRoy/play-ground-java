package com.learn.playground.dependencyinjection.dagger.again;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class StudentService {

    @Inject
    @Nullable
    public Student student;


//    @Inject
    public StudentService() {
    }

    public void callServer() {
        if(student == null) {
            throw new IllegalArgumentException("Student should not be null!");
        }
        System.out.println(student);
        System.out.println("Server started successfully!");
    }
}
