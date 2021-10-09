
public  class MineBase {
	static int a;
	int b;
public MineBase() {
int c;
c = a;
a++;
b += c;
}
public static void main(String args[]) {
new MineBase();

System.out.println(a);
}
}