package Java_project;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;
public class scan_data{
    public static void operation() throws IOException {
        System.out.println("Name1:(需要查询哪个数据表格？ cafa.fa;cafa.tsv;swiss.fa;swiss.tsv)");
        String fileName = scan();
        System.out.println("Name2:(请输入需要保存的文件格式: csv or tsv )");
        String outName = scan();
        int x = 0,n=0,h=0,flag =0;
        ArrayList arr = new ArrayList();
        if (outName.equals("csv")) {
            arr=operation_out_data.input_in_csv(fileName);
            flag = 1;
        }
        else if (outName.equals("tsv")){
            arr=operation_out_data.input_in_tsv(fileName);
            flag = 2 ;
        }
        else {
            System.out.println("Sorry." +
                    "Your request is not included\n You can try input csv or tsv in Name2");
        }
        if (fileName.equals("cafa.fa")){
            x=4;
        }
        else if (fileName.equals("swiss.fa")){
            x=65;
        }
        else if (fileName.equals("cafa.tsv")){
            x=4;
        }
        else if (fileName.equals("swiss.tsv")){
            x=68;
        }//init the max size
        System.out.println("我想查看的页数是:  不能超过总页数:"+x+"（输入 -1 退出）");
        while((n=scanint())!=-1){
            if(n==-1 ){
               System.out.println("已退出");
               break;
            }//
            if (n>x){
                System.out.println("超过最大页数，已退出");
                break;
            }
            operation_out_data.out_data_scan(arr,n,x);
            System.out.println("输入 1 打印当前该页 输入 2 进入输入查看页数选项");
            h=scanint();
            if(h==1){
            System.out.println("给你的文件取个名字吧:");
            String myname=scan();
            while(!myname.substring(myname.length()-4).equals(".tsv")&&!myname.substring(myname.length()-4).equals(".csv")) {
                System.out.println("你取的名字有问题哦 请以.csv or .tsv结尾");
                myname=scan();
            }
                if (flag ==1 ){
                    String outname="data"+n+".csv";
                    operation_out_data.out_data_print(arr,myname,n,x);
                }
                else if  (flag==2 ){
                    String outname="data"+n+".tsv";
                    operation_out_data.out_data_print(arr,myname,n,x);
                }
                System.out.println("我想查看的页数是:  不能超过总页数:"+x+"（输入 -1 退出）");
                continue;
            }
            else if (h==2){
                System.out.println("我想查看的页数是:  不能超过总页数:"+x+"（输入 -1 退出）");
                continue;
            }
            else {
                System.out.println("输入错误，请检查，已退出");
                break;
            }
        }
    }
    public static String scan(){
        Scanner in = new Scanner(System.in);
        String st=in.nextLine();
        return st;
    }
    public static int scanint(){
        Scanner in =new Scanner(System.in);
        int st = in.nextInt();
        return st;
    }
}