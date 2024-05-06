public class Solution{
    public static int towerBreakers(int n,int m){
        if(n%2==0||m==1){return 2;}else{return 1;}}
    public static void main(String[]args){
        System.out.println(towerBreakers(2,2));}}