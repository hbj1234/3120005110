import java.util.*;

public class CreatExpression {

    String buildExpression(int range , int operatenum)
    {
        Random ran = new Random();
        String[] operate = {"+","-","×","÷"};
        StringBuilder str = new StringBuilder();
        StringBuilder strnew = new StringBuilder();
        int num;
        int numerator;
        int denominator;
        String oper;
        Fenshu fenshu;
        int divcount = 0;
        String[] numlist = new String[operatenum+1]; //存放表达式中的数字
        String[] operlist = new String[operatenum];  //存放表达式中的算式符
        for(int i=0;i<operatenum;i++)
        {
            oper=operate[ran.nextInt(4)];
            operlist[i]=oper;
            if(oper.equals("÷"))
            {
                divcount++;
            }
        }

        for(int i=0;i<operatenum+1;i++)
        {
            if(divcount==0)
            {
                num= ran.nextInt(range);
                numerator = ran.nextInt(range);
                denominator = ran.nextInt(range);
            }
            else
            {
                num= ran.nextInt(range)+1;
                numerator = ran.nextInt(range)+1;
                denominator = ran.nextInt(range)+1;
            }
            if(numerator<=denominator)
            {
                fenshu = new Fenshu(numerator,denominator);
            }
            else
            {
                fenshu = new Fenshu(denominator, numerator);
            }
            numlist[i]=randominput(num, fenshu);
        }

        /*将数字和运算符结合形成题目*/
        for(int i=0;i<2*operatenum+1;i++) {
            if(i%2==0)
            {
                str.append(numlist[i / 2]).append(" ");
            }
            if(i%2!=0)
            {
                str.append(operlist[(i - 1) / 2]).append(" ");
            }
        }
        str.append("="+" ");

        String[] judge = str.toString().split(" ");
        for(int i=1;i<judge.length-1;i+=2)
        {
            if(judge[i].equals("-"))
            {
                Fenshu fs = new Fenshu();
                Expression ex = new Expression();
                StringBuilder font = new StringBuilder();
                StringBuilder back = new StringBuilder();
                StringBuilder newstr = new StringBuilder();
                for(int k=0;k<i;k++)
                {
                    font.append(judge[k]).append(" ");
                }
                for(int k=i+1;k<judge.length-1;k++)
                {
                    back.append(judge[k]).append(" ");
                }
                Fenshu fontfs = ex.count(font.toString());
                Fenshu backfs = ex.count(back.toString());
                String fontstr = fontfs.numerator+"/"+fontfs.denominator;
                String backstr = backfs.numerator+"/"+backfs.denominator;
                if(fs.compute(fontstr, backstr)) {
                    newstr.append(back).append("- ").append(font).append("= ");
                    String[] newjudge = newstr.toString().split(" ");
                    System.arraycopy(newjudge, 0, judge, 0, newjudge.length);
                }
            }
        }
        for (String s : judge) {
            strnew.append(s).append(" ");
        }
        return strnew.toString();
    }

    /*随机生成自然数或者真分数*/
    String randominput(int num,Fenshu fenshu) {
        String numstr = num+"";
        String fenshustr = fenshu.getNumerator() +"/"+fenshu.getDenominator();
        String[] strlist = {numstr , fenshustr};
        Random r = new Random();
        return strlist[r.nextInt(2)];
    }
}