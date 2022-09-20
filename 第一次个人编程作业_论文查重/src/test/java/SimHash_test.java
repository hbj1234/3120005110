import org.junit.Test;

public class SimHash_test {


    @Test
    public void getHashTest(){
        String[] strings = {"黄柏钧", "会", "成为", "一个", "爆火的", "轻小说作家"};
        for (String string : strings) {
            String stringHash = SimHash.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
        }
    }

    @Test
    public void getSimHashTest(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_add.txt");
        System.out.println(SimHash.getSimHash(str0));
        System.out.println(SimHash.getSimHash(str1));
    }

}
