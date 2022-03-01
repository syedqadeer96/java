import java.io.File;
import java.util.Scanner;

public class Main1 {
    String res="File not found";
    public void rFindFile(String fileToBeFound,File folders){
        String[] str=folders.list();
        if(str==null){
            return;
        }
        for (String currFile : str) {
            if(fileToBeFound.equals(currFile)){
                res="File found:"+currFile+"\n"+folders.getAbsolutePath();
                return;
            }
            File NewFolder=new File(folders.getAbsolutePath()+"/"+currFile);
            if(NewFolder.exists()) {
                rFindFile(fileToBeFound, NewFolder);
            }
        }
    }

    public void findFile()
    {
        File folders = new File("/home");
        String str ;
        Scanner in = new Scanner(System.in);
        while(true){
            res="file not found";
            System.out.println("ENTER THE NAME OF THE FILE");
            str =in.nextLine();
            this.rFindFile(str,folders);
            System.out.println(res);
        }
    }

    public static void main(String[] args){
        Main1 obj =new Main1();
        obj.findFile();
    }
}