package eryi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/21 19:18
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Mono<String> hello(){
        return Mono.just("Welcome to reactive world ~");
    }
}
