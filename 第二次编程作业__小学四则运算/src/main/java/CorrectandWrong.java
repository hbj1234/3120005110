import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class CorrectandWrong {

	Scanner scan1;
	Scanner scan2;

	CorrectandWrong() throws IOException {
		System.out.println("请输入题目所在文件名: ");
		scan1 = new Scanner(System.in);
		String Exefile = scan1.nextLine();
		System.out.println("请输入答案所在文件名: ");
		scan2 = new Scanner(System.in);
		String Ansfile = scan2.nextLine();
		File exefile = new File(Exefile);
		File ansfile = new File(Ansfile);
		if(exefile.exists()&&ansfile.exists()) {
			InputStreamReader exread = new InputStreamReader(new FileInputStream(Exefile), "GB2312");
			BufferedReader exbr = new BufferedReader(exread);
			InputStreamReader anread = new InputStreamReader(new FileInputStream(Ansfile), "GB2312");
			BufferedReader anbr = new BufferedReader(anread);
			String ex,an;
			String exback,anback;
			String[] exlist,anlist,Exercises,Answers;
			StringBuffer exercises = new StringBuffer();
			StringBuffer answers = new StringBuffer();
			int correct_sum = 0;
			int wrong_sum = 0;
			StringBuffer correct = new StringBuffer();
			StringBuffer wrong = new StringBuffer();
			while((ex=exbr.readLine())!=null) {
				exlist = ex.split(" ");
				if(exlist[exlist.length-1].equals("=")) {
					exback = "-";
				}else {
					exback = exlist[exlist.length-1];
				}
				exercises.append(exback+",");
			}
			Exercises = exercises.toString().split(",");
			while((an=anbr.readLine())!=null) {
				anlist = an.split(" ");
				anback = anlist[anlist.length-1];
				answers.append(anback+",");
			}
			Answers = answers.toString().split(",");
			for(int i=0;i<Exercises.length;i++)
			{
				if(Exercises[i].equals(Answers[i])) {
					correct.append(i+1+" ");
					correct_sum++;
				}else {
					wrong.append(i+1+" ");
					wrong_sum++;
				}
			}
			System.out.println("Correct: "+correct_sum+" ( "+correct+")");
			System.out.println("Wrong: "+wrong_sum+" ( "+wrong+")");
			NumberFormat nt = NumberFormat.getPercentInstance();
			nt.setMinimumFractionDigits(2);
			double correctpercent = (double) correct_sum / (double) Exercises.length;
			double wrongpercent = (double) wrong_sum / (double) Exercises.length;
			System.out.println("正确率: "+nt.format(correctpercent));
			System.out.println("错误率: "+nt.format(wrongpercent));
			exread.close();
			anread.close();
			exbr.close();
			anbr.close();
		}else {
			System.out.println("找不到指定文件!");
		}
	}
}
