class Matric {
    double kilometer;
    double mile;
    void mile_to_km(double km){
        kilometer=km;
        mile=km/1.5;
    }
    void km_to_mile(double m){
        mile=m;
        kilometer=m*1.5;
    }
    Matric(){
        kilometer=0.0;
        mile=0.0;
    }
}
class Execute{
    public static void main(String args[]){
      Matric m=new Matric();
      m.km_to_mile(1000.0);
      System.out.print(m.kilometer+"   "+m.mile); 
      System.out.print("\n\n");
      m.mile_to_km(3000);
      System.out.print(m.kilometer+"   "+m.mile);
    }
}
