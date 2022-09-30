import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorrectandWrong {
     CorrectandWrong() throws Exception{
        String str1;
        String str2;
        Scanner scan1;
        Scanner scan2;
        Scanner scan3;

        System.out.println("请输入完成答题题目所在文件名: ");
        scan1 = new Scanner(System.in);
        String Exefile = scan1.nextLine();

        System.out.println("请输入题目正确答案所在文件名: ");
        scan2 = new Scanner(System.in);
        String Ansfile = scan2.nextLine();

        File file1 = new File(Exefile);
        File file2 = new File(Ansfile);

        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);

        List<String> lines1 = new ArrayList<String>();
        List<String> lines2 = new ArrayList<String>();

        while (sc1.hasNextLine())
        {
            lines1.add(sc1.nextLine());
        }

        String[] arr1 = lines1.toArray(new String[0]);
        String[] ans1 =new String[arr1.length];

        for(int i=0;i<arr1.length;i++)
        {
         str1=arr1[i].substring(0, arr1[i].indexOf("="));
         ans1[i]=arr1[i].substring(str1.length()+1, arr1[i].length());
         ans1[i]=ans1[i].trim();
        }

        while (sc2.hasNextLine())
        {
            lines2.add(sc2.nextLine());
        }

        String[] arr2 = lines2.toArray(new String[0]);
        String[] ans2 =new String[arr2.length];

        for(int i=0;i<arr2.length;i++)
        {
            str2=arr2[i].substring(0, arr2[i].indexOf("、"));
            ans2[i]=arr2[i].substring(str2.length()+1, arr2[i].length());
        }


        int[] correct=new int[ans1.length];
        int[] wrong=new int[ans1.length];

        int correct_num=0;
        int wrong_num=0;

        int c=0;
        int w=0;

        for(int j=0;j<ans1.length;j++)
        {

         if(ans1[j].equals(ans2[j]))
         {
          correct_num=correct_num+1;
          correct[c]=j+1;
          c=c+1;
         }
         else
         {
          wrong_num=wrong_num+1;
          wrong[w]=j+1;
          w++;
         }
        }
        StringBuffer A =new StringBuffer("Correct:"+correct_num+"(");
        for(int i=0;i<correct_num;i++)
        {
            A.append(correct[i]+",");
        }
        A.append(")");

        StringBuffer B =new StringBuffer("Wrong:"+wrong_num+"(");
        for(int i=0;i<wrong_num;i++)
        {
            B.append(wrong[i]+",");
        }
        B.append(")");

        System.out.println("请输入校对结果输出的文件名: ");
        scan3 = new Scanner(System.in);
        String Grade = scan3.nextLine();
        BufferedWriter bw=new BufferedWriter(new FileWriter(Grade));
        bw.write(new String(A));
        bw.newLine();
        bw.write(new String(B));
        bw.flush();
        bw.close();
    }
}
