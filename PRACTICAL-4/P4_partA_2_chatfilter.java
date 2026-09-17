public class P4_partA_2_chatfilter {
    public static void filter(String[] logs,String key) {
        int count=0;
        StringBuilder report=new StringBuilder();

        for(String line:logs) {
            String[] p=line.split(" ",3);

            if(p.length<3)
                continue;

            String time=p[0];
            String user=p[1];
            String msg=p[2];

            if(msg.toLowerCase().contains(key.toLowerCase())) {
                count++;
                report.append(time+" "+user+": "+msg+"\n");
            }
        }

        System.out.println("Matches: "+count);
        System.out.print(report);
    }
}