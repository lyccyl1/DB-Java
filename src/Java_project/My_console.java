package Java_project;

import java.io.IOException;

public class My_console {
    public static void main (String [] args ) throws IOException {
        System.out.println("欢迎使用本Java程序来针对蛋白质功能进行操作");
        int flag=0;
        System.out.println("请输入你希望使用的功能后面对应的数字(输入-1退出程序):\n" +
                "Insert data:1\n" +
                "Scan data:2\n" +
                "Search data(精确查找):3\n" +
                "Fuzzy Search data(非精确查找):4\n" +
                "Fuzzy Search data in sorted(非精确查找按相似度从小到大排序):5\n" +
                "analysis data(查看序列长度相关的特征值):6\n" +
                "Clustering analysis(按照相似度的聚类分析):7");
        flag=scan_data.scanint();
        while(flag!=-1){
            if(flag==1){
                Insertdata.operation();
            }
            else if (flag==2){
                scan_data.operation();
            }
            else if (flag==3){
                search_data.operation();
            }
            else if (flag==4){
                fuzzy_query_data.operation();
            }
            else if (flag==5){
                fuzzy_query_data_in_sorted.operation();
            }
            else if (flag==6){
                analysis_data.operation();
            }
            else if (flag==7){
                clustering_analysis.operation();
            }
            else {
                System.out.println("请正确选项输入数字");
            }
            System.out.println("请输入你希望使用的功能后面对应的数字(输入-1退出程序):\n" +
                    "Insert data:1\n" +
                    "Scan data:2\n" +
                    "Search data(精确查找):3\n" +
                    "Fuzzy Search data(非精确查找):4\n" +
                    "Fuzzy Search data in sorted(非精确查找按相似度从小到大排序):5\n" +
                    "analysis data(查看序列长度相关的特征值):6\n" +
                    "Clustering analysis(按照相似度的聚类分析):7");
            flag=scan_data.scanint();
        }
        System.out.println("Program exit");
    }
}
