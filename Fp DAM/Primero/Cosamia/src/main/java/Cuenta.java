class Cuenta {
    int a;
    int b; 
    public void setData(int a, int b) { 
        this.a = a; 
        this.b = b;
    }
    public void showData() {  
        System.out.println("Valor de A =" + a);  
        System.out.println("Valor de B =" + b);
    }
    public static void main(String args[]) {  
        Cuenta obj = new Cuenta();  
        obj.setData(2, 3);  
        obj.showData();
    }
}
