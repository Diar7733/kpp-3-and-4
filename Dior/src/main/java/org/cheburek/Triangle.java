package org.cheburek;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Triangle
{

    private static final Logger log = Logger.getLogger(Triangle.class);

    @Autowired
    private Cache cache;
    @Autowired
    private Counter counter;

    public double CalculateTriangle(int a, int b, int c)
            throws NotFoundException, ServerException
    {
        counter.increment();
        if (a <= 0 || b <= 0 || c <= 0) {
            log.error("a||b||c <= 0");
            throw new NotFoundException("Less than 1");
        }
        if (b>a || b>c ||a>c ) {
            log.error("Error!");
            throw new NotFoundException("Error!");
        }
        if (a > 1000 || b > 1000 || c > 1000) {
            log.error("a,b,c >1000");
            throw new ServerException("Num more then 1000");
        }
        if (a == 0 || b == 0 || c == 0) {
            return 0;
        }
        double t = 0;
        GetParam getParam=new GetParam(a,b,c);
        if(cache.getAnswer(getParam)!=null)
        {
            t=cache.getAnswer(getParam);
        }
        else
        {
            double p = ((a + b + c) / 2);
            t=Math.sqrt(p * (p - a) * (p - b) * (p - c));
            cache.putAnswer(getParam, t);
        }
        return t;
    }
    public Double CalculatePerimeter(int a, int b, int c)
    {
        Double p;
        GetParam getParam=new GetParam(a,b,c);
        if(cache.getAnswer(getParam)!= null)
        {
            p=cache.getAnswer(getParam);
        }
        else
        {
            p = Double.valueOf((a + b + c));
            cache.putAnswer(getParam, p);
        }
        return p;
    }
}


