import java.util.StringTokenizer;

public class Fenshu {
    int numerator;  // 分子
    int denominator; // 分母

    Fenshu() { }

    Fenshu(int a,int b)
    {
        if(a == 0)
        {
            numerator = 0;
            denominator = 1;
        }else if(b == -1)
        {
            numerator = a;
            denominator = 1;
        }else
        {
            setNumeratorAndDenominator(a,b);
        }
    }

    void setNumeratorAndDenominator(int a, int b){  // 设置分子和分母
        int c = f(Math.abs(a),Math.abs(b));         // 计算最大公约数
        numerator = a / c;
        denominator = b / c;
        if(numerator<0 && denominator<0)
        {
            numerator = - numerator;
            denominator = - denominator;
        }
    }

    int getNumerator(){
        return numerator;
    }

    int getDenominator(){
        return denominator;
    }

    /*求a和b的最大公约数*/
    int f(int a,int b)
    {
        int s=1;
        for(int i=1;i<=a;i++)
        {
            if((a%i)==0&&(b%i)==0)
            {
                s=i;
            }
        }
        return s;
    }

    Fenshu add(Fenshu r){  // 加法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        return new Fenshu(newNumerator,newDenominator);
    }

    Fenshu sub(Fenshu r){  // 减法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        return new Fenshu(newNumerator,newDenominator);
    }

    Fenshu muti(Fenshu r){ // 乘法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        return new Fenshu(newNumerator,newDenominator);
    }

    Fenshu div(Fenshu r){  // 除法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        return new Fenshu(newNumerator,newDenominator);
    }

    // 比较大小
    public boolean compute(String data1,String data2){
        StringTokenizer fenxi = new StringTokenizer(data1,"/");
        int data1_1 = Integer.parseInt(fenxi.nextToken());
        int data1_2;
        if(fenxi.hasMoreTokens()) {
            data1_2 = Integer.parseInt(fenxi.nextToken());
        }else {
            data1_2 = 1;
        }

        fenxi = new StringTokenizer(data2,"/");
        int data2_1 = Integer.parseInt(fenxi.nextToken());
        int data2_2;
        if(fenxi.hasMoreTokens()) {
            data2_2 = Integer.parseInt(fenxi.nextToken());
        }else {
            data2_2 = 1;
        }


        Fenshu r1 = new Fenshu(data1_1,data1_2);
        Fenshu r2 = new Fenshu(data2_1,data2_2);

        Fenshu result;
        int a;
        result = r1.sub(r2);
        a = result.getNumerator();
        return a < 0;
    }
}

