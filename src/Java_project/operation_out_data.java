package Java_project;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class operation_out_data {
    public static double cot(int[] arr, int[] brr) {
        double res = 0;
        int sum = 0;
        int fm1 = 0, fm2 = 0;
        for (int i = 0; i < brr.length; i++) {
            sum += arr[i] * brr[i];
            fm1 += arr[i] * arr[i];
            fm2 += brr[i] * brr[i];
        }
        res = sum / (Math.sqrt(fm1) * Math.sqrt(fm2));
        return res;
    }

    public static void res_in_analysis(ArrayList target, int n, double min) throws IOException {
        int f = 1, sum = 0;
        ArrayList arr = new ArrayList(Arrays.asList("AA", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AK", "AL", "AM", "AN", "AP", "AQ", "AR", "AS", "AT", "AV", "AW", "AY", "CA", "CC", "CD", "CE", "CF", "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CP", "CQ", "CR", "CS", "CT", "CV", "CW", "CY", "DA", "DC", "DD", "DE", "DF", "DG", "DH", "DI", "DK", "DL", "DM", "DN", "DP", "DQ", "DR", "DS", "DT", "DV", "DW", "DY", "EA", "EC", "ED", "EE", "EF", "EG", "EH", "EI", "EK", "EL", "EM", "EN", "EP", "EQ", "ER", "ES", "ET", "EV", "EW", "EY", "FA", "FC", "FD", "FE", "FF", "FG", "FH", "FI", "FK", "FL", "FM", "FN", "FP", "FQ", "FR", "FS", "FT", "FV", "FW", "FY", "GA", "GC", "GD", "GE", "GF", "GG", "GH", "GI", "GK", "GL", "GM", "GN", "GP", "GQ", "GR", "GS", "GT", "GV", "GW", "GY", "HA", "HC", "HD", "HE", "HF", "HG", "HH", "HI", "HK", "HL", "HM", "HN", "HP", "HQ", "HR", "HS", "HT", "HV", "HW", "HY", "IA", "IC", "ID", "IE", "IF", "IG", "IH", "II", "IK", "IL", "IM", "IN", "IP", "IQ", "IR", "IS", "IT", "IV", "IW", "IY", "KA", "KC", "KD", "KE", "KF", "KG", "KH", "KI", "KK", "KL", "KM", "KN", "KP", "KQ", "KR", "KS", "KT", "KV", "KW", "KY", "LA", "LC", "LD", "LE", "LF", "LG", "LH", "LI", "LK", "LL", "LM", "LN", "LP", "LQ", "LR", "LS", "LT", "LV", "LW", "LY", "MA", "MC", "MD", "ME", "MF", "MG", "MH", "MI", "MK", "ML", "MM", "MN", "MP", "MQ", "MR", "MS", "MT", "MV", "MW", "MY", "NA", "NC", "ND", "NE", "NF", "NG", "NH", "NI", "NK", "NL", "NM", "NN", "NP", "NQ", "NR", "NS", "NT", "NV", "NW", "NY", "PA", "PC", "PD", "PE", "PF", "PG", "PH", "PI", "PK", "PL", "PM", "PN", "PP", "PQ", "PR", "PS", "PT", "PV", "PW", "PY", "QA", "QC", "QD", "QE", "QF", "QG", "QH", "QI", "QK", "QL", "QM", "QN", "QP", "QQ", "QR", "QS", "QT", "QV", "QW", "QY", "RA", "RC", "RD", "RE", "RF", "RG", "RH", "RI", "RK", "RL", "RM", "RN", "RP", "RQ", "RR", "RS", "RT", "RV", "RW", "RY", "SA", "SC", "SD", "SE", "SF", "SG", "SH", "SI", "SK", "SL", "SM", "SN", "SP", "SQ", "SR", "SS", "ST", "SV", "SW", "SY", "TA", "TC", "TD", "TE", "TF", "TG", "TH", "TI", "TK", "TL", "TM", "TN", "TP", "TQ", "TR", "TS", "TT", "TV", "TW", "TY", "VA", "VC", "VD", "VE", "VF", "VG", "VH", "VI", "VK", "VL", "VM", "VN", "VP", "VQ", "VR", "VS", "VT", "VV", "VW", "VY", "WA", "WC", "WD", "WE", "WF", "WG", "WH", "WI", "WK", "WL", "WM", "WN", "WP", "WQ", "WR", "WS", "WT", "WV", "WW", "WY", "YA", "YC", "YD", "YE", "YF", "YG", "YH", "YI", "YK", "YL", "YM", "YN", "YP", "YQ", "YR", "YS", "YT", "YV", "YW", "YY"));
        try {
            while (f == 1 || target.size() > 50) {
                f = 0;
                ArrayList ans = new ArrayList();
                int[] res = new int[400];
                for (var j = 0; j < 400; j++) res[j] = 0;
                String key = String.valueOf(target.get(1));
                String[] ar = String.valueOf(target.get(1)).split("\t");
                for (int j = 0; j < 400; j++) {
                    String reg = ".*(" + String.valueOf(arr.get(j)) + ").*";
                    Pattern p = Pattern.compile(reg);
                    Matcher m = p.matcher(ar[n]);
                    boolean jud = m.find();
                    if (jud) {
                        res[j] = res[j] + 1;
                    }
                }
                target.remove(1);
                ans.add("class 1:\n"+"key element:"+key+"\n");
                for (int i = 1; i < target.size(); i++) {
                    String[] a = String.valueOf(target.get(i)).split("\t");
                    int[] cot = new int[400];
                    for (int j = 0; j < 400; j++) cot[j] = 0;
                    for (int j = 0; j < 400; j++) {
                        String reg = ".*(" + String.valueOf(arr.get(j)) + ").*";
                        Pattern p = Pattern.compile(reg);
                        Matcher m = p.matcher(a[n]);
                        boolean jud = m.find();
                        if (jud) {
                            cot[j] = cot[j] + 1;
                        }
                    }
                    double sim = cot(cot, res) * 100;
                    if (sim >= min) {
                        f = 1;
                        String str = String.valueOf(target.get(i)) + "\t" + String.valueOf(sim) + "%\n";
                        ans.add(str);
                        target.remove(i);
                    }
                }
                if (f == 1) {
                    sum += 1;
                    int fl = -1;
                    int x=0;
                    if (arr.size()%1000==0){
                        x = arr.size()/1000;
                    }
                    else {
                        x = arr.size()/1000 + 1 ;
                    }
                    System.out.println("第"+sum+"聚类有" + ans.size() + "个元素,每1000个为一页，请输入需要查询的页码(从1开始):");
                    int nn= scan_data.scanint();
                    for (int i = 0; i < ans.size(); i++) {
                        System.out.println(String.valueOf(ans.get(i)));
                    }
                    System.out.println("输入 1 打印当前该页 输入2继续生成其他聚类");
                    int h = scan_data.scanint();
                    if (h == 1) {
                        System.out.println("给你的文件取个名字吧,以tsv结尾:");
                        String myname = scan_data.scan();
                        while (!myname.substring(myname.length()-4).equals(".tsv")) {
                            System.out.println("你取的名字有问题哦 请以.tsv结尾");
                            myname = scan_data.scan();
                        }
                        if (myname.substring(myname.length() - 4).equals(".tsv")) {
                            fl = 2;
                        }
                       if (fl == 2) {
                            operation_out_data.out_data_print(ans, myname,nn, x);
                        }
                    } else if (h == 2) {
                        System.out.println("继续分析");
                        break;
                    } else {
                        System.out.println("输入错误，请检查，已退出");
                        break;
                    }
                }
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static ArrayList okk(ArrayList arr , int n ){
        ArrayList abr = new ArrayList();
        for (int i =1; i<arr.size();i++){
            String []a = String.valueOf(arr.get(i)).split("\t");
            abr.add(a[n].length());
        }
        return abr;
    }
    public static double sum_in_data(ArrayList arr,int n ){
        double sum=0;
        for (int i=1;i<arr.size();i++){
            String []a = String.valueOf(arr.get(i)).split("\t");
            sum+=a[n].length();
        }
        return sum;
    }
    public static ArrayList search_in_data(ArrayList arr,int n,String key){
        ArrayList a=new ArrayList();
        int maxsize = arr.size();
        for (int i =1;i<maxsize;i++){
            String [] opa=String.valueOf(arr.get(i)).split("\t");
            if (String.valueOf(opa[n]).equals(key)){
                a.add(String.valueOf(arr.get(i)));
            }
        }
        return a;
    }
    public static ArrayList search_in_data_fuzzy(ArrayList arr,int n,String key){
        ArrayList a=new ArrayList();
        int maxsize = arr.size();
        for (int i =1;i<maxsize;i++){
            String [] opa=String.valueOf(arr.get(i)).split("\t");
            String reg=".*("+key+").*";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(opa[n]);
            boolean res = m.find();
            if (res){
                a.add(String.valueOf(arr.get(i)));
            }
        }
        return a;
    }
    public static ArrayList search_in_data_fuzzy_sorted(ArrayList arr,int n,String key){
        ArrayList a=new ArrayList();
        int maxsize = arr.size();
        ArrayList old = new ArrayList(Arrays.asList("AA","AC","AD","AE","AF","AG","AH","AI","AK","AL","AM","AN","AP","AQ","AR","AS","AT","AV","AW","AY","CA","CC","CD","CE","CF","CG","CH","CI","CK","CL","CM","CN","CP","CQ","CR","CS","CT","CV","CW","CY","DA","DC","DD","DE","DF","DG","DH","DI","DK","DL","DM","DN","DP","DQ","DR","DS","DT","DV","DW","DY","EA","EC","ED","EE","EF","EG","EH","EI","EK","EL","EM","EN","EP","EQ","ER","ES","ET","EV","EW","EY","FA","FC","FD","FE","FF","FG","FH","FI","FK","FL","FM","FN","FP","FQ","FR","FS","FT","FV","FW","FY","GA","GC","GD","GE","GF","GG","GH","GI","GK","GL","GM","GN","GP","GQ","GR","GS","GT","GV","GW","GY","HA","HC","HD","HE","HF","HG","HH","HI","HK","HL","HM","HN","HP","HQ","HR","HS","HT","HV","HW","HY","IA","IC","ID","IE","IF","IG","IH","II","IK","IL","IM","IN","IP","IQ","IR","IS","IT","IV","IW","IY","KA","KC","KD","KE","KF","KG","KH","KI","KK","KL","KM","KN","KP","KQ","KR","KS","KT","KV","KW","KY","LA","LC","LD","LE","LF","LG","LH","LI","LK","LL","LM","LN","LP","LQ","LR","LS","LT","LV","LW","LY","MA","MC","MD","ME","MF","MG","MH","MI","MK","ML","MM","MN","MP","MQ","MR","MS","MT","MV","MW","MY","NA","NC","ND","NE","NF","NG","NH","NI","NK","NL","NM","NN","NP","NQ","NR","NS","NT","NV","NW","NY","PA","PC","PD","PE","PF","PG","PH","PI","PK","PL","PM","PN","PP","PQ","PR","PS","PT","PV","PW","PY","QA","QC","QD","QE","QF","QG","QH","QI","QK","QL","QM","QN","QP","QQ","QR","QS","QT","QV","QW","QY","RA","RC","RD","RE","RF","RG","RH","RI","RK","RL","RM","RN","RP","RQ","RR","RS","RT","RV","RW","RY","SA","SC","SD","SE","SF","SG","SH","SI","SK","SL","SM","SN","SP","SQ","SR","SS","ST","SV","SW","SY","TA","TC","TD","TE","TF","TG","TH","TI","TK","TL","TM","TN","TP","TQ","TR","TS","TT","TV","TW","TY","VA","VC","VD","VE","VF","VG","VH","VI","VK","VL","VM","VN","VP","VQ","VR","VS","VT","VV","VW","VY","WA","WC","WD","WE","WF","WG","WH","WI","WK","WL","WM","WN","WP","WQ","WR","WS","WT","WV","WW","WY","YA","YC","YD","YE","YF","YG","YH","YI","YK","YL","YM","YN","YP","YQ","YR","YS","YT","YV","YW","YY"));
        int []tar = new int [400];
        for(var j = 0; j < 400; j++) tar[j] = 0;
        for (int j =0 ;j<400;j++){
            String re=".*("+String.valueOf(old.get(j))+").*";
            Pattern pl = Pattern.compile(re);
            Matcher ml = pl.matcher(key);
            boolean jud = ml.find();
            if (jud){
                tar[j]=tar[j]+1;
            }
        }
        for (int i =1;i<maxsize;i++){
            String [] opa=String.valueOf(arr.get(i)).split("\t");
            String reg=".*("+key+").*";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(opa[n]);
            boolean res = m.find();
            if (res) {
                int[] cot = new int[400];
                for (int j = 0; j < 400; j++) cot[j] = 0;
                for (int j = 0; j < 400; j++) {
                    String regex = ".*(" + String.valueOf(old.get(j)) + ").*";
                    Pattern pr = Pattern.compile(regex);
                    Matcher mr = pr.matcher(opa[n]);
                    boolean jud = mr.find();
                    if (jud) {
                        cot[j] = cot[j] + 1;
                    }
                }
                DecimalFormat df=new DecimalFormat("0.000000");
                double ans = (cot(cot, tar)*100);
                String str = String.valueOf(arr.get(i)) +"\t" + String.valueOf(df.format(ans))+"%"+"\n";
                a.add(str);
            }
        }
        final Pattern pattern = Pattern.compile("\\t(\\d+\\.\\d+)%");
        a.sort((s1,s2) -> {
            final Matcher m1 = pattern.matcher(String.valueOf(s1));
            final Matcher m2 = pattern.matcher(String.valueOf(s2));
            final String sub1 = m1.find() ? m1.group(1) : "";
            final String sub2 = m2.find() ? m2.group(1) : "";
            return Double.compare(Double.parseDouble(sub1),
                    Double.parseDouble(sub2));
        });
        return a;
    }
    public static ArrayList input_in_csv(String file)throws IOException{
        ArrayList arr = new ArrayList();
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();//connect the sqlite
            String sql = null;
            if (file.equals("swiss.fa")){
                sql="select * from swissfa";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="proteins"+","+"sequences\n";
                arr.add(init);
                while(rs.next()){
                    String pro=rs.getString("proteins");
                    String seq=rs.getString("sequences");
                    String res =pro+","+seq+"\n";
                    arr.add(res);
                }
            }
            else if (file.equals("cafa.fa")){
                sql="select * from cafafa";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="proteins"+","+"sequences\n";
                arr.add(init);
                while(rs.next()){
                    String pro=rs.getString("proteins");
                    String seq=rs.getString("sequences");
                    String res =pro+","+seq+"\n";
                    arr.add(res);
                }
            }
            else if (file.equals("cafa.tsv")){
                sql="select * from cafatsv";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="index"+","+"proteins"+","+"sequences"+","+"annotations\n";
                arr.add(init);
                while(rs.next()){
                    Integer idx = rs.getInt("idx");
                    String pro=rs.getString("proteins");
                    String seq=rs.getString("sequences");
                    String ann= rs.getString("annotations");
                    String res =String.valueOf(idx)+","+pro+","+seq+","+ann+"\n";
                    arr.add(res);
                }
            }
            else if (file.equals("swiss.tsv")){
                sql="select * from swisstsv";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="index"+","+"proteins"+","+"accessions"+","+"sequences"+","+"annotations"+","+"interpros"+","+"orgs\n";
                arr.add(init);
                while(rs.next()){
                    Integer idx = rs.getInt("idx");
                    String pro=rs.getString("proteins");
                    String acc=rs.getString("accessions");
                    String seq=rs.getString("sequences");
                    String ann= rs.getString("annotations");
                    String inr= rs.getString("interpros");
                    Integer orgs =rs.getInt("orgs");
                    String res =String.valueOf(idx)+","+pro+","+acc+","+seq+","+ann+","+inr+","+String.valueOf(orgs)+"\n";
                    arr.add(res);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }
    public static ArrayList input_in_tsv(String file)throws IOException{
        ArrayList arr = new ArrayList();
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();//connect the sqlite
            String sql = null;
            if (file.equals("swiss.fa")){
                sql="select * from swissfa";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="proteins"+"\t"+"sequences\n";
                arr.add(init);
                while(rs.next()){
                    String pro=rs.getString("proteins");
                    String seq=rs.getString("sequences");
                    String res =pro+"\t"+seq+"\n";
                    arr.add(res);
                }
            }
            else if (file.equals("cafa.fa")){
                sql="select * from cafafa";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="proteins"+"\t"+"sequences\n";
                arr.add(init);
                while(rs.next()){
                    String pro=rs.getString("proteins");
                    String seq=rs.getString("sequences");
                    String res =pro+"\t"+seq+"\n";
                    arr.add(res);
                }
            }
            else if (file.equals("cafa.tsv")){
                sql="select * from cafatsv";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="index"+"\t"+"proteins"+"\t"+"sequences"+"\t"+"annotations\n";
                arr.add(init);
                while(rs.next()){
                    Integer idx = rs.getInt("idx");
                    String pro=rs.getString("proteins");
                    String seq=rs.getString("sequences");
                    String ann= rs.getString("annotations");
                    String res =String.valueOf(idx)+"\t"+pro+"\t"+seq+"\t"+ann+"\n";
                    arr.add(res);
                }
            }
            else if (file.equals("swiss.tsv")){
                sql="select * from swisstsv";//表名
                ResultSet rs=st.executeQuery(sql);
                String init="index"+"\t"+"proteins"+"\t"+"accessions"+"\t"+"sequences"+"\t"+"annotations"+"\t"+"interpros"+"\t"+"orgs\n";
                arr.add(init);
                while(rs.next()){
                    Integer id = rs.getInt("idx");
                    String pro=rs.getString("proteins");
                    String acc=rs.getString("accessions");
                    String seq=rs.getString("sequences");
                    String ann= rs.getString("annotations");
                    String inr= rs.getString("interpros");
                    Integer orgs =rs.getInt("orgs");
                    String res =String.valueOf(id)+"\t"+pro+"\t"+acc+"\t"+seq+"\t"+ann+"\t"+inr+"\t"+String.valueOf(orgs)+"\n";
                    arr.add(res);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }
    public static void out_data_scan(ArrayList arr,int num,int maxsize)throws IOException{//file 源文件  outfile目标文件
        try{
            String init =String.valueOf(arr.get(0));
            if (num==maxsize){
                for (int i=(num-1)*1000;i<arr.size();i++){
                    String res = String.valueOf(arr.get(i)).substring(0,String.valueOf(arr.get(i)).length()-1);
                    System.out.println(res);
                }
            }
            else {
                for (int i =(num-1)*1000;i<num*1000;i++){
                    String res = String.valueOf(arr.get(i)).substring(0,String.valueOf(arr.get(i)).length()-1);
                    System.out.println(res);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void out_data_print(ArrayList arr,String outfile,int num,int maxsize)throws IOException{//file 源文件  outfile目标文件
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement st=con.createStatement();//connect the sqlite
            FileOutputStream fos = new FileOutputStream(outfile);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            {
                bw.flush();
            }
            File file1 =new File(outfile);
            FileWriter fileWritter = new FileWriter(file1.getName(),true);
            String init =String.valueOf(arr.get(0));
            fileWritter.write(init);
            if (num==maxsize){
                for (int i=(num-1)*1000+1;i<arr.size();i++){
                    String res = String.valueOf(arr.get(i));
                    fileWritter.write(res);
                }
            }
            else {
                for (int i =(num-1)*1000+1;i<=num*1000;i++){
                    String res = String.valueOf(arr.get(i));
                    fileWritter.write(res);
                }
            }
            fileWritter.close();
            System.out.println("printing data success !");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}