import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class Node {

    int x;
    int y;
    String data;
    Node next;
    Node previous;


    public Node(int x , int y, String ch) {
        this.x =x;
        this.y =y;
        this.data=ch;
    }

    public Node getNext() {
        return next;
    }
}
/**
 * LinkedList
 */
class LinkedList {

    int size;
    Node head;
    Node tail;
    int cordx;
    int cordy;
    String ch;

    public LinkedList(){
        size=0;
        this.head=null;
        this.tail=null;
    }

    public void addAtFirst(int x,int y, String ch) {
        Node newNode = new Node(x,y,ch);
        head.previous=newNode;
        newNode.next=head;
        head=newNode;
        }

    public void insert(int x,int y,String ch) {
        Node n = new Node(x,y,ch);
        if(head==null){
            head = tail = n;
            head.previous = null;
            tail.next = null;
        }else{
            tail.next = n;
            n.previous = tail;
            tail= n;
            tail.next=null;
        }
        size++;
    }

    public boolean changeData(char a) {

        if(head.x==29){
            head.x=1;
        }
        if(head.x<=0){
            head.x=29;
        }
        if(head.y==49){
            head.y=1;
        }
        if(head.y<=0){
            head.y=49;
        }

        

        if(a=='w'){
            Node temp=tail;
            Node t=tail;
            while (temp!=head) {
                temp=temp.previous;
                t.x=temp.x;
                t.y=temp.y;
                t=t.previous;
            }
            head.x=head.x-1;


        }

    else if(a=='a'){
        Node temp=tail;
            Node t=tail;
            while (temp!=head) {
                temp=temp.previous;
                t.x=temp.x;
                t.y=temp.y;
                t=t.previous;
            }
            head.y=head.y-1;

    }
    else if(a=='s'){
        Node temp=tail;
            Node t=tail;
            while (temp!=head) {
                temp=temp.previous;
                t.x=temp.x;
                t.y=temp.y;
                t=t.previous;
            }
            head.x=head.x+1;

    }
    else if(a=='d'){
        Node temp=tail;
            Node t=tail;
            while (temp!=head) {
                temp=temp.previous;
                t.x=temp.x;
                t.y=temp.y;
                t=t.previous;
            }
            head.y=head.y+1;

    }
    Node ta =head.next;
        while (ta!=null) {

            if(head.x == ta.x && head.y==ta.y || head.x == ta.y && head.y==ta.x){
                return false;
            }
            ta=ta.next;
        }
    
    return true;
}
    public void viewList(Node t) {
            cordx=t.x;
            cordy =t.y;
            ch = t.data;
    }
}


 class Main {
    static int randx;
    static int randy;
    public static void main (String[] args) {
        int n=30;
        int m=50;
        char prevMove='p';
        String[][] board = new String[n][m];
        
        Random rn = new Random();
        getFood(rn);
        makeBoard(n, m, board);
        Scanner sc = new Scanner(System.in);
        
        LinkedList snake = new LinkedList();

        snake.insert(5, 10, "A");
        snake.insert(6, 10, "X");
        snake.insert(7, 10, "X");
        snake.insert(8, 10, "X");
        snake.insert(9, 10, "Y");

        Node t = snake.head;

        while (t!= null) {
            snake.viewList(t);
            board[snake.cordx][snake.cordy] = snake.ch;
            
            t = t.getNext();

        }
        printBoard(board,n,m);

        Boolean gameison = true;

        while (gameison) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        char entry = 'w';

        if(entry=='w' && prevMove!='s'){
            t=snake.head;
            makeBoard(n, m, board);
            if(snake.changeData('w')){
            while (t!= null) {
                snake.viewList(t);
                board[snake.cordx][snake.cordy] = snake.ch;
                
                
                t = t.getNext();
    
            }
            if(snake.head.x==randx && snake.head.y==randy){
                Node temp=snake.head;
                snake.addAtFirst(randx, randy, "A");
                temp.data="X";
                getFood(rn);
                
            }
            prevMove='w';
            printBoard(board,n,m);
        }
        else{
            System.out.println("You loose");
            return;
        }
    }
        else if(entry=='a' && prevMove!='d'){
            t=snake.head;
            
            makeBoard(n, m, board);
            if(snake.changeData('a')){
            while (t!= null) {
                snake.viewList(t);
                board[snake.cordx][snake.cordy] = snake.ch;
                
                t = t.getNext();
    
            }
            if(snake.head.x==randx && snake.head.y==randy){
                Node temp=snake.head;
                snake.addAtFirst(randx, randy, "A");
                temp.data="X";
                getFood(rn);
                
            }
            
            prevMove='a';
            printBoard(board,n,m);
        }else{
            System.out.println("You loose");
            return;
        }
        }
        else if(entry=='s' && prevMove!='w' ){
            t=snake.head;
            
            makeBoard(n, m, board);
            if(snake.changeData('s')){
            while (t!= null) {
                snake.viewList(t);
                board[snake.cordx][snake.cordy] = snake.ch;
                
                t = t.getNext();
    
            }
            if(snake.head.x==randx && snake.head.y==randy){
                Node temp=snake.head;
                snake.addAtFirst(randx, randy, "A");
                temp.data="X";
                getFood(rn);
                
            }
            prevMove='s';
            printBoard(board,n,m);
        }else{
            System.out.println("You loose");
            return;
        }
        }
        else if(entry=='d'&& prevMove!='a' ){
            t=snake.head;
            makeBoard(n, m, board);
            if(snake.changeData('d')){
            while (t!= null) {
                snake.viewList(t);
                board[snake.cordx][snake.cordy] = snake.ch;
                
                t = t.getNext();
    
            }
            if(snake.head.x==randx && snake.head.y==randy){
                Node temp=snake.head;
                snake.addAtFirst(randx, randy, "A");
                temp.data="X";
                getFood(rn);
                
            }
            prevMove='d';
            printBoard(board,n,m);
        }else{
            System.out.println("You loose");
            return;
        }
        }
        else if(entry=='q')
        {
            gameison=false;
        }
        else{
            System.out.println("invalid Move");
        }
        
        sc.close();
    }

    }

    public static void getFood(Random rn) {
        int min =1;
        int max=28;
        int max2=48;
        randx = rn.nextInt((max-min)+1)+min;
        randy = rn.nextInt((max2-min)+1)+min;
    }

    public static void printBoard(String board[][],int n,int m) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    public static void makeBoard(int n,int m, String board[][]) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==10 && j==20){
                    board[i][j]="F";
                }
                if(i==0 || j==m-1 || i==n-1|| j==0){
                board[i][j]="#";
                }
                else{
                    board[i][j]=" ";
                }
            }
        }
        board[randx][randy]="F";
    }
}