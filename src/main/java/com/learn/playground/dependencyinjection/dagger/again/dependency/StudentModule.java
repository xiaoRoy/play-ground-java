package com.learn.playground.dependencyinjection.dagger.again.dependency;

import com.learn.playground.dependencyinjection.dagger.again.Student;
import dagger.Module;
import dagger.Provides;

import javax.annotation.Nonnull;

@Module
public class StudentModule {

    @Provides
    @Nonnull
    Student provideStudent() {
        return new Student("Smith", "Silver");
    }
}
