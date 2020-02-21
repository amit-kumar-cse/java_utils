// Recursive Java program to print all files
// in a folder(and sub-folders)

import java.io.File;

public class PrintFileNamesInDirectory
{
    static int RecursivePrint(File[] arr,int index,int level, int fileNumber)
    {
        //debugging code
//        System.out.println("arr: " + arr.toString());
//        System.out.println("arr.length: " + arr.length);
//        System.out.println("index: " + index);
//        System.out.println("level: " + level);
//        System.out.println("fileNumber: " + fileNumber);


        // terminate condition
        if(index == arr.length)
            return fileNumber;

        //ignore directories starting with .
        String filename = arr[index].getName();
        if(filename.charAt(0)=='.'){
            //do nothing
        }
        // for files
        else if(arr[index].isFile()) {
            if(!".DS_Store".equals(filename)) {
                System.out.print(++fileNumber + ": ");
                System.out.println(filename);
            }
        }
        // for sub-directories
        else if(arr[index].isDirectory())
        {
            // recursion for sub-directories
            fileNumber = RecursivePrint(arr[index].listFiles(), 0, level + 1, fileNumber);
        }

        // recursion for main directory
        fileNumber = RecursivePrint(arr,++index, level, fileNumber);
        return fileNumber;
    }

    // Driver Method
    public static void main(String[] args)
    {
        // Provide full path for directory(change accordingly)
        String maindirpath = "/Volumes/STRONTIUM64";
//        String maindirpath = "/Volumes/TranscendCard/SP_all_lectures_in_order";

        // File object
        File maindir = new File(maindirpath);

        if(maindir.exists() && maindir.isDirectory())
        {
            // array for files and sub-directories
            // of directory pointed by maindir
            File arr[] = maindir.listFiles();

            // Calling recursive method
            RecursivePrint(arr,0,0, 0);
        }
    }
}
