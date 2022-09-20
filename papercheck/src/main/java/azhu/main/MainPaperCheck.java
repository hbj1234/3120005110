package azhu.main;
import java.io.File;
import com.azhu.utils.HammingUtils;
import com.azhu.utils.SimHashUtils;


import java.io.*;

public class MainPaperCheck {

    public class TxtIOUtils {

        /**
         * 读出txt文件
         * 传入文件绝对路径，将文件内容转化为 String字符串输出
         * @param txtPath 文件路径
         * @return 文件内容
         */
        public static String readTxt(String txtPath) {
            String str = "";
            String strLine;
            // 将 txt文件按行读入 str中
            File file = new File(txtPath);
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                // 字符串拼接
                while ((strLine = bufferedReader.readLine()) != null) {
                    str += strLine;
                }
                // 关闭资源
                inputStreamReader.close();
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        /**
         * 写入txt文件
         * 传入内容、文件全路径名，将内容写入文件并换行
         * @param txtElem 传入的内容
         * @param txtPath 写入的文件路径
         */
        public static void writeTxt(double txtElem,String txtPath){
            String str = Double.toString(txtElem);
            File file = new File(txtPath);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));
                fileWriter.write("\r\n");
                // 关闭资源
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串

        String str0 = TxtIOUtils.readTxt(args[0]);
        String str1 = TxtIOUtils.readTxt(args[1]);
        String resultFileName = args[2];
        // 由字符串得出对应的 simHash值
        String simHash0 = SimHashUtils.getSimHash(str0);
        String simHash1 = SimHashUtils.getSimHash(str1);
        // 由 simHash值求出相似度
        double similarity = HammingUtils.getSimilarity(simHash0, simHash1);
        // 把相似度写入最后的结果文件中
        TxtIOUtils.writeTxt(similarity, resultFileName);
        // 退出程序
        System.exit(0);
    }

}



/**
 * 读写txt文件的工具类
 */

