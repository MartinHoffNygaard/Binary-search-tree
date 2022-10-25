package no.oslomet.cs.algdat.Oblig3;


import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) { //La inn Programkode 5.2.3 a) fra kompendiet
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<T>(verdi, q);                   // oppretter en ny node, her gjorde jeg endringer fra koden i kompendiet og satt q som foreldrenode

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        endringer++;                             // La også til oppdatering av variabelen endringer
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        if(verdi == null) return 0; //returner 0 om det er en null verdi
        Node<T> p = rot; //starter å traversere treet fra roten
        int antallAvVerdi = 0; //variabel for å telle antall av verdien

        while(p != null) { //traverserer gjennom treet til vi kommer passerer bladnode
            int cmp = comp.compare(verdi, p.verdi); //sjekker om verdien er i noden.
            if(cmp == 0) { //om verdien er i node så øker telleren
                antallAvVerdi++;
                p = p.høyre; //fortsetter å traversere treet til høyre barn i tilfelle det finnes flere av verdien
            }
            if(cmp < 0) p = p.venstre; //går til venstre barn om verdien er mindre
            if(cmp > 0) p = p.høyre; //går til høyre barn om verdien er større
        }

        return antallAvVerdi; //returner antall av verdien
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        while(true) { //løkke som traverserer gjennom treet
            if(p.venstre != null) p = p.venstre; //beveger seg først lengst mulig til venstre
            else if(p.høyre != null) p = p.høyre; //så beveger seg til høyre om det går når det ikke finnest venstre barn
            else return p; //returnerer den første i postorden
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        if(p.forelder == null) return null; //sjekker om noden er en rotnode, da finnes det ikke en neste
        if(p.forelder.høyre == null || p.forelder.høyre == p) { //sjekker om forelderen til noden har ett høyre barn != p
            return p.forelder; //om den ikke har ett høyre barn så er foreldrenoden neste i postorden
        }
        return førstePostorden(p.forelder.høyre); //finner første i postorden på subtreet med foreldren sitt høyre barn som rot
    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = førstePostorden(rot); //starter på den første noden i postorden
        while(p != null) { //løkke til å traversere gjennom treet i postorden til vi når slutten
            oppgave.utførOppgave(p.verdi); //utfører oppgaven på verdien til noden vi er på i postorden
            p = nestePostorden(p); //beveger seg videre til den neste i postorden
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if(p != null) { //Basistilfelle når vi har beveget oss utenfor treet
            postordenRecursive(p.venstre, oppgave); //rekursivt kall som traverserer først helt ned til venstre i treet
            postordenRecursive(p.høyre, oppgave); //rekursivt kall som traverserer helt til høyre i den vestre delen av treet
            oppgave.utførOppgave(p.verdi); //utfører oppgave på verdien til noden i postorden
        }
    }

    public ArrayList<T> serialize() {
        ArrayList<T> listeAvTre = new ArrayList<>(); //opretter en liste som skal returneres
        if(tom()) return listeAvTre; //om treet er tomt så returneres bare en tom liste
        Deque<Node<T>> kø = new ArrayDeque<>(); //lager en kø som kan inneholde noder

        kø.add(rot); //legger rotnoden inn i køen

        while(!kø.isEmpty()) { //løkke som går så lenge køen ikke er tom
            Node<T> p = kø.removeFirst(); //fjerner den første i køen
            listeAvTre.add(p.verdi); //legger til verdien fra noden som ble fjernet i output listen
            if(p.venstre != null) kø.add(p.venstre); //legger til venstre barn til noden som blir fjernet om barnet finnes
            if(p.høyre != null) kø.add(p.høyre); //legger til høyre barn til noden som blir fjernet om barnet finnes
        }
        return listeAvTre; //returnerer output listen
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
       SBinTre<K> tre = new SBinTre<>(c); //oppretter ett binært søketre med komparatoren
       for(K verdi : data) { //går gjennom alle verdiene som finnes i input listen
           tre.leggInn(verdi); //legger inn verdiene fra inputlisten i treet
       }
       return tre; //returnerer treet
    }


} // ObligSBinTre
