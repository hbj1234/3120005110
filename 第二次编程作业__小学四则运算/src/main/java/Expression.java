import java.util.*;
public class Expression {

    public char[] op = {'+','-','×','÷','(',')'};
    public String[] strOp = {"+","-","×","÷","(",")"};
    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
    public boolean isOp(char c){
        for (char value : op) {
            if (value == c) {
                return true;
            }
        }
        return false;
    }
    public boolean isOp(String s){
        for (String value : strOp) {
            if (value.equals(s)) {
                return true;
            }
        }
        return false;
    }
    public boolean isFenshu(char c) {
        return c == '/';
    }

    //处理输入的计算式
    public List<String> process(String str){
        List<String> list = new ArrayList<>();
        char c;
        StringBuilder tb = new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            c = str.charAt(i);
            if(isDigit(c)||isFenshu(c))
            {
                tb.append(c);

            }
            if(isOp(c))
            {
                if(tb.toString().length()>0){
                    list.add(tb.toString());
                    tb.delete(0, tb.toString().length());
                }
                list.add(c+"");
            }
        }
        if(tb.toString().length()>0)
        {
            list.add(tb.toString());
            tb.delete(0, tb.toString().length());
        }



        return list;

    }

    //一般计算式转换为后缀表达式
    public List<String> simpleTosuffix(List<String> list){
        List<String> Postfixlist = new ArrayList<>();//存放后缀表达式
        Stack<String> stack = new Stack<>();//暂存操作符
        for(int i=0;i<list.size();i++){

            String s = list.get(i);
            switch (s) {
                case "(", "×", "÷" -> stack.push(s);
                case "+", "-" -> {
                    if (!stack.empty()) {
                        while (!(stack.peek().equals("("))) {
                            Postfixlist.add(stack.pop());
                            if (stack.empty()) {
                                break;
                            }
                        }
                    }
                    stack.push(s);
                }
                case ")" -> {
                    while (!(stack.peek().equals("("))) {
                        Postfixlist.add(stack.pop());
                    }
                    stack.pop();
                }
                default -> Postfixlist.add(s);
            }
            if(i==list.size()-1){
                while(!stack.empty()){
                    Postfixlist.add(stack.pop());
                }
            }
        }
        return Postfixlist;
    }

    //后缀表达式计算
    public Fenshu count(String str){
        List<String> list2 = process(str);
        List<String> list = simpleTosuffix(list2);
        Stack<Fenshu> stack = new Stack<>();
        for (String s : list) {
            if (!isOp(s)) {
                Fenshu fenshu;
                StringTokenizer tokenizer = new StringTokenizer(s, "/");
                int numerator = Integer.parseInt(tokenizer.nextToken());
                if (tokenizer.hasMoreTokens()) {
                    int denominator = Integer.parseInt(tokenizer.nextToken());
                    fenshu = new Fenshu(numerator, denominator);
                } else {
                    fenshu = new Fenshu(numerator, -1);
                }
                stack.push(fenshu);
            } else {
                switch (s) {
                    case "+" -> {
                        Fenshu a1 = stack.pop();
                        Fenshu a2 = stack.pop();
                        Fenshu v = a2.add(a1);
                        stack.push(v);
                    }
                    case "-" -> {
                        Fenshu a1 = stack.pop();
                        Fenshu a2 = stack.pop();
                        Fenshu v = a2.sub(a1);
                        stack.push(v);
                    }
                    case "×" -> {
                        Fenshu a1 = stack.pop();
                        Fenshu a2 = stack.pop();
                        Fenshu v = a2.muti(a1);
                        stack.push(v);
                    }
                    case "÷" -> {
                        Fenshu a1 = stack.pop();
                        Fenshu a2 = stack.pop();
                        Fenshu v = a2.div(a1);
                        stack.push(v);
                    }
                }
            }
        }
        return stack.pop();
    }
}
