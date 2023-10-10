package Java_project;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class analysis_data {
    public static void operation ( )throws IOException {
        System.out.println("输入想要访问的数据文件（cafa.fa;cafa.tsv;swiss.fa;swiss.tsv）");
        String filename =scan_data.scan();
        ArrayList arr = new ArrayList();
        ArrayList res = new ArrayList();
        int f =-1 ,flag=1;
        arr=operation_out_data.input_in_tsv(filename);
        if(filename.equals("cafa.fa")){
            f=1;
        }
        else if (filename.equals("cafa.tsv")){
            f=2;
        }
        else if (filename.equals("swiss.fa")){
            f=1;
        }
        else if(filename.equals("swiss.tsv")){
            f=3;
        }
        else{
            System.out.println("输入的文件不在收录列表中,已退出程序");
            flag=0;
        }
        if (flag==1 ){
            if(f==1){
                double sum = operation_out_data.sum_in_data(arr,1);
                double ave= sum/(arr.size());
                System.out.println("数据文件"+filename+"的sequences序列长度的平均数为:"+ave);
                ArrayList okarr=new ArrayList();
                okarr = operation_out_data.okk(arr,1);
                Collections.sort(okarr);
                double mid = 0;
                int len = okarr.size();
                if(len%2==0) mid = (Double.parseDouble(String.valueOf(okarr.get(len/2)))+Double.parseDouble(String.valueOf(okarr.get(len/2+1))))/2;
                else mid = Double.parseDouble(String.valueOf(okarr.get(len/2)));
                System.out.println("数据文件"+filename+"的sequences序列长度的中位数为"+mid);
                int maxc=maxcount(okarr);
                String str1="数据文件"+filename+"的sequences序列长度的平均数为:"+ave+"\n";
                res.add(str1);
                String str2="数据文件"+filename+"的sequences序列长度的中位数为"+mid+"\n";
                res.add(str2);
                String str3="数据文件"+filename+"的sequences序列长度的众数为"+maxc+"\n";
                res.add(str3);
                System.out.println("数据文件"+filename+"的sequences序列长度的众数为"+maxc);
            }
            else if(f==2){
                double sum = operation_out_data.sum_in_data(arr,2);
                double ave= sum/(arr.size());
                System.out.println("数据文件"+filename+"的sequences序列长度的平均数为:"+ave);
                ArrayList okarr=new ArrayList();
                okarr = operation_out_data.okk(arr,2);
                Collections.sort(okarr);
                double mid = 0;
                int len = okarr.size();
                if(len%2==0) mid = (Double.parseDouble(String.valueOf(okarr.get(len/2)))+Double.parseDouble(String.valueOf(okarr.get(len/2+1))))/2;
                else mid = Double.parseDouble(String.valueOf(okarr.get(len/2)));
                System.out.println("数据文件"+filename+"的sequences序列长度的中位数为"+mid);
                int maxc=maxcount(okarr);
                System.out.println("数据文件"+filename+"的sequences序列长度的众数为"+maxc);
                String str1="数据文件"+filename+"的sequences序列长度的平均数为:"+ave+"\n";
                res.add(str1);
                String str2="数据文件"+filename+"的sequences序列长度的中位数为"+mid+"\n";
                res.add(str2);
                String str3="数据文件"+filename+"的sequences序列长度的众数为"+maxc+"\n";
                res.add(str3);
            }
            else  if(f==3){
                double sum = operation_out_data.sum_in_data(arr,3);
                double ave= sum/(arr.size());
                System.out.println("数据文件"+filename+"的sequences序列长度的平均数为:"+ave);
                ArrayList okarr=new ArrayList();
                okarr = operation_out_data.okk(arr,3);
                Collections.sort(okarr);
                double mid = 0;
                int len = okarr.size();
                if(len%2==0) mid = (Double.parseDouble(String.valueOf(okarr.get(len/2)))+Double.parseDouble(String.valueOf(okarr.get(len/2+1))))/2;
                else mid = Double.parseDouble(String.valueOf(okarr.get(len/2)));
                System.out.println("数据文件"+filename+"的sequences序列长度的中位数为"+mid);
                int maxc=maxcount(okarr);
                System.out.println("数据文件"+filename+"的sequences序列长度的众数为"+maxc);
                String str1="数据文件"+filename+"的sequences序列长度的平均数为:"+ave+"\n";
                res.add(str1);
                String str2="数据文件"+filename+"的sequences序列长度的中位数为"+mid+"\n";
                res.add(str2);
                String str3="数据文件"+filename+"的sequences序列长度的众数为"+maxc+"\n";
                res.add(str3);
            }
            int n=0;
            int x=0;

            System.out.println("输入 1 打印");
            int h=scan_data.scanint();
            if(h==1){
                System.out.println("给你的文件取个名字吧:");
                    String myname=scan_data.scan();
                    while(!myname.substring(myname.length()-4).equals(".tsv")&&!myname.substring(myname.length()-4).equals(".csv")&&!myname.substring(myname.length()-4).equals(".txt")) {
                        System.out.println("你取的名字有问题哦 请以.csv or .tsv or .txt结尾");
                        myname=scan_data.scan();
                    }
                        operation_out_data.out_data_print(res,myname,1,1);
                }
                else {
                    System.out.println("输入错误，请检查，已退出");
                }
            }

    }
    public static int maxcount(ArrayList arr){
        HashSet<Integer> uniqueData = new HashSet<Integer>(arr);
        HashMap<Integer, Integer> mass = new HashMap<>();
        int[] count = new int[uniqueData.size()];
        int j=0;
        for (Integer double1 : uniqueData) {
            for (Object double2 : Collections.unmodifiableList(arr)) {
                if(double1.equals(double2)) count[j]++;
            }
            mass.put(count[j],double1);
            j++;
        }
        int k=0;
        for (int i: count) {
            k = Math.max(k, i);
        }
        return Integer.parseInt(String.valueOf(mass.get(k)));
    }
}