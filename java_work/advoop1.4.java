import java.util.Random;
class My1_String{
String []str=new String[11];
String generateStrig(){
    int i;
    Random r=new Random();
    i=r.nextInt(10);
    return str[i];   
    }
    My1_String(){
        str[0]=new String("God helps them that help themselves--Benjamin Franklin");
        str[1]=new String("Happyness is not a reward-it is consequence.Suffering is not a punishment-it is a result--robert Green Ingersoll");
        str[2]=new String("the period of time in which our affairs prosper,our friends are true and our happyness is assured.--ambrose Bierce");
        str[3]=new String("honesty is the first chapter of book of wishdom.--Thomash jefferson");
        str[4]=new String("Dream is not what yoy see in sleep,dream is something which doesnot let you sleep-Dr.A.P.J.Abdul Kalam");
        str[5]=new String("Arise,awake and donot stop until the goal is reached-Swami Vivekananda");
        str[6]=new String("Imagination is more important than knowledge.-Albert Einstein");
        str[7]=new String("History repeats itself,first as tragedy,second as farce.--Karl Marx");
        str[8]=new String("It always seems impossible until it is done--Nelson Mandela");
        str[9]=new String("The only time you fail is when you fall down and stay down--Stephen Richards");
        str[10]=new String("The best preparation for tomorrow is doing your best today.-H.Jackson Brown");
    }
}
class QuoteOfTheDay{
    public static void main(String[]args){
        My1_String s=new My1_String();
        System.out.println(s.generateStrig());
    }
}