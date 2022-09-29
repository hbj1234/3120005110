import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Judge
{
    public static void order() throws IOException
    {
        while (true)
        {
            int num,range;    //存放题目数，题目数值范围
            byte[] print;
            System.out.println("请输入: 1或2 \t (1.生成题目;2.校对答案)");
            Scanner scan = new Scanner(System.in);
            Random ran=new Random();
            CreatExpression NB=new CreatExpression();
            File quetion = new File("Exercises.txt");
            File answer = new File("Answers.txt");

            //如果本地不存在Exercises和Answer文件，则新建文件
            if(!quetion.exists())
            {
                quetion.createNewFile();
            }
            if(!answer.exists())
            {
                answer.createNewFile();
            }
            FileOutputStream fosque = new FileOutputStream(quetion);
            FileOutputStream fosans = new FileOutputStream(answer);


            String command = scan.nextLine();
            if (command.equals("1"))
            {

                /**
                 * 利用split方法对输入的命令分割，输入order_num[2]中
                 * equals判定order_num[0]是否为-n,order_num[1]是否为非零自然数
                 * -r命令同理
                 */
                System.out.println("请输入要生成的题目数(命令形式为:-n 自然数):");
                String[] order_num = scan.nextLine().split(" ");



                if(order_num[0].equals("-n")&&judge_num(order_num[1]))
                {
                    /*通过Integer.parseInt将纯数字的字符串转化整形数据*/
                    if(Integer.parseInt(order_num[1])>=1)
                    {
                        num = Integer.parseInt(order_num[1]);

                        System.out.println("请输入题目中数值的最大值(命令形式为:-r 自然数):");
                        String[] order_range = scan.nextLine().split(" ");

                        if(order_range[0].equals("-r")&&judge_num(order_range[1]))
                        {
                            if(Integer.parseInt(order_range[1])>=1)
                            {
                                range = Integer.parseInt(order_range[1]);

                                //利用循环生成指定数量的题目
                                for(int i=0;i<num;i++)
                                {
                                    /*生成1，2，3形成含有不同数量运算符的题目*/
                                    int opernum =  ran.nextInt(3)+1;

                                    /*字符串que_result存放题目，ans_result存放答案*/
                                    String que = NB.buildExpression(range, opernum);
                                    String que_result = (i+1)+"、"+" " + que +"\n";
                                    String ans_result=Get_answer.answerget(que,i);

                                    print = que_result.getBytes();
                                    fosque.write(print);
                                    print = ans_result.getBytes();
                                    fosans.write(print);
                                    System.out.println(que_result);

                                }
                            }else {
                                System.out.println("-r参数设置错误，请重新输入，-r参数必须为非0自然数!");
                            }
                        }
                        else
                        {
                            System.out.println("-r命令输入错误，请重新输入!");
                        }
                    }
                    else
                    {
                        System.out.println("-n参数设置错误，请重新输入，题目数量必须大于等于1!");
                    }
                }
                else
                {
                    System.out.println("-n命令输入错误，请重新输入!");
                }

                System.out.println("是否结束程序: YES or NO");
                scan = new Scanner(System.in);
                String expect = scan.nextLine();
                if (expect.equals("YES"))
                {
                    break;
                }
            }

            else if (command.equals("2"))
            {
                new CorrectandWrong();
                System.out.println("是否结束程序: YES or NO");
                scan = new Scanner(System.in);
                String exit = scan.nextLine();
                if (exit.equals("YES")) {
                    break;
                }
            }
            else
            {
                System.out.println("输入错误，请重新输入!");
            }//while结束
        }
    }

    /*判断输入的命令是否正常*/
    static boolean judge_num(String order) {
        /**
         * 判断是否为整数
         * @param str 传入的字符串
         * @return 是整数返回true, 否则返回false
         */
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(order).matches();
    }
}