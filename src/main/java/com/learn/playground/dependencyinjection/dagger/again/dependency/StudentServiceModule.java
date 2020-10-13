package com.learn.playground.dependencyinjection.dagger.again.dependency;

import com.learn.playground.dependencyinjection.dagger.again.StudentService;
import dagger.Module;
import dagger.Provides;

@Module
public class StudentServiceModule {

    @Provides
    StudentService provideStudentService() {
        return new StudentService();
    }

}
