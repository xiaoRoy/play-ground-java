package com.learn.training.template;

import java.util.ArrayList;
import java.util.List;

public abstract class InterviewProcess {

    public void doInterview(){
        for(Resume resume : pickResumes()){
            if(phoneInterview()){
                fillIndividualInfoForm();
                int techPoint = doWrittenExamination() + firstTechInterview()
                          +secondTechInterview();

                if (techPoint > 80 && directorInterview() && hrInterview() && provideOffer()) {
                    onBoard();
                }
            }
        }
    }

    private List<Resume> pickResumes(){
        return new ArrayList<>();
    }

    abstract boolean phoneInterview();

    private void fillIndividualInfoForm(){

    }

    abstract int doWrittenExamination();

    abstract int firstTechInterview();

    abstract int secondTechInterview();

    abstract boolean directorInterview();

    private boolean hrInterview(){
        return true;
    }

    private boolean provideOffer(){
        return true;
    }

    private void onBoard(){

    }

    static class Resume{

    }
}
