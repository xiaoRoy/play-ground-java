package com.learn.playground.dependencyinjection.dagger.again.dependency;

import com.learn.playground.dependencyinjection.dagger.again.Student;
import com.learn.playground.dependencyinjection.dagger.again.StudentApp;
import com.learn.playground.dependencyinjection.dagger.again.StudentService;
import dagger.Component;

import javax.annotation.Nonnull;

@Component(modules = {StudentModule.class, StudentServiceModule.class})
public interface StudentComponent {



    StudentService provideStudentService();

    Student provideStudent();

    /*
     *If you want to use filed injection you have to define
     * a method in your Component interface which takes the instance
     * into which you want to inject as parameter.
     * */
    void inject(@Nonnull StudentApp app);
}
