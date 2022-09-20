import org.junit.Test;

public class Hamming_test

 {

    @Test
    public void getHammingDistanceTest() {
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_add.txt");
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + distance);
        System.out.println("相似度: " + (100 - distance * 100 / 128) + "%");
    }

    @Test
    public void getHammingDistanceFailTest() {
        // 测试str0.length()!=str1.length()的情况
        String str0 = "1010";
        String str1 = "1111";
        System.out.println(Hamming.getHammingDistance(str0, str1));
    }

    @Test
    public void getSimilarityTest() {
        String str0 = TXT_IO.readTxt("D:/test/orig.txt");
        String str1 = TXT_IO.readTxt("D:/test/orig_0.8_add.txt");
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        double similarity = Hamming.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("str0和str1的汉明距离: " + distance);
        System.out.println("str0和str1的相似度:" + similarity);
    }
}
