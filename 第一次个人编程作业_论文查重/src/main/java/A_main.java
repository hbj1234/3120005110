import java.util.*;

public class A_main {
    public static void main(String[] args) {
        //分别输入所用及保存文件地址
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入原文地址：");
        String s1 = scan.next();
        System.out.print("请输入抄袭文地址：");
        String s2 = scan.next();
        System.out.print("请输入保存结果地址：");
        String resultFileName = scan.next();

        // 从输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = TXT_IO.readTxt(s1);
        String str1 = TXT_IO.readTxt(s2);

        // 由字符串得出对应的 simHash值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // 由 simHash值求出相似度
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        // 在运行窗口中表示相似度，并把相似度写入最后的结果文件中
        System.out.println("该文章与原文相似度为："+similarity*100+"%");
        TXT_IO.writeTxt(similarity, resultFileName);
    }
}
