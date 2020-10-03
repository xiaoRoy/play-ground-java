package com.learn.playground.dependencyinjection.dagger.again;

import com.learn.playground.dependencyinjection.dagger.again.dependency.DaggerStudentComponent;
import com.learn.playground.dependencyinjection.dagger.again.dependency.StudentComponent;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class StudentApp {

    @Inject
    @Nonnull
    StudentService studentService;

    @Nonnull
    private StudentComponent studentComponent;

    private StudentApp() {
        studentComponent = DaggerStudentComponent.builder().build();
        studentComponent.inject(this);
    }

    public void start() {
        studentService.callServer();
    }

    public static void main(String[] args) {
        StudentApp studentApp = new StudentApp();
        studentApp.start();
    }
}
