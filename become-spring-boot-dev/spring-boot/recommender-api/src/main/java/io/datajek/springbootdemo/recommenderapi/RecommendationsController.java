package io.datajek.springbootdemo.recommenderapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationsController {

    // @RequestMapping(method = RequestMethod.GET, value = "/movies")
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return Arrays.asList(new Movie(1, "Ice Age", 7.5),
                new Movie(2, "Shark", 8.9),
                new Movie(3, "Ashes", 10.0));
    }
}
