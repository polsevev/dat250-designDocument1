package no.hvl.dat250.jpa.assignment2;

import com.google.gson.Gson;
import no.hvl.dat250.jpa.assignment2.DAO.PollDAO;
import no.hvl.dat250.jpa.assignment2.dto.PollDto;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

import static spark.Spark.*;


public class PollController {
    private static final Gson gson = new Gson();
    public static void registerRoutes(EntityManager em) {
        port(8080);
        before("*/:id", (req, res) -> {
            try {
                Long.parseLong(req.params("id"));
            } catch (NumberFormatException e) {
                halt(400, "id wrong format");
            }
        });
        get("/polls", (req, res) -> {
            List<Poll> polls = new PollDAO(em).findAll();
            List<PollDto> pollDtos = polls.stream().map(PollDto::new).collect(Collectors.toList());
            return gson.toJson(pollDtos);
        });
        get("/poll/:id", (req, res) -> {
            Poll poll = new PollDAO(em).findOne(Long.parseLong(req.params("id")));
            if (poll == null) {
                res.status(404);
                return "not found";
            }
            return gson.toJson(new PollDto(poll));
        });
        post("/poll", (req, res) -> {
            PollDto pollDto = gson.fromJson(req.body(), PollDto.class);
            Poll poll = new Poll(pollDto);
            new PollDAO(em).create(poll);
            res.status(201);
            return gson.toJson(new PollDto(poll));
        });
        put("/poll/:id", (req, res) -> {
            Long id = Long.parseLong(req.params("id"));
            return "";
        });
        delete("/poll/:id", (req, res) -> {
            return "";
        });
        post("/question/:id/answer", (req, res) -> {
            return "";
        });

    }
}
