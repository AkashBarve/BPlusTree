import java.util.*;
import java.io.*;

//Define class treesearch which contains the main method
public class treesearch{
    public static void main(String[] args){
        b_plus_tree bptree = new b_plus_tree();
        //Get input file name from the command line argument
        File file = new File(args[0]);
        FileReader fileReader = null;
        PrintWriter writer;
        writer = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException f) {
            System.out.println("File not found at path "+file.getAbsolutePath());

        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line=null;
        try {
            line = bufferedReader.readLine();
            //Write output to file named "output_file.txt"
            writer = new PrintWriter("output_file.txt");
            int order = Integer.parseInt(line);
            bptree.tree_degree = order-1;
            while ((line = bufferedReader.readLine()) != null) {
                String str = line.substring(0, line.indexOf("("));
                //Use switch case to perform the appropriate operation depending on the input
                switch (str) {
                    case "Insert":
                        Double key = Double.parseDouble(line.substring(line.indexOf("(")+1, line.indexOf(",") ));
                        String value = (line.substring(line.indexOf(",")+1, line.indexOf(")") ));
                        bptree.tree_insert(key,value);
                        break;
                    case "Search":
                        Integer searchType = line.indexOf(",");
                        //Search can either be simple search or a range search
                        switch (searchType) {
                            case -1:
                                Double keyToSearch = Double.parseDouble(line.substring(line.indexOf("(")+1, line.indexOf(")") ));
                                ArrayList<String> output;
                                output = bptree.value_search(keyToSearch);
                                if (output != null){
                                    String outputString = output.toString().replace("[","").replace("]","");
                                    writer.println(outputString);
                                }
                                else{
                                    writer.println("Null");
                                }

                                break;
                            default:
                                Double leftKey = Double.parseDouble(line.substring(line.indexOf("(")+1, line.indexOf(",") ));
                                Double rightkey = Double.parseDouble(line.substring(line.indexOf(",")+1, line.indexOf(")")));
                                StringBuilder outputString = bptree.range_search(leftKey, rightkey);
                                if (outputString.toString().equals("")){
                                    writer.println("Null");
                                }
                                else{

                                    String rangeOutput = outputString.toString();
                                    String trimmedRangeOutput = rangeOutput.substring(0,(rangeOutput.length()-2));
                                    writer.println(trimmedRangeOutput);
                                }


                                break;
                        }
                }
            }
            fileReader.close();
        }
        catch (UnsupportedEncodingException f) {
            System.out.println("Unsupported encoding at "+file.getAbsolutePath());

        } 
        catch (IOException exc) {
            System.out.println("IOException while reading the file or trying to close the file ");
        }
        finally {
            writer.close();
        }

    }
}