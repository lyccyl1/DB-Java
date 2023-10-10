package Java_project;
import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class clustering_analysis {
    public static void operation() throws IOException {
        System.out.println("请输入需要访问的数据文件(进行查看sequences聚类分析)（cafa.fa;cafa.tsv;swiss.fa;swiss.tsv）");
        String filename= scan_data.scan();
        System.out.println("请输入接受的最小相似度:?%(输入百分数的数字部分)");
        double min= Double.parseDouble(scan_data.scan());
        ArrayList arr= new ArrayList();
        int flag=1,f =-1,fl=-1;
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
        arr=operation_out_data.input_in_tsv(filename);
        if (flag==1 ){
            if (f==1 ){
                fl=2;
            }
            else if (f==2 ){
                fl=3;
            }
            else if (f==3){
                fl=4;
            }
            operation_out_data.res_in_analysis(arr,fl-1,min);
        }
    }
}
