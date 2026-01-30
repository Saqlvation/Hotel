public class Hotel {
    private String nome;
    private Stanza stanze[];
    private static final int MAX_STANZE = 30;
    private int max_capienza;


    public Hotel(){
        stanze = new Stanza[MAX_STANZE];
    }


    public Hotel(String nome,int vettore []){ // devo passarli un nome e un vettore , il vettore mi dara il num di stanze e gli ospiti da mettere in hotel        stanze = new Stanza[MAX_STANZE];
        for (int i = 0; i < vettore[0]; i++) {
            stanze[i] = new Stanza(vettore[i + 1]);
}
        this.nome = nome;

       
    }


    public String toString(){
        String s = " ";
        for(int i=0; i < max_capienza; i++){
            s+= stanze[i].toString();
        
        }
        return s;
    }













}
