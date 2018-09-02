package com.learn.training.template;


public abstract class InterviewProcess {

    public void doInterview(){
        if (phoneInterview()) {
            fillIndividualInfoForm();
            int techPoint = doWrittenExamination() + firstTechInterview()
                    + secondTechInterview();

            if (techPoint > getPassPoint() && directorInterview() && hrInterview() && provideOffer()) {
                onBoard();
            }
        }
    }

    /*private List<Resume> pickResumes(){
        return new ArrayList<>();
    }*/

    abstract boolean phoneInterview();

    private void fillIndividualInfoForm(){

    }

    abstract int doWrittenExamination();

    abstract int firstTechInterview();

    abstract int secondTechInterview();

    abstract int getPassPoint();

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
