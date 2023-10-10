package Java_project;
import java.io.IOException;
import java.util.ArrayList;

public class fuzzy_query_data_in_sorted {
    public static void operation() throws IOException {
        System.out.println("请输入需要访问的数据文件 （cafa.fa;cafa.tsv;swiss.fa;swiss.tsv）");
        String filename= scan_data.scan();
        int br =1 ;
        int flag=1,f =-1,fl=-1;
        ArrayList arr = new ArrayList();
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
        if(flag==1){
            while(arr.size()==0){
                arr=operation_out_data.input_in_tsv(filename); 
                String name = null;
                if(f==1){
                    int key;
                    String choice="proteins,sequences";
                    String []a=choice.split(",");
                    System.out.println("请输入序列:"+a[1]+"的检索关键字(非精准匹配)带有相似度排序，输入-1退出");
                    name= scan_data.scan();
                    if(name.equals("-1")){
                        System.out.println("program exit");
                        br=0;
                        break;
                    }
                    arr=operation_out_data.search_in_data_fuzzy_sorted(arr,1,name);
                }
                else if (f==2){
                    int key;
                    String choice="index,proteins,sequences,annotations";
                    String []a=choice.split(",");
                    System.out.println("请输入序列:"+a[2]+"的检索关键字(非精准匹配)带有相似度排序，输入-1退出");
                    name= scan_data.scan();
                    if(name.equals("-1")){
                        System.out.println("program exit");
                        br=0;
                        break;
                    }
                    arr=operation_out_data.search_in_data_fuzzy_sorted(arr,2,name);
                }
                else if (f==3){
                    int key;
                    String choice="index,proteins,accessions,sequences,annotations,interpros,orgs";
                    String []a=choice.split(",");
                    System.out.println("请输入序列:"+a[3]+"的检索关键字(非精准匹配)带有相似度排序，输入-1退出");
                    name= scan_data.scan();
                    if(name.equals("-1")){
                        System.out.println("program exit");
                        br=0;
                        break;
                    }
                    arr=operation_out_data.search_in_data_fuzzy_sorted(arr,3,name);
                }
                if(name.equals("-1")){
                    System.out.println("program exit");
                    br=0;
                    break;
                }
                if (arr.size()==0){
                    System.out.println("输入的关键字没有匹配项，请重新输入");
                }
            }
            if(br==1){
                System.out.println("输入关键字非精准匹配到"+arr.size()+"个结果,每1000个为一页，请输入需要查询的页码：");
                int n=0;
                int x=0;
                if (arr.size()%1000==0){
                    x = arr.size()/1000;
                }
                else {
                    x = arr.size()/1000 + 1 ;
                }
                while((n=scan_data.scanint())!=-1){
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
                    int h=scan_data.scanint();
                    if(h==1){
                        System.out.println("给你的文件取个名字吧,以tsv结尾:");
                        String myname=scan_data.scan();
                        while(!myname.substring(myname.length()-4).equals(".tsv")) {
                            System.out.println("你取的名字有问题哦 请以.tsv结尾");
                            myname=scan_data.scan();
                        }
                        if(myname.substring(myname.length()-4).equals(".csv")){
                            fl=1;
                        }
                        else if (myname.substring(myname.length()-4).equals(".tsv")){
                            fl=2;
                        }
                        if (fl==1 ){
                            String outname="data"+n+".csv";
                            operation_out_data.out_data_print(arr,myname,n,x);
                        }
                        else if  (fl==2 ){
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
        }
    }
}