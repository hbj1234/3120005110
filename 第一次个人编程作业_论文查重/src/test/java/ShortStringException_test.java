import org.junit.Test;

public class ShortStringException_test {

    @Test
    public void shortStringExceptionTest(){
        //测试str.length()<200的情况
        System.out.println(SimHash.getSimHash("一位月入百万的小说作家"));
    }

}
