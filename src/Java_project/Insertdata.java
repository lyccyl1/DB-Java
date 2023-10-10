package Java_project;
import java.io.*;
public class Insertdata {
    public static void operation() throws IOException {
        readcafafasta();//read the data from cafa3.fasta
        readswisstsv();//read the data from swiss.tsv
        readswissfa();//read the data from  swiss.fa
        readcafatsv();//read the data from cafa.tsv
}
    public static void readcafafasta()throws IOException{
        String cafafa="D:\\astudy\\javaproject\\cafa3_partial_data.fa";
        File file = new File("D:\\astudy\\javaproject\\cafa3_partial_data.fa");
        String oj;
        BufferedReader cafa = new BufferedReader(new FileReader(file ));
        oj=cafa.readLine();
        while (oj!=null){
            if (oj.charAt(0)>='>'){
                String proteins =oj.substring(1);
                String sequences =cafa.readLine();
                operation_in_db.insertCafafa(proteins,sequences);
                System.out.println("Inserted success!"+proteins);
            }
            oj=cafa.readLine();
        }
    }
    public static void readswisstsv() throws  IOException {
        String swisstsv="D:\\astudy\\javaproject\\swissprot_data.tsv";
        File file = new File("D:\\astudy\\javaproject\\swissprot_data.tsv");
        String oj;
        BufferedReader swiss = new BufferedReader(new FileReader(file));
        oj = swiss.readLine();
        while (oj != null) {
            String[] a = oj.split("\t");
            if (a.length == 7) {
                a[4] = a[4].replaceAll("[']", "''");
                a[5] = a[5].replaceAll("[']", "''");
                operation_in_db.insertswisstsv(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], a[6]);
                System.out.println("success!" + a[1]);
            }
            oj = swiss.readLine();
        }
    }
    public static void readswissfa()throws IOException{
        String swissfa="D:\\astudy\\javaproject\\swissprot_exp.fasta";
        String file = "D:\\astudy\\javaproject\\swissprot_exp.fasta";
        String oj,str;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((oj=br.readLine())!=null){
            String sequences="";
            if (oj.charAt(0)=='>'){
                String proteins =oj.substring(1);
                while((oj= br.readLine())!=null){
                    if (oj.charAt(0)!='>'){
                        sequences+=oj.replace("\n","");
                        break;
                    }
                }
                operation_in_db.insertswissfa(proteins,sequences);//
                System.out.println("Inserted success!"+proteins);
            }
        }
    }
   public static void readcafatsv() throws  IOException{
        String cafatsv="D:\\astudy\\javaproject\\cafa3_partial_data.tsv";
        File file = new File("D:\\astudy\\javaproject\\cafa3_partial_data.tsv");
        String oj;
        BufferedReader br = new BufferedReader(new FileReader(file ));
        oj=br.readLine();
        while (oj!=null){
                String[] a=oj.split("\t");
                if (a.length==4){
                a[3]=a[3].replaceAll("[']","''");
                operation_in_db.insertcafatsv(Integer.parseInt(a[0]),a[1],a[2],a[3]);
                System.out.println("inserted success! "+a[1]);
           }
                oj=br.readLine();
        }
    }
}
