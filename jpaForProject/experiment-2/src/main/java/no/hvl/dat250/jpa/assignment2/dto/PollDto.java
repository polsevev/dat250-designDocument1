package no.hvl.dat250.jpa.assignment2.dto;

import no.hvl.dat250.jpa.assignment2.Poll;

import java.util.List;
import java.util.stream.Collectors;

public class PollDto {
    private Long id;
    private String pollName;
    private List<QuestionDto> questions;

    public PollDto() {}
    public PollDto(Poll poll) {
        id = poll.getId();
        pollName = poll.getPollName();
        questions = poll.getQuestions().stream().map(QuestionDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
