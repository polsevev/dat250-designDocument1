package no.hvl.dat250.jpa.assignment2;

import com.google.gson.Gson;
import no.hvl.dat250.jpa.assignment2.DAO.PollDAO;
import no.hvl.dat250.jpa.assignment2.DAO.QuestionDAO;
import no.hvl.dat250.jpa.assignment2.dto.PollDto;
import no.hvl.dat250.jpa.assignment2.dto.PutQuestionDto;
import no.hvl.dat250.jpa.assignment2.dto.QuestionDto;

import javax.persistence.EntityManager;
import static spark.Spark.*;

public class QuestionController {
    private static final Gson gson = new Gson();

    public static void registerRoutes(EntityManager em) {
        before("*/:id", (req, res) -> {
            try {
                Long.parseLong(req.params("id"));
            } catch (NumberFormatException e) {
                halt(400, "id wrong format");
            }
        });
        get("/question/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            Question question = new QuestionDAO(em).findOne(id);
            return gson.toJson(new QuestionDto(question));
        });
        post("/poll/:id/question", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            Poll poll = new PollDAO(em).findOne(id);
            QuestionDto dto = gson.fromJson(req.body(), QuestionDto.class);
            new QuestionDAO(em).create(new Question(dto, poll));
            new PollDAO(em).update(poll);
            return gson.toJson(new PollDto(poll));
        });
        put("/question/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            Question q = new QuestionDAO(em).findOne(id);
            PutQuestionDto dto = gson.fromJson(req.body(), PutQuestionDto.class);
            q.setQuestion(dto.getQuestion());
            new QuestionDAO(em).update(q);
            return "\uD83C\uDF1A";
        });
        delete("/question/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            new QuestionDAO(em).deleteById(id);
            return "\uD83D\uDE29";
        });

    }
}
