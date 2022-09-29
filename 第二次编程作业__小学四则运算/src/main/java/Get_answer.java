public class Get_answer {
        public static String answerget(String res,int i){
            Expression ex = new Expression();
            Fenshu ansresult = ex.count(res);
            String ansres;
            if(ansresult.getDenominator()==1) {
                ansres = (i+1)+"、"+" "+ansresult.getNumerator() + "\r\n";
            }else {
                if(ansresult.getNumerator()>ansresult.getDenominator()) {
                    int fz = ansresult.getNumerator();
                    int fm = ansresult.getDenominator();
                    int mut = fz / fm;
                    int newfz = fz % fm;
                    ansres = (i+1)+"、"+" " + mut + "'" +newfz+"/"+fm + "\r\n";
                }else if(ansresult.getNumerator()==ansresult.getDenominator()) {
                    ansres = (i+1)+"、"+" " +"1"+ "\r\n";
                }else {
                    ansres = (i+1)+"、"+" " +ansresult.getNumerator()+"/"+ansresult.getDenominator() + "\r\n";
                }
            }return ansres;
        }
    }


