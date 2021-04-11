package org.cheburek;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("diar")
public class DiarzRestController {

    @Autowired
    Counter counter;
    @Autowired
    Triangle triangle;

    private final Logger log = Logger.getLogger(Triangle.class);

    @GetMapping
    public Interpritation Calculating(@RequestParam(value="a") int a,@RequestParam(value="b") int b,@RequestParam(value="c") int c)
            throws NotFoundException, ServerException
    {
        log.info("Get Request param from URL");
        double result=triangle.CalculateTriangle(a,b,c);
        Double perimeter=triangle.CalculatePerimeter(a, b, c);
        Interpritation obj = new Interpritation(perimeter,result,counter.getCounter());
        log.info("Return task answer");
        return obj;
    }
}