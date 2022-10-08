package no.hvl.dat250.jpa.assignment2.dto;

public class AnswerDto {

    private Long id;

    private boolean answer;


    public AnswerDto(Long id, boolean answer) {
        this.id = id;
        this.answer = answer;
    }


    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
