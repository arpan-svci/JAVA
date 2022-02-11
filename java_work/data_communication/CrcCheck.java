package data_communication;

public class CrcCheck {
    public static void main(String[] args) {
        String data="1001101";  //1101
        String generator="10110";
        String datawords=datawords(data, generator);
        String code=crc_codeWords(datawords,generator);
        System.out.println(code);
        System.out.println(crc_codeWords(code,generator));
    }
    public static String datawords(String data,String generator){
        int length=generator.length();
        StringBuffer sb=new StringBuffer();
        sb.append(data);
        for(int i=0;i<length;i++){
            sb.append("0");
        }
        return sb.toString();
    }
    public static char bitXor(char a,char b){
        if(a==b)
            return '0';
        else
            return '1';
    }
    public static String xor(String a,String b){
        StringBuffer result=new StringBuffer();
        for(int i=0;i<b.length();i++){
            result.append(Character.toString(bitXor(a.charAt(i), b.charAt(i))));
        }
        return result.toString();
    }
    public static String crc_codeWords(String datawords,String generator){
        String codeWord=new String();
        StringBuffer n=new StringBuffer();
        int generator_length=generator.length();
        for(int i=0;i<generator_length;i++){
            n.append("0");
        }
        String zero=n.toString();
        int length=datawords.length(),curser=generator_length;
        String div=datawords.substring(0,curser);
        String remain=new String();
        while(curser<=length){
            StringBuffer sb=new StringBuffer();
            if(div.charAt(0)=='0'){
                remain=xor(zero, div);
            }
            else{
                remain=xor(generator, div);
            }
            System.out.println(remain);
            if(curser==length)
                break;
            sb.append(remain.substring(1,generator_length));
            sb.append(Character.toString(datawords.charAt(curser)));
            div=sb.toString();
            System.out.println(div);
            curser++;
        }
        StringBuffer code=new StringBuffer();
        code.append(datawords.substring(0,length-generator_length));
        code.append(remain);
        codeWord=code.toString();
        return codeWord;
    }
}
