package no.hvl.dat250.jpa.assignment2;

import com.google.gson.Gson;
import no.hvl.dat250.jpa.assignment2.DAO.PollDAO;

import javax.persistence.EntityManager;

import java.util.List;

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
            return gson.toJson(polls);
        });
        get("/poll/:id", (req, res) -> {
            Poll poll = em.find(Poll.class, Long.parseLong(req.params("id")));
            if (poll == null) {
                res.status(404);
                return "not found";
            }
            return gson.toJson(poll);
        });
        post("/poll", (req, res) -> {
            Poll poll = gson.fromJson(req.body(), Poll.class);
            System.out.println(poll);
            return gson.toJson(poll);
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
