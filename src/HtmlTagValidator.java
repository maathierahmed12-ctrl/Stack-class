import java.util.MissingFormatArgumentException;
import java.util.Stack;

public class HtmlTagValidator {
    public static void main(String [] args){

    }

        Stack<String>Html = new Stack<>();

    String [] tests = {
            "<html><html1><htm o>",
            "<Hello html><h>",
            "<Good html><g>",
            "<html 11><h11>",
            "<html happy><ha>",
            "<html oo><oo>",
            "<html k><k>",
            "<html p><p>",
    };
            for(String tests : test){

        System.out.println("test :"+ "test" + "----");
        Boolean result = validateHtmlTags("test");
        System.out.println("result :"+ (result ? "Valid" : "Invalid"));
    }
}

   public static Boolean validateHtmlTags (String HTML ){

    if(HTML == null || HTML.isEmpty()){
        System.out.println("empty");
        return true;

    }
    Stack<String>stack=new Stack<>();

    for(int i = 0 ; i < HTML.length(); i++){
        if (HTML.charAt(i) == '<') {
            int end = HTML.indexOf('>', i);
            if (end == -1) {
                System.out.println("Error :" + "tag not closed ");
                return false;
            } else{
                if(HTML.startsWith("/")){
                    System.out.println("Self-closing tag, skip");

                    String tagname = HTML.substring(1);

                    if(HTML.isEmpty()){

                        System.out.println("Error:"+ "Mismatch ! expected" );

                        return false;
                    }
                    String top = stack.pop();
                    System.out.println("Error:"+ "closing ! expected < /" + top + "but found </" + tagname + ">" );
                    return false;

                    if(! top.equals(tagname)){
                        System.out.println("Error: Mismatch! expected </" + top + "> but found </" + tagname + ">");
                        return false;

                    }
                   else
                }
                     String tagname = tagname.split("")[0];

                   stack.push(tagname);
                   System.out.println("push : " + tagname);
                }
            System.out.println("stack :" + stack);
            i= end;
        }
    }
    if(! stack.isEmpty()){
        System.out.println("error : "+ "Unclosed tag :"  + stack);
        return false;
    }
      return true;
   }
