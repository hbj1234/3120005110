import org.junit.Test;

public class A_main_test
{
    @Test
    public void origAndAllTest(){
        String[] str = new String[6];
        str[0] = TXT_IO.readTxt("D:/test/orig.txt");
        str[1] = TXT_IO.readTxt("D:/test/orig_0.8_add.txt");
        str[2] = TXT_IO.readTxt("D:/test/orig_0.8_del.txt");
        str[3] = TXT_IO.readTxt("D:/test/orig_0.8_dis_1.txt");
        str[4] = TXT_IO.readTxt("D:/test/orig_0.8_dis_10.txt");
        str[5] = TXT_IO.readTxt("D:/test/orig_0.8_dis_15.txt");
        String ansFileName = "D:/test/ansAll.txt";
        for(int i = 0; i <= 5; i++){
            double ans = Hamming.getSimilarity(SimHash.getSimHash(str[0]), SimHash.getSimHash(str[i]));
            System.out.println("该文章与原文相似度为："+ans*100+"%");
            TXT_IO.writeTxt(ans, ansFileName);
        }
    }

    @Test
    public void origAndOrigTest(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig.txt");
        String ansFileName = "D:/test/ansOrigAndOrigTest.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("该文章与原文相似度为："+ans*100+"%");
        TXT_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origAndAddTest(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_add.txt");
        String ansFileName = "D:/test/ansOrigAndAddTest.txt";
        double ans =Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("该文章与原文相似度为："+ans*100+"%");
        TXT_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origAndDelTest(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_del.txt");
        String ansFileName = "D:/test/ansOrigAndDelTest.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("该文章与原文相似度为："+ans*100+"%");
        TXT_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origAndDis1Test(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_dis_1.txt");
        String ansFileName = "D:/test/ansOrigAndDis1Test.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("该文章与原文相似度为："+ans*100+"%");
        TXT_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origAndDis10Test(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_dis_10.txt");
        String ansFileName = "D:/test/ansOrigAndDis10Test.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("该文章与原文相似度为："+ans*100+"%");
        TXT_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origAndDis15Test(){
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_dis_15.txt");
        String ansFileName = "D:/test/ansOrigAndDis15Test.txt";
        double ans = Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("该文章与原文相似度为："+ans*100+"%");
        TXT_IO.writeTxt(ans,ansFileName);
    }

}

