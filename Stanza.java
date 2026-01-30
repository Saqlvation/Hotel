/**
 * Classe Stanza di un Hotel
 * La stanza di un Hotel è caratterizzata dalla sua capienza (min 1 e max 5), in 
 * base alla quale ha la possibilità di ricevere ospiti. Se ha già accolto ospiti, 
 * può congedarli, non necessariamente uno alla volta. 
 * La stanza può essere libera o occupata.
 * 
 * Hotel
 * Un hotel contiene un certo numero di stanze, nei quali alloggia i suoi clienti. 
 * Progettare la classe Hotel con tutti i metodi standard che permetta di 
 * gestire un hotel.
 * 
 * Main Program
 * Progettare un programma che permetta di eseguire il check in e il check out delle persone. 
*/
public class Stanza 
{
    public static final int MAX_CAPIENZA=5;
    public static final int MIN_CAPIENZA=1;
    private static final int CAPIENZA_STANDARD=2;


    private int nOspiti;
    private int capienza;
    private boolean occupata;

    /**
     * Costruttore che costruisce una stanza con una data capienza, senza ospiti
     * è libera
     * @param capienza la capienza della stanza, compresa tra MIN_CAPIENZA 
     * e MAX_CAPIENZA
     */
    public Stanza (int capienza)
    {
        nOspiti = 0;
        occupata = false;
        setCapienza(capienza);
    }

    /**
     * Costruisce una stanza con capienza standard
     */
    public Stanza()
    {
        this(CAPIENZA_STANDARD);
    }
    
    /**
     * Crea una stanza copia di quella passata come parametro. Se il parametro è
     * nulla crea una stanza standard
     * @param altrStanza la stanza di cui creare la copia
     */
    public Stanza (Stanza altrStanza) {
        this(CAPIENZA_STANDARD);
        if (altrStanza != null) {
            this.capienza = altrStanza.capienza;
            this.occupata = altrStanza.occupata;
            this.nOspiti = altrStanza.nOspiti;
        }
    }

    /**
     * Metodo privato che imposta, controllandone i valori, la capienza di 
     * una stanza. Se il parametro è compreso tra MIN_CAPIENZA e MAX_CAPIENZA
     * imposta la capienza al valore del parametro e restituisce tale valore
     * altrimenti imposta la capienza  a quella standard e restituisce -1
     * restituisce imposta la capienza alla capienza standard e restituisce -1
     * @param capienza la capienza della stanza
     */
    private int setCapienza(int capienza) {
        if(capienza<=MAX_CAPIENZA && capienza>=MIN_CAPIENZA){
            this.capienza = capienza;
            return capienza;
        }
        else {
            this.capienza=CAPIENZA_STANDARD;
            return -1;
        }
    }

    /**
     * @return il numero di ospiti presenti nella stanza
     */
    public int getNospiti()
    {
        return nOspiti;
    }

    /**
     * @return restituisce la capienza della stanza
     */
    public int getCapienza()    
    {
        return capienza;
    }

    /**
     * @return true se la stanza è occupata, false altrimenti
     */
    public boolean isOccupata()
    {
        return occupata;
    }

    /**
     * Accoglie le persone in una stanza se è possibile altrimenti segnala che non 
     * è possibile
     * @param persone numero persone da ospitare
     * @return numero persone ospitate in caso di successo, -1 se la stanza è 
     * occupata, -2 se le persone superano la capienza o inferiori a 1
     */
    public int accogli(int persone)
    {
        if(occupata)
            return -1;//stanza occupata
         
        if(persone>capienza ||persone<MIN_CAPIENZA)
            return -2;//capienza superata o numero di persone errate 
        
        nOspiti=persone;
        occupata=true; 
        return persone;        
    }
    /**
     * Metodo che esegue il checkout di un certo numero di persone presnti nella stanza. 
     * In caso il parametro persone superino il numero di ospiti le congeda tutte.
     * @param persone numero persone da congedare 
     * @return il numero di persone congedate se il metodo ha successo, -1 se la 
     * stanza è vuota, -2 se il numero di persone è zero o inferirore
     */
    public int congeda(int persone)
    {
        if(occupata==false)
            return -1;//la stanza non è occupata da nessuno
        if(persone<=0)
            return -2;//numero di persone invalido
        
        if(persone <= nOspiti) {
            nOspiti = nOspiti-persone;
            return persone;
        }
        else {
            //devo restituire un numero pari al numero di ospiti, uso il parametro direttamente
            persone = nOspiti;
            nOspiti = 0; 
            return persone;
        }
    }

    @Override
    public String toString()
    {
        String msg=capienza+" posti, ";
        if(occupata)
            msg += nOspiti+" persone presenti";
        else 
            msg=msg+"libera";

        return msg;
    }

}
