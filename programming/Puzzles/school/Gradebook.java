public class GradeBook{
  
  static int[][] students = new int[20][4];
  
  public static void init(){
    
    for(int i = 0; i < students.length; i++){
      for(int j = 0; j < students[i].length; j++){
        students[i][j] = (int)(60+Math.random()*40);
      }
      
    }
  }
  
  public static void printArr(){
    
    for(int i = 0; i < students.length; i++){
      for(int j = 0; j < students[i].length; j++){
        System.out.print(students[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static void printAvg(){
    
    for(int i = 0; i < students.length; i++){
      
      double s = 0.0;
      int l = students[i].length;
      
      for(int j = 0; j < l; j++){
        s += students[i][j];
      }
      
      System.out.println("Student Average #" + i + ": " + (s / l));
    }
  }
  
  public static void main(String[] args){
    init();
    printArr();
    printAvg();
  }
  
}
