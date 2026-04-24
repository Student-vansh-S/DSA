public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } 
            else if (log.equals("./")) {
                // do nothing
            } 
            else {
                depth++; // go into folder
            }
        }

        return depth;
    }
    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        CrawlerLogFolder cl = new CrawlerLogFolder();
        System.out.println(cl.minOperations(logs));
    }
}
